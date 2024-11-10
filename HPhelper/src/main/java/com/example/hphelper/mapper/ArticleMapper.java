package com.example.hphelper.mapper;

import com.example.hphelper.pojo.Article;
import com.example.hphelper.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    //新增文章
    @Insert("insert into article(title,content,cover_img,state,categoryId,create_id)" +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createId})")
    void add(Article article);
    //根据文章分类进行查询并列出查询列表
    List<Article> list(Integer userId, Integer categoryId, String state);
}
