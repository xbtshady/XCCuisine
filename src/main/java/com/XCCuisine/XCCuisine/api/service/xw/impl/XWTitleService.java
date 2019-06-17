package com.XCCuisine.XCCuisine.api.service.xw.impl;

import com.XCCuisine.XCCuisine.api.constant.Constant;
import com.XCCuisine.XCCuisine.api.dao.XWTitleMapper;
import com.XCCuisine.XCCuisine.api.dao.po.XWTitle;
import com.XCCuisine.XCCuisine.api.exception.ExceptionConstants;
import com.XCCuisine.XCCuisine.api.exception.XWBusinessException;
import com.XCCuisine.XCCuisine.api.model.xw.XWTitleService.GetXWTitleByIdIO;
import com.XCCuisine.XCCuisine.api.model.xw.XWTitleService.GetXWTitleListServiceIO;
import com.XCCuisine.XCCuisine.api.model.xw.XWTitleService.XWTitleServiceIO;
import com.XCCuisine.XCCuisine.api.service.xw.IXWTitleService;
import com.XCCuisine.XCCuisine.api.model.xw.XWVO;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XWTitleService implements IXWTitleService {
    @Resource
    XWTitleMapper xwTitleMapper;

    @Override
    public List<XWTitle> getXWTitleList(GetXWTitleListServiceIO getXWTitleListServiceIO)throws Exception {
        Integer index = getXWTitleListServiceIO.getIndex() == null ? 1 : getXWTitleListServiceIO.getIndex();
        Integer size = getXWTitleListServiceIO.getSize() == null ? 5 : getXWTitleListServiceIO.getSize();
        return xwTitleMapper.queryXwTitle(size * (index - 1) ,size);
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
