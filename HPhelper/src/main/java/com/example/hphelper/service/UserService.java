package com.example.hphelper.service;

import com.example.hphelper.pojo.User;

public interface UserService {
    //用户名查询用户方法
    User findByUserName(String username);
    //注册

    void register(String username, String password);
    //改名
    void update(User user);
    //换头像
    void updateAvatar(String avatarUrl);
    //更新密码
    void updatePwd(String newPwd);
}
