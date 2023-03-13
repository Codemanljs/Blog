package com.ljs.blog.utils;


import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @author ljs
 * @create 2023-03-09 9:44
 */
public class JwtHelper {

    //token过期时间
    private static long tokenEXP=60*60*24*1000;

    //密钥
    private static String tokenKey="90461";


    //创建token
    public static String createToken(Integer userId,String username,String password){
        String token = Jwts.builder()
                .setSubject("creatToken")
                .setExpiration(new Date(System.currentTimeMillis() + tokenEXP))
                .signWith(SignatureAlgorithm.HS512, tokenKey)
                .claim("userId", userId)
                .claim("username", username)
                .claim("password", password)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }


    //从token中解析获得password
    public static String getPassword(String token){
        if (token==null){
            return null;
        }
        Claims body = Jwts.parser().parseClaimsJws(token).getBody();
        String password = (String) body.get("password");
        return password;
    }
    //从token中解析获得userId
    public static String getUserId(String token){
        if (token==null){
            return null;
        }
        Claims body = Jwts.parser().parseClaimsJws(token).getBody();
        String userId = (String) body.get("userId");
        return userId;
    }
    //从token中解析获得username
    public static String getUsername(String token){
        if (token==null){
            return null;
        }
        Claims body = Jwts.parser().parseClaimsJws(token).getBody();
        String username = (String) body.get("username");
        return username;
    }



}
