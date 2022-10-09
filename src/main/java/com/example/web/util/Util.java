package com.example.web.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.example.web.controller.api.HolidayApi;

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

    public static String getTodayString3() {
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        formatTime.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        String todayString = formatTime.format(date);

        return todayString;
    }

    public static boolean getDayOfWeek(LocalDate date) {
        // 1. LocalDate 생성
        //LocalDate date = LocalDate.of(date.getYear(), 12, 25);
        // LocalDateTime date = LocalDateTime.of(2021, 12, 25, 1, 15, 20);
        System.out.println(date); // // 2021-12-25
        // 2. DayOfWeek 객체 구하기
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // 3. 숫자 요일 구하기
        int dayOfWeekNumber = dayOfWeek.getValue();
        // 4. 토요일(6) 또는 일요일(7) : true, 나머지 : false
        return dayOfWeekNumber > 5;
    }

    // 가장 최근 개장일 구하기
    public static String getOpeningDate() {
        // 1. 오늘 날짜
        LocalDate openingDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

        // 2. 포멧 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        do {
            // 2. 하루 뺴기
            openingDate = openingDate.minusDays(1);
        } while (
            // 3. 주말인가?
            getDayOfWeek(openingDate) ||
            // 4. 홀리데이인가?
            new HolidayApi().isHoliday(openingDate.format(formatter))
        );

        // 5. 통과한 날짜 리턴
        return openingDate.format(formatter);
    }

    // 가장 최근 개장일 int
    public static int getOpeningInt() {
        // 1. 오늘 날짜
        LocalDate openingDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

        // 2. 포멧 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int i = 0;
        do {
            i++;
            // 2. 하루 뺴기
            openingDate = openingDate.minusDays(1);
        } while (
            // 3. 주말인가?
                getDayOfWeek(openingDate) ||
                        // 4. 홀리데이인가?
                        new HolidayApi().isHoliday(openingDate.format(formatter))
        );

        // 5. 통과한 날짜 리턴
        return i;
    }
}