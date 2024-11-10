package com.example.hphelper.controller;

import com.example.hphelper.pojo.Article;
import com.example.hphelper.pojo.PageBean;
import com.example.hphelper.pojo.Result;
import com.example.hphelper.service.ArticleService;
import com.example.hphelper.utils.JwtUtil;
import com.example.hphelper.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {
    //获取文章列表
    /*@GetMapping("/list")
    public Result<String> list(){//@RequestHeader("authorization") String token, HttpServletResponse response
        return Result.success("获取成功");
    }*/
    @Autowired
    private ArticleService articleService;

    //新增文章
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }
    //查询文章
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam Integer categoryId,
            @RequestParam String state
    ){
        PageBean<Article> pb = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pb);
    }
    //获取文章内容
//    public Result<Article> articleInfo(){
//        Map<String,Object> map = ThreadLocalUtil.get();
//        String id = (String) map.get("ArticleId");
//        Article article = ArticleService.findBy
//    }
    //修改内容
    //删除自己的文章
}
