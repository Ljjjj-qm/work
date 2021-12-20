package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.User_Role;

public interface UserRoleService extends IService<User_Role> {
    public User_Role getUserRole(Integer userId);

}
