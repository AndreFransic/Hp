package com.example.hphelper.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-11-03 02:40:15
 */
public class User {
    //private static final long serialVersionUID = 266106744987277225L;

    private String username;
    @JsonIgnore//让SPRINGMVC把对象转换成JSON数据忽略密码
    private String password;
    @NotNull
    private Integer userid;
    
    private String userPic;

    @Pattern(regexp = "^\\S{1,10}$")
    @NotEmpty
    private String nickname;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

