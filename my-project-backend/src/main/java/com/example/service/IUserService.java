package com.example.service;


import com.example.entity.orm.User;
import com.example.entity.vo.user.CheckAuthRequest;
import com.example.entity.vo.user.CheckAuthResponse;
import com.example.entity.vo.user.UserLoginRequest;
import com.example.entity.vo.user.UserLoginResponse;

public interface IUserService {
    
    User findById(Long id);
    
    User findByUsername(String username);
    
    void update(User user);
    

}
