package com.example.hphelper.mapper;

import com.example.hphelper.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //查询
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into user(username,password)" +
            " values(#{username},#{password}) ")
    void add(String username, String password);
    //改名
    @Update("update user set nickname=#{nickname} where userid = #{userid}")
    void update(User user);
    //换头像
    @Update("update user set user_pic=#{avatarUrl} where userid=#{userid} ")
    void updateAvatar(String avatarUrl,Integer userid);
    //改密码
    @Update("update user set password=#{newPwd} where userid=#{userid}")
    Object updatePwd(String newPwd,Integer userid);
}
