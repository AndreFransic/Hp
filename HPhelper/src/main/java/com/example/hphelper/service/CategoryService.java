package com.example.hphelper.service;

import com.example.hphelper.pojo.Category;

import java.util.List;

public interface CategoryService {
    //列表查询
    List<Category> list();
    //根据id查询分类信息
    Category findById(Integer id);
}
