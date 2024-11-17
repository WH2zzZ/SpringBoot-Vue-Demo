package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.orm.User;

public interface UserMapper extends BaseMapper<User> {
    
    User selectByUsername(String username);
    
    User selectByEmail(String email);
    
    User selectByPhone(String phone);
    
    User selectById(Long id);
    
    User selectByRoleId(Integer roleId);
}