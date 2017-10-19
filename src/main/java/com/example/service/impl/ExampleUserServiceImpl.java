package com.example.service.impl;

import com.example.dao.entity.User;
import com.example.dao.mapper.UserMapper;
import com.example.service.ExampleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleUserServiceImpl implements ExampleUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取所有的用户
     * @param userId
     * @return
     */
    public List<User> getUsers(Integer userId) {
        return null;
    }

    public List<User> findAllUser() {
        return userMapper.findAll();
    }
}
