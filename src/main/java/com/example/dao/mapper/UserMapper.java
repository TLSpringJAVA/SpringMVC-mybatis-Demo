package com.example.dao.mapper;

import com.example.dao.entity.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User>{


    @Select("select * from user")
    @ResultMap(value = "BaseResultMap")
    List<User> findAll();
}