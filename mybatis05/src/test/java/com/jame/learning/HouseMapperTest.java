package com.jame.learning;

import com.james.learning.mapper.HouseMapper;
import com.james.learning.mapper.TypesMapper;
import com.james.learning.pojo.House;
import com.james.learning.pojo.Types;
import com.james.learning.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @version 1.8
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author James
 * @date 2020/12/5 13:46
 */
public class HouseMapperTest {

    @Test
    public void testGetHouseList(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        HouseMapper houseMapper = sqlSession.getMapper(HouseMapper.class);
        List<House> houseList = houseMapper.getHouseList();
        for(House house: houseList){
            System.out.println(house.getId() + "\t"
                + house.getTitle() + "\t"
                + house.getDescription() + "\t"
                + house.getPrice() + "\t"
                + house.getFloorage() + "\t"
                + house.getContact() + "\t"
                + house.getTypes().getName());
        }
        sqlSession.close();
    }

    @Test
    public void testGetTypesList(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TypesMapper typesMapper = sqlSession.getMapper(TypesMapper.class);
        Types types = typesMapper.getTypesList();
        List<House> houseList = types.getHouseList();
        for(House house: houseList){
            System.out.println(types.getId() + "\t"
                    + types.getName() + "\t"
                    + house.getId() + "\t"
                    + house.getTitle() + "\t"
                    + house.getDescription() + "\t"
                    + house.getPrice() + "\t"
                    + house.getFloorage() + "\t"
                    + house.getPubdate() + "\t"
                    + house.getContact() + "\t");
        }

        sqlSession.close();
    }
}
