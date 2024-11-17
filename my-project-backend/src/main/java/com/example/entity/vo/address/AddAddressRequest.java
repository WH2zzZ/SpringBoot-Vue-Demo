package com.example.entity.vo.address;


import lombok.Data;

/**
 * 添加地址请求参数
 */
@Data
public class AddAddressRequest {

    private String userName;
    private String tel;
    private String streetName;

    private String postalCode;
}
