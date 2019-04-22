package com.XCCuisine.XCCuisine.api.model.xw.XWTitleService;

import com.XCCuisine.XCCuisine.api.dao.po.XWTitle;
import javax.validation.constraints.NotNull;
public class XWTitleServiceIO {
    @NotNull(message = "不能为空")
    private XWTitle xwTitle;

    public XWTitle getXwTitle() {
        return xwTitle;
    }
    public void setXwTitle(XWTitle xwTitle) {
        this.xwTitle = xwTitle;
    }
}
