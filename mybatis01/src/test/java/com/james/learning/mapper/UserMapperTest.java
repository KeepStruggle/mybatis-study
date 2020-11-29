package com.james.learning.mapper;

import com.james.learning.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.james.learning.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.8
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author James
 * @date 2020/11/29 16:20
 */
public class UserMapperTest {

    @Test
    public void testGetUserList(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
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
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);

        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserLike(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserLike("李");

        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void testAddUser(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.insertUser(new User(4,"jj","233"));

        sqlSession.commit();
        System.out.println(i);
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testInsertUser2(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 5);
        map.put("userName", "James");
        map.put("userPwd", "1234560");
        int i = userMapper.insertUser2(map);

        sqlSession.commit();
        System.out.println(i);
        //关闭SqlSession
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void testUpdateUser(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.updateUser(new User(4,"林俊杰","233"));

        sqlSession.commit();
        System.out.println(i);
        //关闭SqlSession
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void testDeleteUser(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(new User(4,"jj","233"));

        sqlSession.commit();
        System.out.println(i);
        //关闭SqlSession
        sqlSession.close();
    }
}
