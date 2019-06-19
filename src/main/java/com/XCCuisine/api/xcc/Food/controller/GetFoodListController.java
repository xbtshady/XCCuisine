package com.XCCuisine.api.xcc.Food.controller;

import com.XCCuisine.dao.po.Food;
import com.XCCuisine.api.xcc.Food.service.IGetFoodListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.List;


@RequestMapping(value = "/api/xcc")
@Controller
public class GetFoodListController {

    static final Logger logger = LoggerFactory.getLogger(GetFoodListController.class);

    @Resource
    IGetFoodListService getFootListService;


    @RequestMapping(value = "/getFoodList", method = {RequestMethod.GET})
    @ResponseBody
    public List<Food> getFootList() throws Exception {
        return getFootListService.getFoodList();
    }

}