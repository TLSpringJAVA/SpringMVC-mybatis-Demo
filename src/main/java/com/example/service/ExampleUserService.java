package com.example.service;

import com.example.dao.entity.User;

import java.util.List;

public interface ExampleUserService {
    List<User> getUsers(Integer userId);

    List<User> findAllUser();
}
