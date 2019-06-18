package com.XCCuisine.XCCuisine.api.dao;

import com.XCCuisine.XCCuisine.api.dao.po.XWTitle;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface XWTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XWTitle record);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(XWTitle record);

    XWTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XWTitle record);

    int updateByPrimaryKey(XWTitle record);

    /**
     *获取title list 关联出label
     */
    List<Map<String,Object>> getXwTitleList(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);
}