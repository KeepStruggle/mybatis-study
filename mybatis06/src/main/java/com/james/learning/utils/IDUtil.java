package com.james.learning.utils;

import java.util.UUID;

/**
 * @version 1.8
 * @ClassName IDUtil
 * @Description TODO
 * @Author James
 * @date 2020/12/5 15:50
 */
public class IDUtil {

    /**
     * 利用java.util包下的UUID的静态方法去获得随机的字符串
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
