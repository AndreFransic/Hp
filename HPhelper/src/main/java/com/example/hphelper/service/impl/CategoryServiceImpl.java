package com.example.hphelper.service.impl;

import com.example.hphelper.mapper.CategoryMapper;
import com.example.hphelper.pojo.Category;
import com.example.hphelper.service.CategoryService;
import com.example.hphelper.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    //查询
    @Override
    public List<Category> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userid");
         categoryMapper.list(userId);
        return null;
    }
    //查询
    @Override
    public Category findById(Integer id) {
        Category c = categoryMapper.findById(id);
        return null;
    }
}
