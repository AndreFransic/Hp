package com.example.hphelper.service.impl;

import com.example.hphelper.mapper.ArticleMapper;

import com.example.hphelper.pojo.Article;
import com.example.hphelper.pojo.PageBean;
import com.example.hphelper.service.ArticleService;
import com.example.hphelper.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

//    @Override
//    public Article findByArticleId(String ArticleId) {
//        Article ae = articleMapper.findByArticleId(ArticleId);
//        return ae;
//    }


    //新增文章
    @Override
    public void add(Article article) {
        //补充属性值
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userid");
        article.setCreateId(String.valueOf(userId));

        articleMapper.add(article);
    }
    //根据类型分类查询
    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //创建PAGEBEAN对象
        PageBean<Article> pb = new PageBean<>();
        //开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userid");
        List<Article> as =  articleMapper.list(userId,categoryId,state);
        Page<Article> p = (Page<Article>) as;

        //把数据填充到pageBean
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}

