package com.example.entity.vo.user;

import lombok.Data;

@Data
public class UserRegisterRequest{

    private String userName;
    private String userPwd;
    private String email;

}
