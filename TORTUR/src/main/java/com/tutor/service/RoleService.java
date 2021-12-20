package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.Role;

public interface RoleService extends IService<Role> {
    public Role getRoleName(Integer id);
}
