package com.example.web.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
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

    public static int getDayOfWeek() {
        // 1. LocalDate 생성
        LocalDate date = LocalDate.of(2021, 12, 25);
        // LocalDateTime date = LocalDateTime.of(2021, 12, 25, 1, 15, 20);
        System.out.println(date); // // 2021-12-25
        // 2. DayOfWeek 객체 구하기
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // 3. 숫자 요일 구하기
        int dayOfWeekNumber = dayOfWeek.getValue();
        // 4. 숫자 요일 출력
        return dayOfWeekNumber;
    }
}
