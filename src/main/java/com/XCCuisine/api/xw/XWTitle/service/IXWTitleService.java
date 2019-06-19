package com.XCCuisine.api.xw.XWTitle.service;

import com.XCCuisine.api.XWVO;
import com.XCCuisine.dao.po.XWTitle;
import com.XCCuisine.api.xw.XWTitle.model.io.GetXWTitleByIdIO;
import com.XCCuisine.api.xw.XWTitle.model.io.GetXWTitleListServiceIO;
import com.XCCuisine.api.xw.XWTitle.model.io.XWTitleServiceIO;

import java.util.List;
import java.util.Map;

public interface IXWTitleService {

    List<Map<String,Object>> getXWTitleList(GetXWTitleListServiceIO getXWTitleListServiceIO)throws Exception;

    Map<String,Object> getXWTitleById(GetXWTitleByIdIO getXWTitleByIdIO) throws Exception;

    XWVO setXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception;

    XWVO updateXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception;

    XWVO deleteXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception;


}
