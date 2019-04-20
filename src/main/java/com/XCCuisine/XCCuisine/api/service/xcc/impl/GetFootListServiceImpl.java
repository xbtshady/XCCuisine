package com.XCCuisine.XCCuisine.api.service.xcc.impl;

import com.XCCuisine.XCCuisine.api.dao.FoodMapper;
import com.XCCuisine.XCCuisine.api.dao.po.Food;
import com.XCCuisine.XCCuisine.api.service.xcc.IGetFootListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetFootListServiceImpl implements IGetFootListService {
    @Resource
    FoodMapper foodMapper;
    @Override
    public List<Food> getFootList() {
        List<Food> result = new ArrayList<>();

        result.add(foodMapper.selectByPrimaryKey(1));
        result.add(foodMapper.selectByPrimaryKey(2));

        return result;
    }
}
