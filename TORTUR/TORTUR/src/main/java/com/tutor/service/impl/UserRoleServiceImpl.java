package com.tutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tutor.entity.User_Role;
import com.tutor.mapper.UserRoleMapper;
import com.tutor.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, User_Role> implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User_Role getUserRole(Integer userId) {
        LambdaQueryWrapper<User_Role> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User_Role::getUserId,userId);
        User_Role user_role = userRoleMapper.selectOne(lqw);
        return user_role;
    }
}
