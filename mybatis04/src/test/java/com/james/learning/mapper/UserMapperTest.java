package com.james.learning.mapper;

import com.james.learning.pojo.User;
import com.james.learning.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.8
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author James
 * @date 2020/12/2 0:12
 */
public class UserMapperTest {

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //本质上利用了jvm的动态代理机制
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for(User user: userList){
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1,"张三");

        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(8, "秦疆", "123456");
        int i = userMapper.addUser(user);
        System.out.println(i);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(8, "秦疆123", "66666");
        int i = userMapper.updateUser(user);
        System.out.println(i);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(8);
        System.out.println(i);

        //关闭SqlSession
        sqlSession.close();
    }


}
