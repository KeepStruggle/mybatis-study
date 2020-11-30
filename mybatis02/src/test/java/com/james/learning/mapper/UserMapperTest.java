package com.james.learning.mapper;


import com.james.learning.pojo.User;
import com.james.learning.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


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

    

}
