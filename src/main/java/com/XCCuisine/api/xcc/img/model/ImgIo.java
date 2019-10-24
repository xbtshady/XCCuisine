package com.XCCuisine.api.xcc.img.model;

public class ImgIo {
    //图片md5
    private String img;
    //路径
    private String dir;
    //图片后缀
    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
