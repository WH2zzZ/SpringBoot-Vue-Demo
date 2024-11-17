package com.example.entity.vo.user;

import lombok.Data;



@Data
public class UpdateMemberRequest {
    /**
     * 主键
     */
    private Long id;
    /**
     * 注册手机号
     */
    private String phone;
    /**
     * 注册邮箱
     */
    private String email;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 头像
     */
    private String file;
    /**
     * 描述
     */
    private String description;
    private Integer points;
    private Long balance;

    private String token;

}
