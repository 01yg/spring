package com.example.web.controller.schedule;

import com.example.web.controller.api.DaumApi;
import com.example.web.controller.api.HolidayApi;
import com.example.web.controller.api.InvestingApi;
import com.example.web.controller.api.KrxApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleController {
    @Autowired
    HolidayApi holiday;

    @Autowired
    InvestingApi investingApi;

    @Autowired
    KrxApi krxApi;

    // 8:59
    @Scheduled(cron = "0 56 8 * * MON-FRI", zone="Asia/Seoul")
    public void schedule1() {
        // 이슈코드 생성
        krxApi.call();
        // 오늘 날짜 테이블 생성
        investingApi.createTable();
        // 홀리데이 초기화
        holiday.isHoliday(null);

    }
    // 9:00 ~ 14:59 25
    @Scheduled(cron = "0 * 9-14 * * MON-FRI", zone="Asia/Seoul")
    public void schedule2() {
        if(!DaumApi.isHoliday) {
            // 스케쥴러 순서도
            // 1. isHoliday 휴일 체크
            // 2. 인베스팅 api 호출
            investingApi.call();
        }
    }
    // 9:00 ~ 14:59 25
    @Scheduled(cron = "0 0-20 15 * * MON-FRI", zone="Asia/Seoul")
    public void schedule3() {
        if(!DaumApi.isHoliday) {
            investingApi.call();
        }
    }

    // 테스트 계속 돌기
    //@Scheduled(cron = "0 * * * * *", zone="Asia/Seoul")
    //public void schedule4() {
    //    System.out.println("schedule4");
    //    investingApi.call();
    //}
}
