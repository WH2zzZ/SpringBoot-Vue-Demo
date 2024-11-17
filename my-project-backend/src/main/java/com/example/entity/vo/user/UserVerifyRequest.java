package com.example.entity.vo.user;

import lombok.Data;


@Data
public class UserVerifyRequest {

    private String userName;
    /**
     * 注册时生产的唯一序号
     */
    private String uuid;

}
