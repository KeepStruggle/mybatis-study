package com.james.learning.mapper;

import com.james.learning.pojo.Blog;
import com.james.learning.utils.IDUtil;
import com.james.learning.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @version 1.8
 * @ClassName BlogMapperTest
 * @Description TODO
 * @Author James
 * @date 2020/12/5 16:03
 */
public class BlogMapperTest {

    @Test
    public void testAddBlog(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtil.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("James");
        blog.setCreateTime(new Date());
        blogMapper.addBlog(blog);
        sqlSession.close();
    }

    @Test
    public void testQueryBlogIf(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("title","Mybatis如此简单");
        map.put("author","james");
        List<Blog> blogList = blogMapper.queryBlogIf(map);
        for(Blog blog: blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map = new HashMap<String, String>();
        map.put("id", "e1c114f5b7bf416bac457fb587b440ce");
        map.put("title", "动态sql");
        map.put("author", "James");
        blogMapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","Java如此简单");
        map.put("author","狂神说");
        map.put("views",9999);
        List<Blog> blogs = blogMapper.queryBlogChoose(map);
        System.out.println(blogs);
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MybatisUtil.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        map.put("ids",idList);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        session.close();
    }

}
