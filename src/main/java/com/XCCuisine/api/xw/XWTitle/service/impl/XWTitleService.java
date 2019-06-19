package com.XCCuisine.api.xw.XWTitle.service.impl;

import com.XCCuisine.api.XWVO;
import com.XCCuisine.constant.Constant;
import com.XCCuisine.dao.XWTitleMapper;
import com.XCCuisine.dao.po.XWTitle;

import com.XCCuisine.api.xw.XWTitle.model.io.GetXWTitleByIdIO;
import com.XCCuisine.api.xw.XWTitle.model.io.GetXWTitleListServiceIO;
import com.XCCuisine.api.xw.XWTitle.model.io.XWTitleServiceIO;
import com.XCCuisine.api.xw.XWTitle.service.IXWTitleService;

import com.XCCuisine.exception.ExceptionConstants;
import com.XCCuisine.exception.XWBusinessException;
import com.XCCuisine.until.DateUntil;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class XWTitleService implements IXWTitleService {
    @Resource
    XWTitleMapper xwTitleMapper;

    @Override
    public List<Map<String,Object>> getXWTitleList(GetXWTitleListServiceIO getXWTitleListServiceIO)throws Exception {
        Integer index = getXWTitleListServiceIO.getIndex() == null ? 1 : getXWTitleListServiceIO.getIndex();
        Integer size = getXWTitleListServiceIO.getSize() == null ? 5 : getXWTitleListServiceIO.getSize();
        List<Map<String,Object>> result = xwTitleMapper.getXwTitleList(size * (index - 1) ,size);
        if(!result.isEmpty()){
            for(Map<String,Object> m : result){
                m.put("updateTime", DateUntil.formatMs((Date) m.get("updateTime")));
                m.put("createTime", DateUntil.formatMs((Date) m.get("createTime")));
            }
        }
        return result;
    }

    @Override
    public XWTitle getXWTitleById(GetXWTitleByIdIO getXWTitleByIdIO) throws Exception {
        XWTitle result = xwTitleMapper.selectByPrimaryKey(getXWTitleByIdIO.getId());
        if(result == null){
            throw new XWBusinessException(ExceptionConstants.TITLE_NOT_FOUND_CODE,
                    ExceptionConstants.TITLE_NOT_FOUND_MSG);
        }
        return result;
    }

    @Override
    public XWVO setXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception {
        XWVO vo = new XWVO();
        vo.setCode(Constant.CORRECT_CODE);
        vo.setMsg(Constant.CORRECT_MSG);
        JSONObject data = new JSONObject();
        xwTitleMapper.insertSelective(xwTitleServiceIO.getXwTitle());
        data.put("id",xwTitleServiceIO.getXwTitle().getId());
        vo.setData(data);
        return vo;

    }

    @Override
    public XWVO updateXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception {
        XWVO vo = new XWVO();
        checkId(xwTitleServiceIO.getXwTitle());
        xwTitleMapper.updateByPrimaryKeySelective(xwTitleServiceIO.getXwTitle());
        vo.setCode(Constant.CORRECT_CODE);
        vo.setMsg(Constant.CORRECT_MSG);
        return vo;
    }

    @Override
    public XWVO deleteXWTitle(XWTitleServiceIO xwTitleServiceIO)throws Exception {
        XWVO vo = new XWVO();
        checkId(xwTitleServiceIO.getXwTitle());

        xwTitleMapper.deleteByPrimaryKey(xwTitleServiceIO.getXwTitle().getId());
        vo.setCode(Constant.CORRECT_CODE);
        vo.setMsg(Constant.CORRECT_MSG);
        return vo;
    }

    private void  checkId(XWTitle xwTitle)throws Exception{
        XWVO vo = new XWVO();
        if(xwTitle.getId() == null){
            throw new XWBusinessException(ExceptionConstants.PARAMETER_CANNOT_EMPTY_CODE,
                    ExceptionConstants.PARAMETER_CANNOT_EMPTY_MSG);

        }
        XWTitle result = xwTitleMapper.selectByPrimaryKey(xwTitle.getId());
        if(result == null){
            throw new XWBusinessException(ExceptionConstants.TITLE_NOT_FOUND_CODE,
                    ExceptionConstants.TITLE_NOT_FOUND_MSG);

        }
    }
}
