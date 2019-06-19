package com.XCCuisine.api.xcc.Food.service.impl;

import com.XCCuisine.dao.FoodMapper;
import com.XCCuisine.dao.po.Food;
import com.XCCuisine.api.xcc.Food.service.IGetFoodListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetFoodListServiceImpl implements IGetFoodListService {
    @Resource
    FoodMapper foodMapper;
    @Override
    public List<Food> getFoodList() {
        List<Food> result = new ArrayList<>();

        result.add(foodMapper.selectByPrimaryKey(1));
        result.add(foodMapper.selectByPrimaryKey(2));

        return result;
    }
}
