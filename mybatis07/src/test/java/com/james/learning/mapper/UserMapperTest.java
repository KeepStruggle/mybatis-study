package com.james.learning.mapper;

import com.james.learning.pojo.User;
import com.james.learning.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @version 1.8
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author James
 * @date 2020/12/7 22:20
 */
public class UserMapperTest {

    @Test
    public void testQueryUserById1(){
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
    }

    @Test
    public void testQueryUserById2(){
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(2);
        System.out.println(user);
        List<User> userList = mapper.queryUserByName("李四");
        System.out.println(userList);

        session.close();
    }

    /**
     * 一级缓存失效的四种情况:
     *         1、sqlSession不同
     */
//    @Test
//    public void testQueryUserById(){
//        SqlSession session = MybatisUtil.getSqlSession();
//        SqlSession session2 = MybatisUtil.getSqlSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        UserMapper mapper2 = session2.getMapper(UserMapper.class);
//
//        User user = mapper.queryUserById(1);
//        System.out.println(user);
//        User user2 = mapper2.queryUserById(1);
//        System.out.println(user2);
//        System.out.println(user==user2);
//
//        session.close();
//        session2.close();
//    }

    /**
     *      2、sqlSession相同，查询条件不同
     */
//    @Test
//    public void testQueryUserById(){
//        SqlSession session = MybatisUtil.getSqlSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        UserMapper mapper2 = session.getMapper(UserMapper.class);
//
//        User user = mapper.queryUserById(1);
//        System.out.println(user);
//        User user2 = mapper2.queryUserById(2);
//        System.out.println(user2);
//        System.out.println(user==user2);
//
//        session.close();
//    }

    /**
     *      3、sqlSession相同，两次查询之间执行了增删改操作！
     *          因为增删改操作可能会对当前数据产生影响
     */
//    @Test
//    public void testQueryUserById(){
//        SqlSession session = MybatisUtil.getSqlSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//
//        User user = mapper.queryUserById(1);
//        System.out.println(user);
//
//        HashMap map = new HashMap();
//        map.put("name","kuangshen");
//        map.put("id",4);
//        mapper.updateUser(map);
//
//        User user2 = mapper.queryUserById(1);
//        System.out.println(user2);
//
//        System.out.println(user==user2);
//
//        session.close();
//    }

    /**
     *      4、sqlSession相同，手动清除一级缓存
     */
//    @Test
//    public void testQueryUserById(){
//        SqlSession session = MybatisUtil.getSqlSession();
//        UserMapper mapper = session.getMapper(UserMapper.class);
//
//        User user = mapper.queryUserById(1);
//        System.out.println(user);
//
//        session.clearCache();//手动清除缓存
//
//        User user2 = mapper.queryUserById(1);
//        System.out.println(user2);
//
//        System.out.println(user==user2);
//
//        session.close();
//    }

    /**
     * 只要开启了二级缓存，我们在同一个Mapper中的查询，可以在二级缓存中拿到数据
     * 查出的数据都会被默认先放在一级缓存中
     * 只有会话提交或者关闭以后，一级缓存中的数据才会转到二级缓存中
     *
     * 注意：在这里有发现只创建了一个connection
     */
    @Test
    public void testQueryUserById(){
        SqlSession session = MybatisUtil.getSqlSession();
        SqlSession session2 = MybatisUtil.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session2.close();
    }

}
