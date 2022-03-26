package com.example.web.controller.api;

import com.example.web.controller.db.InvestingCtrl;
import com.example.web.crawling.InvestingCrawling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investingApi")
public class InvestingApi {
    @Autowired
    InvestingCtrl ctrl;

    @GetMapping("/call")
    @ResponseBody
    public void call() {
        ctrl.insert();
    }
}