package com.ouwenbin.dmzj_app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间戳转换工具
 */
public class DateCovertUtil {

    public static String getDate(long number) {
        Date date = new Date(number * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        String updateTime = simpleDateFormat.format(date);
        return updateTime;
    }
}
