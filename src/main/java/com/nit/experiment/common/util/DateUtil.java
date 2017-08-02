package com.nit.experiment.common.util;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 江建平 on 2017/8/2.
 */
public class DateUtil {
    private static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat sdf;
    public static Date dateFormat(Date date) throws Exception{

        sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdf.parse(date.toString());
    }
}
