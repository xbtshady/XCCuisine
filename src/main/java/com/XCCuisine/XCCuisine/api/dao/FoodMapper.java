package com.XCCuisine.XCCuisine.api.dao;

import com.XCCuisine.XCCuisine.api.dao.po.Food;


public interface FoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}