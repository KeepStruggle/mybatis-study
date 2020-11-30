package com.james.learning.mapper;

import com.james.learning.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询所有的用户
    List<User> getUserList();

    User getUserById(int id);

    User getUserLike(String value);

    int insertUser(User user);

    //万能Map
    int insertUser2(Map<String, Object> map);

    int updateUser(User user);

    int deleteUser(User user);

}
