package com.XCCuisine.XCCuisine.api.dao;

import com.XCCuisine.XCCuisine.api.dao.po.XWTitle;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XWTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XWTitle record);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(XWTitle record);

    XWTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XWTitle record);

    int updateByPrimaryKey(XWTitle record);

    List<XWTitle> queryXwTitle(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);

}