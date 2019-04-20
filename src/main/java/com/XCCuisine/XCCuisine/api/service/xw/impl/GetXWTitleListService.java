package com.XCCuisine.XCCuisine.api.service.xw.impl;

import com.XCCuisine.XCCuisine.api.dao.XWTitleMapper;
import com.XCCuisine.XCCuisine.api.dao.po.xwTitle;
import com.XCCuisine.XCCuisine.api.service.xw.IGetXWTitleListService;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

public class GetXWTitleListService implements IGetXWTitleListService {
    @Resource
    XWTitleMapper xwTitleMapper;

    @Override
    public List<xwTitle> getXWTitleList(int index, int size) {
        return xwTitleMapper.queryXwTitle(size * (index - 1) ,size * index - 1);
    }
}
