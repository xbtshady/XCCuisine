package com.XCCuisine.api.xcc.img.Controller;

import com.XCCuisine.api.XWVO;
import com.XCCuisine.api.xcc.img.model.ImgIo;
import com.XCCuisine.api.xcc.img.service.IImgService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping(value = "/api/xcc/img")
@RestController
public class ImgController {
    @Resource
    IImgService imgService;

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    @ResponseBody
    public XWVO upload(@Valid @RequestBody ImgIo imgIo) throws Exception {
        return imgService.upload(imgIo);
    }
}
