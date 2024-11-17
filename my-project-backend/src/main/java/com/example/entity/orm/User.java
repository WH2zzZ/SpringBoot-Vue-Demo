package com.example.entity.orm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@TableName("db_user")
@Data
@ToString
public class User {
    @TableId
    private Long id;
    
    

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码 md5加密存储
     */
    private String password;

    private String salt;

    /**
     * 注册手机号
     */
    private String phone;
    
    private String email;
    
    private String sex;

    private Long addressId;

    private Integer state;

    private String description;

    @TableField("role_id")
    private Integer roleId;

    private String verify;


}