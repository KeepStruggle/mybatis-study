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
    public void testGetUserByLimit(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);//0, 2, 4
        map.put("pageSize", 2);
        List<User> userList = userMapper.getUserByLimit(map);
        for (User user : userList){
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void testGetUserByRowBounds(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int currentPage = 1;//第几页
        int pageSize = 2;//每页显示几个
        //推断：起始位置 =  （当前页面 - 1 ） * 页面大小
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);
        List<User> userList = sqlSession.selectList("com.james.learning.mapper.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList){
            System.out.println(user);
        }
        sqlSession.close();

    }
}
