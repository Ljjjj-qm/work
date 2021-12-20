package com.tutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tutor.entity.User;
import org.springframework.stereotype.Repository;


public interface UserService extends IService<User> {

    public User getUser(String username,String password);
}
