package com.example.hphelper.interceptors;

import com.example.hphelper.pojo.Result;
import com.example.hphelper.utils.JwtUtil;
import com.example.hphelper.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

//登录拦截器

@Component
public class LoginIterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        //令牌验证
        String token = request.getHeader("Authorization");
        //验证token
        try {
            Map<String,Object> claims = JwtUtil.parseToken(token);

            //业务数据储存到THREADLOCAL中
            ThreadLocalUtil.set(claims);

            //解析成功，放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            //解析失败，拦截
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空THREADLOCAL中的数据
        ThreadLocalUtil.remove();
    }
}
