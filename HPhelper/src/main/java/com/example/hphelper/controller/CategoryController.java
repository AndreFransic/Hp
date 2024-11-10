package com.example.hphelper.controller;


import com.example.hphelper.pojo.Category;
import com.example.hphelper.pojo.Result;
import com.example.hphelper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //查询全部
    @GetMapping
    public Result<List<Category>> list (){
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }

    //查询详情
    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
        Category c = categoryService.findById(id);
        return Result.success(c);
    }
}
