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
        System.out.println("ctrl.insert()");
        HashMap<String, InvestingDTO> investings = ctrl.getInvestings();
        if(investings != null) {
            System.out.println("ctrl.insertTechnical()");
            investings = ctrl.insertTechnical(investings);
            if(investings != null) {
                System.out.println("ctrl.updateDataTheDayBefore()");
                ctrl.updateDataTheDayBefore(investings);
            }
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