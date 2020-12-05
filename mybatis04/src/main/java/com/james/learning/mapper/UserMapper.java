package com.james.learning.mapper;

import com.james.learning.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select id,name,pwd password from user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id, @Param("name") String name);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}

/**
 * #{}和${}的区别是什么？
 * 答案：#{}是预编译处理，$ {}是字符串替换。
 * mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；
 * eg:  INSERT INTO user (name) VALUES (#{name});
 *      INSERT INTO user (name) VALUES (?);
 * mybatis在处理 $ { } 时，就是把 ${ } 替换成变量的值。使用 #{} 可以有效的防止SQL注入，提高系统安全性
 * eg:  INSERT INTO user (name) VALUES ('${name}');
 *      INSERT INTO user (name) VALUES ('kuangshen');
 *
 * 为什么它这样处理就能预防SQL注入提高安全性呢？
 * 答案：其实是因为SQL语句在程序运行前已经进行了预编译，
 * 在程序运行时第一次操作数据库之前，SQL语句已经被数据库分析，编译和优化，
 * 对应的执行计划也会缓存下来并允许数据库已参数化的形式进行查询，
 * 当运行时动态地把参数传给PreprareStatement时，
 * 即使参数里有敏感字符如 or '1=1'也数据库会作为一个参数一个字段的属性值来处理而不会作为一个SQL指令，
 * 如此，就起到了防止SQL注入的作用了！
 *
 */
