package com.james.learning.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.8
 * @ClassName Blog
 * @Description TODO
 * @Author James
 * @date 2020/12/5 15:49
 */
@Data
public class Blog implements Serializable {

    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

}
