package com.example.web.controller.api;

import com.example.web.controller.DataCtrl;
import com.example.web.controller.db.StockDbCtrl;
import com.example.web.dto.StockDTO;
import com.example.web.http.DaumHttp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@Component
@CrossOrigin(origins = {"http://113.131.145.133:3000", "http://localhost:3000"})
public class StockApi {
    @Autowired
    StockDbCtrl stock;
    
//    String[] arr = {"3.39.24.69" , "3.38.245.236", "3.36.133.160", "3.38.210.152", "3.36.62.3"};
    String[] arr = {"3.36.100.76" , "3.38.169.255", "3.39.24.162", "3.38.166.46", "3.38.152.61"};

    // 종목코드 리스트
    public void setDbStocks() {
        ArrayList<StockDTO> stocks = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++) {
            String url = "http://"+arr[i]+"/daum/quotes";
            JSONArray jArray = DaumHttp.gets(url);

            for(int j = 0; j < jArray.length(); j++) {
                JSONObject quotes = jArray.getJSONObject(j);
                if(!quotes.getString("exchangeDate").equals(""))
                    stocks.add(DataCtrl.toStockDTO(quotes));
            }
        }
        try {
            if(stock.insert(stocks)) {
                System.out.println("setDbStocks 실패");
            } else {
                System.out.println("setDbStocks 성공");
            }
        } catch (Exception e) {
            System.out.println("setDbStocks error");
        }
    }
}
