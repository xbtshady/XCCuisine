package com.XCCuisine.XCCuisine.api.service.xw;

import com.XCCuisine.XCCuisine.api.dao.po.xwTitle;

import java.util.List;

public interface IGetXWTitleListService {
    List<xwTitle> getXWTitleList(int index, int size);
}
