package com.example.web.controller.api;

import com.example.web.http.NaverHttp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/naver")
@CrossOrigin(origins = {"http://113.131.145.133:3000", "http://localhost:3000"})
public class NaverApi {
    @GetMapping("/item")
    @ResponseBody
    public Map item(
            @RequestParam(value="isuName", required = false) String isuName,
            @RequestParam(value="periodType", required = false) String periodType,
            @RequestParam(value="range", required = false) String range) {
        System.out.println(isuName);
        System.out.println(periodType);
        System.out.println(range);

        JSONObject jsonObject = NaverHttp.get("https://api.stock.naver.com/chart/domestic/item/035720" + //KrxApi.isu.get(isuName) +
                "?periodType=" + periodType +
                "&range=" + range);

        return jsonObject.toMap();
    }
}