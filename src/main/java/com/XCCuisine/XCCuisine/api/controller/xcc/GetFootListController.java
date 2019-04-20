package com.XCCuisine.XCCuisine.api.controller.xcc;

import com.XCCuisine.XCCuisine.api.dao.po.Food;
import com.XCCuisine.XCCuisine.api.service.xcc.IGetFootListService;
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
public class GetFootListController {

    static final Logger logger = LoggerFactory.getLogger(GetFootListController.class);

    @Resource
    IGetFootListService getFootListService;


    @RequestMapping(value = "/getFootList", method = {RequestMethod.GET})
    @ResponseBody
    public List<Food> getFootList() throws Exception {
        return getFootListService.getFootList();
    }

}