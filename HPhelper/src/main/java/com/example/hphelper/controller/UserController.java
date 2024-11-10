package com.example.hphelper.controller;


import com.example.hphelper.pojo.Result;
import com.example.hphelper.pojo.User;
import com.example.hphelper.service.UserService;
import com.example.hphelper.utils.JwtUtil;
import com.example.hphelper.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.apache.logging.log4j.message.ReusableMessage;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //注册
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{6,20}$") String username, @Pattern(regexp = "^\\S{8,16}$") String password) {
        //传参校验
        User u = userService.findByUserName(username);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名以占用");
        }
    }
    //登录
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{6,20}$") String username, @Pattern(regexp = "^\\S{8,16}$") String password){
        //查询用户
        User loginUser = userService.findByUserName(username);
        //判断用户是否存在
        if (loginUser==null){
            return Result.error("用户名不存在");
        }

        //判断密码
        if ((password).equals(loginUser.getPassword())){
            //登陆成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getUserid());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
    //获取用户信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/){
        /*Map<String,Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");*/
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
    //改名
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }
    //换头像
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }
    //改密码
    @PatchMapping("/updatePwd")
    public Result updatePwd (@RequestBody Map<String,String> params){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少参数");
        }
        //调用service层根据账号查找原密码，然后进行比对
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(oldPwd)){
            return Result.error("原密码错误");
        }
        if (!rePwd.equals(newPwd)){
            return Result.error("确认密码填写错误");
        }

        userService.updatePwd(newPwd);
        return Result.success();
    }
}
