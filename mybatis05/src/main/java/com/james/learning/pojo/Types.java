package com.james.learning.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.8
 * @ClassName Types
 * @Description TODO
 * @Author James
 * @date 2020/12/5 13:36
 */
@Data
public class Types implements Serializable {
    private Integer id;
    private String name;

    private List<House> houseList; //一种房屋类型对应多个房屋
}
