package com.example.entity.orm;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@TableName("db_address")
public class Address {

    @TableId
    private Long addressId;
    private Long userId;
    private String userName;
    private String tel;
    private String streetName;

    private Integer isDefault;
}