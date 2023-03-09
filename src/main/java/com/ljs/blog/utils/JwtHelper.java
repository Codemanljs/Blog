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
    public static String createToken(String userType,String username,Integer userId){
        String token = Jwts.builder()
                .setSubject("creatToken")
                .setExpiration(new Date(System.currentTimeMillis() + tokenEXP))
                .signWith(SignatureAlgorithm.HS512, tokenKey)
                .claim("userType", userType)
                .claim("username", username)
                .claim("userId", userId)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //从token中解析获得userType
    public String getUserType(String token){
        if (token==null){
            return null;
        }
        Claims body = Jwts.parser().parseClaimsJws(token).getBody();
        String userType = (String) body.get("userType");
        return userType;
    }
    //从token中解析获得userId
    public String getUserId(String token){
        if (token==null){
            return null;
        }
        Claims body = Jwts.parser().parseClaimsJws(token).getBody();
        String userId = (String) body.get("userId");
        return userId;
    }
    //从token中解析获得username
    public String getUsername(String token){
        if (token==null){
            return null;
        }
        Claims body = Jwts.parser().parseClaimsJws(token).getBody();
        String username = (String) body.get("username");
        return username;
    }



}
