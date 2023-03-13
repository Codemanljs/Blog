package com.ljs.blog.utils;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author ljs
 * @create 2023-03-09 10:31
 */
public class RedisUtil {

    @Resource
    static RedisTemplate redisTemplate;

    /*string*/

    //设置key
    public static void set(String key,Object obj){
        redisTemplate.opsForValue().set(key,obj);
    }

    //获取obj
    public static String get(String key){
        String obj = (String) redisTemplate.opsForValue().get(key);
        return obj;
    }

    //删除key
    public static boolean del(String key){
        if (key==null){
            return false;
        }
        redisTemplate.delete(key);
        return true;
    }

    /*set*/
    //设置key
    public static void sadd(Object key,String... args){
        redisTemplate.opsForSet().add(key,args);
    }
    //获取obj
    public static Set<String> smembers(Object key){
        Set members = redisTemplate.opsForSet().members(key);
        return members;
    }

}
