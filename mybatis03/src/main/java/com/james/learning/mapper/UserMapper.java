package com.james.learning.mapper;

import com.james.learning.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询所有的用户
    List<User> getUserList();

    //分页查询
    List<User> getUserByLimit(Map<String,Integer> map);

    //分页2
    List<User> getUserByRowBounds();

}
