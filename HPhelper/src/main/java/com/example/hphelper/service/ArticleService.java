package com.example.hphelper.service;

import com.example.hphelper.pojo.Article;
import com.example.hphelper.pojo.PageBean;
import com.example.hphelper.pojo.User;

public interface ArticleService {


//    Article findByArticleId(String ArticleId);

    //新增文章
    void add(Article article);
    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
