package com.ls.order.utils;

import java.util.Random;

/**
 * @program: order->KeyUtil
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 16:51
 **/

public class KeyUtil {

    /**
     *生成唯一的主键
     * 格式：时间+随机数
     */
    public static synchronized  String getUniqueKey(){
        Random random = new Random();
        Integer number  = random.nextInt(900000)+100000;

        return System.currentTimeMillis() + number.toString();
    }
}
