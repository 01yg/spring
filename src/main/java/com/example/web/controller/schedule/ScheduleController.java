package com.example.web.controller.schedule;

import com.example.web.controller.DataCtrl;
import com.example.web.controller.api.DaumApi;
import com.example.web.controller.api.HolidayApi;
import com.example.web.controller.api.StockApi;
import com.example.web.util.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleController {
    @Autowired
    DaumApi daum;

    @Autowired
    HolidayApi holiday;

    @Autowired
    DataCtrl dataCtrl;

    @Autowired
    StockApi stockApi;

    static public int i = 0;
    // 8:59
    @Scheduled(cron = "0 59 8 * * MON-FRI", zone="Asia/Seoul")
    public void schedule1() {
        // 홀리데이 초기화
        holiday.isHoliday(Util.getTodayString2());
        // includedStocks 초기화
//        if(!DaumApi.isHoliday) {
//            daum.getIncludedStocks();
//        }
    }
    // 9:00 ~ 14:59 25
    @Scheduled(cron = "35 * 9-14 * * MON-FRI", zone="Asia/Seoul")
    public void schedule2() {
//        if(!DaumApi.isHoliday) {
//            daum.recursionQuotes();
//        }
        if(!DaumApi.isHoliday) {
            stockApi.setDbStocks();
        }
    }
    // 9:00 ~ 14:59 25
    @Scheduled(cron = "35 0-30 15 * * MON-FRI", zone="Asia/Seoul")
    public void schedule3() {
//        if(!DaumApi.isHoliday) {
//            daum.recursionQuotes();
//        }
        if(!DaumApi.isHoliday) {
            stockApi.setDbStocks();
        }
    }

    // 테스트 계속 돌기
//    @Scheduled(cron = "* * * * * *", zone="Asia/Seoul")
//    public void schedule4() {
//        if(i == 0) {
//            daum.getIncludedStocks();
//            i++;
//        }
//        daum.recursionQuotes();
//        //stockApi.setDbStocks();
//    }
}
