package com.example.web.controller.api;

import com.example.web.http.CallApi;
import com.example.web.util.Util;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.web.util.Util.getOpeningDate;

@RestController
@RequestMapping("/holiday")
public class HolidayApi {

    @GetMapping("/call")
    @ResponseBody
    public List call(@RequestParam(value="todayString", required=false) String todayString) {
        String url = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?" +
                "serviceKey=Js10J2bn%2B03d15sWQ6w2qep%2B3QWjnpJeOhm9N%2FzhRxVRngOLJsxVZ6ApZMHVFRlOj5zwGilQXZju8HVYTH0IXA%3D%3D" +
                "&solYear=" + 2022 +
                "&solMonth=" + String.format("%02d", 3) +
                "&_type=json" +
                "&numOfRows=20";
        JSONObject jObject = CallApi.get(url);

        JSONObject response = jObject.getJSONObject("response");
        JSONObject body = response.getJSONObject("body");
        JSONObject items = body.getJSONObject("items");
        JSONArray item = items.getJSONArray("item");

        return item.putAll(item).toList();
    }

    @GetMapping("/isHoliday")
    @ResponseBody
    public boolean isHoliday(@RequestParam(value="todayString", required=false) String todayString) {
        if (todayString == null) {
            todayString = Util.getTodayString2();
        }
        try {
            String[] todays = todayString.split("-");

            String year= todays[0];
            String month= todays[1];

            String url = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?" +
                    "serviceKey=Js10J2bn%2B03d15sWQ6w2qep%2B3QWjnpJeOhm9N%2FzhRxVRngOLJsxVZ6ApZMHVFRlOj5zwGilQXZju8HVYTH0IXA%3D%3D" +
                    "&solYear=" + year +
                    "&solMonth=" + month +
                    "&_type=json" +
                    "&numOfRows=20";

            JSONObject jObject = CallApi.get(url);
            JSONObject response = jObject.getJSONObject("response");
            JSONObject body = response.getJSONObject("body");
            JSONObject items = body.getJSONObject("items");
            JSONArray item = items.getJSONArray("item");

            boolean b = false;
            for(int i = 0; i < item.length(); i++) {
                b = todayString.replaceAll("-", "").equals(String.valueOf(item.getJSONObject(i).getInt("locdate")));
                if(b) {
                    break;
                }
            }
            DaumApi.isHoliday = b;
            return b;
        } catch (Exception e) {
            DaumApi.isHoliday = false;
            return false;
        }
    }

    @GetMapping("/getOpeningDate")
    @ResponseBody
    public String openingDate() {
        return getOpeningDate();
    }
}
