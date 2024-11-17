package com.example.service;


import com.example.entity.orm.User;
import com.example.entity.vo.user.CheckAuthRequest;
import com.example.entity.vo.user.CheckAuthResponse;
import com.example.entity.vo.user.UserLoginRequest;
import com.example.entity.vo.user.UserLoginResponse;

public interface IUserLoginService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);


    /**
     * 校验过程
     * @param request
     * @return
     */
    CheckAuthResponse validToken(CheckAuthRequest request);
    
    
    User selectById(Long id);
    
    User selectByUserName(String userName);
    
}
