package com.example.web.controller.api;

import com.example.web.controller.db.HistoryDbCtrl;
import com.example.web.controller.db.InvestingCtrl;
import com.example.web.dao.InvestingDAO;
import com.example.web.dto.HistoryDTO;
import com.example.web.dto.InvestingDTO;
import com.example.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/investing")
//@CrossOrigin(origins = "http://20.214.141.2")
@CrossOrigin(origins = "http://113.131.152.55:3000, http://localhost:3000")
public class InvestingApi {
    @Autowired
    InvestingCtrl ctrl;

    @Autowired
    private InvestingDAO investingDAO;

    @Autowired
    HistoryDbCtrl history;

    // 하루에 한번 테이블 생성
    //createInvesting
    @GetMapping("/createTable")
    @ResponseBody
    public void createTable() {
        // 오늘 날짜 가져오기
        investingDAO.createInvesting(Util.getTodayString3());
    }

    // 1분 마다 크롤링
    @GetMapping("/postCall")
    @ResponseBody
    public void call() {
        // 인베스팅 api 순서도
        // 1. 컨트롤러 getInvestings() 크롤링하여 주식 정보 가져오기, 각각의 컨트롤러안에서 예외는 처리함
        // 2. 컨트롤러 insertTechnical() 크롤링하여 점수 가져오기, 각각의 컨트롤러안에서 예외는 처리함
        // 3. 실제로 dao.insert() 를 하는 것이 좋을듯
        // . 컨트롤러 updateDataTheDayBefor() 하루전 데이터 업데이트 함.. << 업데이트 보다 조회해서 합치는게 좋을거 같고 일단 이건 보류혀자
        System.out.println("ctrl.insert()");
        HashMap<String, InvestingDTO> investings = ctrl.getInvestings();
        if(investings != null) {
            System.out.println("ctrl.insertTechnical()");
            investings = ctrl.insertTechnical(investings);

            try { // 여기가 3번 실제로 인서트를 함
                Map<String,Object> map = new HashMap<String,Object>();

                ArrayList<InvestingDTO> list = new ArrayList();
                investings.forEach((strKey, strValue) -> {
                    list.add(strValue);
                });

                map.put("list", list);
                map.put("date", Util.getTodayString3());

                System.out.println("investingDAO.insertInvesting(investings)");
                investingDAO.insertInvesting(map);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("investing insert fail");
                HistoryDTO historyDTO = new HistoryDTO();
                historyDTO.setName("investing insert fail");
                historyDTO.setReason(e.getMessage());
                history.insert(historyDTO);
            }

            //if(investings != null) {
            //    System.out.println("ctrl.updateDataTheDayBefore()");
            //    ctrl.updateDataTheDayBefore(investings);
            //}
        }
    }

    // 1분 마다 크롤링
    @GetMapping("/call")
    @ResponseBody
    public void call2() {
        //ctrl.insertTechnical();
    }

    // 데이터 조회
    @GetMapping("/")
    @ResponseBody
    public List<InvestingDTO> get() {
        return ctrl.select();
    }
}