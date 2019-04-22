package com.XCCuisine.XCCuisine.api.exception;

public class XWBusinessException extends Exception {
    private static final long serialVersionUID = 1;
    private int code;
    private String errorMsg;

    public XWBusinessException(int code, String errorMsg) {
        super(errorMsg);
        this.code = code;
        this.errorMsg = errorMsg;
    }


    public XWBusinessException(int code, String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
