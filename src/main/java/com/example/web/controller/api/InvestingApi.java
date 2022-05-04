package com.example.web.controller.api;

import com.example.web.controller.db.InvestingCtrl;
import com.example.web.dto.InvestingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/investing")
@CrossOrigin(origins = "http://18.220.98.204:3000")
public class InvestingApi {
    @Autowired
    InvestingCtrl ctrl;

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