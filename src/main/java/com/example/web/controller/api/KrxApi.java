package com.example.web.controller.api;

import com.example.web.dto.IsuDTO;
import com.example.web.http.KrxHttp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/krx")
@CrossOrigin(origins = "http://localhost:3001")
public class KrxApi {
    public static HashMap<String, String> isus;

    @GetMapping("/call")
    @ResponseBody
    public void call() {
        // 초기화
        isus.clear();

        // 조회
        JSONObject jObject = KrxHttp.get();

        // 가공 (HashMap 으로)
        JSONArray outBlocks = jObject.getJSONArray("OutBlock_1");

        outBlocks.forEach((outBlock) -> {
            JSONObject block = (JSONObject) outBlock;
            isus.put(block.getString("ISU_ABBRV"), block.getString("ISU_SRT_CD"));
        });
    }
}
