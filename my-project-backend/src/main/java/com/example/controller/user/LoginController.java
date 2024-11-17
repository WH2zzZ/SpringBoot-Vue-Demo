package com.example.controller.user;

import com.example.common.BizResponse;
import com.example.config.exception.annotation.ErrorMessage;
import com.example.entity.vo.user.UserLoginRequest;
import com.example.entity.vo.user.UserLoginResponse;
import com.example.entity.vo.user.UserRegisterRequest;
import com.example.service.IUserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    private IUserLoginService iUserLoginService;


    @PostMapping("/login/")
    public BizResponse<String> login(@RequestBody UserLoginRequest loginRequest,
                             HttpServletRequest request, HttpServletResponse response){
        UserLoginResponse userLoginResponse=iUserLoginService.login(loginRequest);
        
        if (userLoginResponse == null) {
            return BizResponse.error(401, "用户名或密码错误");
        }

        return BizResponse.success(userLoginResponse.getToken());
    }


    @PostMapping("/register/")
    public BizResponse<String> register(@RequestBody UserRegisterRequest registerRequest,
                             HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    @PostMapping("/logout")
    public boolean logout(@RequestBody UserRegisterRequest registerRequest,
                          HttpServletRequest request,
                          HttpServletResponse response){
        return true;
    }







}
