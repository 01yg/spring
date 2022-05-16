package com.example.web.controller.api;

import com.example.web.dao.IsuDAO;
import com.example.web.dto.IsuDTO;
import com.example.web.http.KrxHttp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/krx")
@CrossOrigin(origins = "http://localhost:3000")
public class KrxApi {
    @Autowired
    private IsuDAO isuDAO;

    // 하루에 한번
    @GetMapping("/call")
    @ResponseBody
    public void call() {
        ArrayList<IsuDTO> isus = new ArrayList();

        // 초기화
        isus.clear();

        // 조회
        JSONObject jObject = KrxHttp.get();

        // 가공 (HashMap 으로)
        JSONArray outBlocks = jObject.getJSONArray("OutBlock_1");

        outBlocks.forEach((outBlock) -> {
            IsuDTO isu = new IsuDTO();
            JSONObject block = (JSONObject) outBlock;
            isu.setISU_ABBRV(block.getString("ISU_ABBRV"));
            isu.setISU_SRT_CD(block.getString("ISU_SRT_CD"));
            isus.add(isu);
        });

        // 디비 딜리트 후
        isuDAO.deleteIsu();

        // 디비 인서트
        isuDAO.insertIsu(isus);
    }
}
