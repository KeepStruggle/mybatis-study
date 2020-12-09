package com.james.learning.mapper;

import com.james.learning.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User queryUserById(@Param("id") int id);

    List<User> queryUserByName(@Param("name") String name);

    //修改用户
    int updateUser(Map map);
}
