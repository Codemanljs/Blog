package com.ljs.blog.utils;

import java.util.regex.Pattern;

/**
 * @author ljs
 * @create 2023-03-07 15:12
 */
public class TelUtil {

    public static boolean isValidPhoneNumber(String tel) {
        if ((tel != null) && (!tel.isEmpty())) {
            return Pattern.matches("^1[3-9]\\d{9}$", tel);
        }
        return false;
    }

}
