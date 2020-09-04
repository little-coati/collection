package com.my.common.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间转化的工具类
 */
@Slf4j
public class DateUtil {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前日期
     */
    public synchronized static String getCurrentDate() {
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 获取当前时间
     */
    public synchronized static String getCurrentTime() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 获取上个月的日期
     *
     * @return
     */
    public synchronized static String getCurrentBeforeMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return sdf.format(m);
    }


    /**
     * 获取指定格式的当前时间
     *
     * @param format 指定的时间格式
     * @return 指定格式的当前时间字符串
     */
    public static String getNowTimeFormat(String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        return dateformat.format(new Date());
    }

    /**
     * long时间类型转化为String
     *
     * @param ts
     * @return
     */
    public static String longToString(long ts) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateformat.format(new Timestamp(ts));
    }

    public static String longToStringNormatization(long ts) {
        DateFormat dateformat_nor = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        return dateformat_nor.format(new Timestamp(ts));
    }

    public static String longToStringNormatizationMonitor(long ts) {
        DateFormat dateformat_nor_nonitor = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        return dateformat_nor_nonitor.format(new Timestamp(ts));
    }

    public static String timestampToString(Timestamp time) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (time == null) {
            return null;
        }
        return sdf.format(time);
    }

    public static Date longToDate(long ts) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = (Date) dateformat.parse(longToString(ts));
        } catch (ParseException e) {
            log.info("DateUtil Method longToDate ParseException");
        }
        return time;
    }

    public static long StringToLong(String ts) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = (Date) dateformat.parse(ts);
        } catch (ParseException e) {
            log.info("DateUtil Method StringToLong ParseException");
        }

        if (null != time) {
            return time.getTime();
        } else {
            throw new NullPointerException("日期转换错误");
        }
    }

    public static long timestampToLong(Timestamp timestamp) {
        return DateUtil.StringToLong(DateUtil.timestampToString(timestamp));
    }

    public static String DateToString(Date ts) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (ts == null) {
            return "";
        }
        return dateformat.format(ts);
    }

    public static Timestamp StringToTimestamp(String timeStr) {
        return Timestamp.valueOf(timeStr);
    }

    public static Date StringToDate(String timeStr) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = dateformat.parse(timeStr);
        } catch (ParseException e) {
            log.info("DateUtil Method StringToDate ParseException");
        }
        return time;
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转成 其他格式字符串时间
     *
     * @param timeStr
     * @param pattern
     * @return
     */
    public static String formatDateStr(String timeStr, String pattern) {
        if (StringUtil.isNullOrEmpty(timeStr)) {
            return timeStr;
        }
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date time = null;
        try {
            time = dateformat.parse(timeStr);
        } catch (ParseException e) {
            log.info("DateUtil Method formatDateStr ParseException");
        }
        return sdf.format(time);
    }

    /**
     * 日期转换成cron表达式
     *
     * @param date
     * @return
     */
    public static String formatDateByPattern(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ?");
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    public static String formatDateByDateTime(Date date) {
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 获取hour前或者后的时间
     *
     * @param date
     * @param hour
     * @return
     */
    public static String getTimeByHour(Date date, int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.HOUR, hour);
        Date dt1 = rightNow.getTime();
        return sdf.format(dt1);
    }

    public static String dateTransform(String date) {
        String dateStr = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss z", Locale.ENGLISH);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateStr = df.format(format.parse(date));
        } catch (ParseException e) {
            log.info("DateUtil Method dateTransform ParseException");
        }
        return dateStr;
    }
}
