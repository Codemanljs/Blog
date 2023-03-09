package com.ljs.blog.utils;

import java.util.Random;

/**
 * @author ljs
 * @create 2023-03-07 15:56
 */
public class MessageUtil {
    public static String creatSms(){
        Random random = new Random();
        String hash1 = Integer.toHexString(random.nextInt());
        String capstr = hash1.substring(0,6);
        return capstr;
    }

}
