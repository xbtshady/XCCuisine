package com.XCCuisine.api.xw.XWTitle.controller;

import com.XCCuisine.api.XWVO;
import com.XCCuisine.dao.po.XWTitle;
import com.XCCuisine.api.xw.XWTitle.model.io.GetXWTitleByIdIO;
import com.XCCuisine.api.xw.XWTitle.model.io.GetXWTitleListServiceIO;
import com.XCCuisine.api.xw.XWTitle.model.io.XWTitleServiceIO;
import com.XCCuisine.api.xw.XWTitle.service.IXWTitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/xw")
@RestController
public class XWTitleController {
    static final Logger logger = LoggerFactory.getLogger(XWTitleController.class);

    @Resource
    IXWTitleService XWTitleService;


    @RequestMapping(value = "/getXWTitleList")
    public List<Map<String,Object>> getXWTitleList(@Valid @RequestBody GetXWTitleListServiceIO getXWTitleListServiceIO) throws Exception {
        return XWTitleService.getXWTitleList(getXWTitleListServiceIO);
    }

    @RequestMapping(value = "/getXWTitleById")
    public Map<String,Object> getXWTitleById(@Valid @RequestBody GetXWTitleByIdIO getXWTitleByIdIO) throws Exception {
        return XWTitleService.getXWTitleById(getXWTitleByIdIO);
    }

    @RequestMapping(value = "/setXWTitle")
    public XWVO setXWTitle(@Valid  @RequestBody XWTitleServiceIO xwTitleServiceIO) throws Exception {
        return XWTitleService.setXWTitle(xwTitleServiceIO);
    }

    @RequestMapping(value = "/updateXWTitle")
    public XWVO updateXWTitle(@Valid @RequestBody XWTitleServiceIO xwTitleServiceIO) throws Exception {
        return XWTitleService.updateXWTitle(xwTitleServiceIO);
    }

    @RequestMapping(value = "/deleteXWTitle")
    @ResponseBody
    public XWVO deleteXWTitle(@Valid @RequestBody XWTitleServiceIO xwTitleServiceIO) throws Exception {
        return XWTitleService.deleteXWTitle(xwTitleServiceIO);
    }
}
