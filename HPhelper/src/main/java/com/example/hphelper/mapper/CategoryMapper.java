package com.example.hphelper.mapper;


import com.example.hphelper.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CategoryMapper {
    //新增
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time)" +
            "values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    //查询全部
    @Select("select * from category where create_user = #{userId}")
    void list(Integer userId);
    //根据id查询
    @Select("select * from category where id = #{id}")
    Category findById(Integer id);
}
