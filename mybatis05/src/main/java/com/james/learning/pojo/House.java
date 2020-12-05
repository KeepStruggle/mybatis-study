package com.james.learning.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.8
 * @ClassName House
 * @Description TODO
 * @Author James
 * @date 2020/12/5 13:25
 */
@Data   //GET,SET,toString,有参，无参构造
public class House implements Serializable {
    private Integer id;
    private Integer user_id;
    private Integer type_id;
    private String title;
    private String description;
    private double price;
    private String pubdate;
    private Integer floorage;
    private String contact;
    private Integer street_id;

    private Types types;  //一个房子只属于一种房屋类型（外键）
}
