package com.XCCuisine.XCCuisine.api.service.xw;

import com.XCCuisine.XCCuisine.api.dao.po.XWTitle;
import com.XCCuisine.XCCuisine.api.model.xw.XWTitleService.GetXWTitleListServiceIO;
import com.XCCuisine.XCCuisine.api.model.xw.XWTitleService.XWTitleServiceIO;
import com.XCCuisine.XCCuisine.api.model.xw.XWVO;

import java.util.List;

public interface IXWTitleService {

    List<XWTitle> getXWTitleList(GetXWTitleListServiceIO getXWTitleListServiceIO)throws Exception;

    XWVO setXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception;

    XWVO updateXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception;

    XWVO deleteXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception;
}
