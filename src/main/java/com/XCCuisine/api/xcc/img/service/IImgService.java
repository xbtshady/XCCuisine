package com.XCCuisine.api.xcc.img.service;

import com.XCCuisine.api.XWVO;
import com.XCCuisine.api.xcc.img.model.ImgIo;


public interface IImgService {
    XWVO upload(ImgIo imgIo) throws Exception;
}
