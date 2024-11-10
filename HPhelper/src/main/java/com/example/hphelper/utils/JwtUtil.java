package com.example.hphelper.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

//JWT生成工具类

public class JwtUtil {
    private static final String Key = "CJWDDFC";

    //接受数据，生成token并返回
    public static String genToken(Map<String,Object> claims){
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *2))
                .sign(Algorithm.HMAC256(Key));
    }
    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(Key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
