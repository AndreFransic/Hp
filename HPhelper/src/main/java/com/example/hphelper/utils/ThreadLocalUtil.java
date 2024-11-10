package com.example.hphelper.utils;

/*

线程隔离工具类

*/

public class ThreadLocalUtil {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    //根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
    //存储键值对
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }

    //清楚ThreadLocal防止内存泄露
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
