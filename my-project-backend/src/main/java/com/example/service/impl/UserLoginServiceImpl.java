package com.example.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.config.exception.base.BizErrorCode;
import com.example.config.exception.base.BizException;
import com.example.entity.orm.User;
import com.example.entity.vo.user.CheckAuthRequest;
import com.example.entity.vo.user.CheckAuthResponse;
import com.example.entity.vo.user.UserLoginRequest;
import com.example.entity.vo.user.UserLoginResponse;
import com.example.mapper.UserMapper;
import com.example.service.IUserLoginService;
import com.example.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 用户登录服务实现。
     * @param request 包含用户名和密码的登录请求。
     * @return 如果登录成功，返回包含token、用户id、用户名、手机号和性别的用户登录响应；否则抛出异常。
     */
    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        log.info("Begin UserLoginServiceImpl.login: request:" + request);
        UserLoginResponse response = new UserLoginResponse();
        try {
            // 1. 验证用户是否存在
            User user = selectByUserName(request.getUserName());
            if (user == null) {
                throw new BizException(BizErrorCode.AUTH_ERROR);
            }
            
            // 2. 验证用户是否已经进行了账号的验证
            if (StrUtil.isEmptyIfStr(user.getVerify()) || "N".equals(user.getVerify())) {
                throw new BizException(BizErrorCode.VERIFY_CODE_ERROR);
            }
            if (!DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(user.getPassword())) {
                throw new BizException(BizErrorCode.AUTH_ERROR);
            }
            
            // 3. 创建token
            Map<String, Object> map = new HashMap<>();
            map.put("uid", user.getId());
            String token= JwtTokenUtils.builder().msg(JSON.toJSON(map).toString()).build().creatJwtToken();
            
            // 4. 设置响应
            response.setToken(token);
            response.setId(user.getId());
            response.setUsername(user.getUsername());
            response.setPhone(user.getPhone());
            response.setSex(user.getSex());
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.login Occur Exception :{}", String.valueOf(e));
            throw new BizException("error");
        }
        return response;
    }

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        log.info("Begin UserLoginServiceImpl.validToken: request:" + request);
        CheckAuthResponse response = new CheckAuthResponse();
        try {
            String decodeMsg = JwtTokenUtils.builder().token(request.getToken()).build().freeJwt();
            if (StringUtils.isNotBlank(decodeMsg)) {
                log.info("validate success");
                response.setUserinfo(decodeMsg);
                return response;
            }
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.validToken Occur Exception :{}", String.valueOf(e));
            throw new BizException(BizErrorCode.AUTH_ERROR);
        }
        return response;
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByUserName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userName);
        queryWrapper.eq("state",1);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new BizException(BizErrorCode.AUTH_ERROR);
        }
        return user;
    }


}
