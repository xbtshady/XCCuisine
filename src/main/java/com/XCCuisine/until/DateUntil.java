package com.XCCuisine.until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntil {
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String formatMs(Date date){
        String ret = "";
        try {
            ret = simpleDateFormat.format(date);
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }

    public static String formatMs(Date date,String format){
        SimpleDateFormat s = new SimpleDateFormat(format);
        String ret = "";
        try {
            ret = s.format(date);
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }
}
