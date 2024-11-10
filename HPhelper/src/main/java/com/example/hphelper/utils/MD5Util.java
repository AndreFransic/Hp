package com.example.hphelper.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 获取MD5加密后的字符串
     *
     * @param input 需要加密的字符串
     * @return 返回MD5加密后的字符串
     */
    public static String getMD5(String input) {
        try {
            // 获取MD5摘要算法的 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            md.update(input.getBytes());
            // 计算摘要
            byte[] digest = md.digest();
            // 将字节转换成十六进制的字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}