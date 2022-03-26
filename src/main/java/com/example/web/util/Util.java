package com.example.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Util {
    public static String getTodayString() {
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        formatTime.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        String todayString = formatTime.format(date);

        return todayString;
    }

    public static String getTodayString2() {
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        formatTime.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        String todayString = formatTime.format(date);

        return todayString;
    }
}
