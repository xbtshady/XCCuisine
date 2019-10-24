package com.XCCuisine.api.xcc.img.service.impl;

import com.XCCuisine.api.XWVO;
import com.XCCuisine.api.xcc.img.model.ImgIo;
import com.XCCuisine.api.xcc.img.service.IImgService;
import com.XCCuisine.constant.Constant;
import com.XCCuisine.until.DateUntil;
import com.XCCuisine.until.ImageUtil;
import com.XCCuisine.until.Imagebase64;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

@Service
public class ImgService implements IImgService {
    @Override
    public XWVO upload(ImgIo imgIo) throws Exception {
        XWVO xwvo = new XWVO();
        //获取入参
        String img = imgIo.getImg();
        String dir = imgIo.getDir();
        String suffix = imgIo.getSuffix();
        //根据md5码获取BufferedImage
        BufferedImage bi = Imagebase64.base64StringToImage(img);
        //使用时间作为图片的名字
        Date now = new Date();
        String imgName = DateUntil.formatMs(now,"yyyy-MM-dd-HH-mm-ss");
        //存储图片
        ImageUtil.saveImg(bi,dir,imgName,suffix);
        //返回成功
        xwvo.setCode(Constant.CORRECT_CODE);
        xwvo.setMsg(Constant.CORRECT_MSG);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgName",imgName + "." + suffix);
        xwvo.setData(jsonObject);
        return xwvo;
    }
}
