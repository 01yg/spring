package com.example.web.controller.api;

import com.example.web.controller.db.HistoryDbCtrl;
import com.example.web.dto.HistoryDTO;
import com.example.web.http.CallApi;
import com.example.web.util.Util;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/daum")
public class DaumApi {
    @Autowired
    HistoryDbCtrl history;

    //@Autowired
    //StockDbCtrl stock;

    public static JSONArray includedStocks;
    public static JSONArray quotes;
    public static boolean isHoliday;

//    public static String includedCode = "D0011017"; // 01 종목 코드
//    public static String includedName = "전기가스업"; // 01 종목명

//    public static String includedCode = "D0011006"; // 02 종목 코드
//    public static String includedName = "섬유의복"; // 02 종목명
//
//    public static String includedCode = "D0011012"; // 03 종목 코드
//    public static String includedName = "기계"; // 03 종목명
//
//    public static String includedCode = "D0011014"; // 04 종목 코드
//    public static String includedName = "의료정밀"; // 04 종목명
//
//    public static String includedCode = "D0011011"; // 05 종목 코드
//    public static String includedName = "철강금속"; // 05 종목명

//    public static String includedCode = "D0011009"; // 06 종목 코드
//    public static String includedName = "의약품"; // 06 종목명
//
//    public static String includedCode = "D0011018"; // 07 종목 코드
//    public static String includedName = "건설업"; // 07 종목명
//
//   public static String includedCode = "D0011016"; // 08 종목 코드
//    public static String includedName = "유통업"; // 08 종목명
//
//    public static String includedCode = "D0011008"; // 09 종목 코드
//    public static String includedName = "화학"; // 09 종목명
//
//    public static String includedCode = "D0011022"; // 10 종목 코드
//    public static String includedName = "은행"; // 10 종목명

//    public static String includedCode = "D0011026"; // 11 종목 코드
//    public static String includedName = "서비스업"; // 11 종목명

    public static String includedCode = "D0011020"; // 12 종목 코드
    public static String includedName = "통신업"; // 12 종목명
//
//    public static String includedCode = "D0011021"; // 13 종목 코드
//    public static String includedName = "금융업"; // 13 종목명
//
//    public static String includedCode = "D0011007"; // 14 종목 코드
//    public static String includedName = "종이목재"; // 14 종목명
//
//    public static String includedCode = "D0011015"; // 15 종목 코드
//    public static String includedName = "운수장비"; // 15 종목명
//
//    public static String includedCode = "D0011013"; // 16 종목 코드
//    public static String includedName = "전기전자"; // 16 종목명
//
//    public static String includedCode = "D0011005"; // 17 종목 코드
//    public static String includedName = "음식료품"; // 17 종목명
//
//    public static String includedCode = "D0011019"; // 18 종목 코드
//    public static String includedName = "운수창고"; // 18 종목명
//
//    public static String includedCode = "D0011010"; // 19 종목 코드
//    public static String includedName = "비금속광물"; // 19 종목명
//
//    public static String includedCode = "D0011024"; // 20 종목 코드
//    public static String includedName = "증권"; // 20 종목명
//
//    public static String includedCode = "D0011025"; // 21 종목 코드
//    public static String includedName = "보험"; // 21 종목명
//
//    public static String includedCode = "E4012072"; // 22 종목 코드
//    public static String includedName = "일반전기전자"; // 22 종목명
//
//    public static String includedCode = "E4012026"; // 23 종목 코드
//    public static String includedName = "건설"; // 23 종목명
//
//    public static String includedCode = "E4012154"; // 24 종목 코드
//    public static String includedName = "디지털컨텐츠"; // 24 종목명
//
//    public static String includedCode = "E4012037"; // 25 종목 코드
//    public static String includedName = "오락·문화"; // 25 종목명
//
//    public static String includedCode = "E4012157"; // 26 종목 코드
//    public static String includedName = "통신장비"; // 26 종목명
//
//    public static String includedCode = "E4012068"; // 27 종목 코드
//    public static String includedName = "금속"; // 27 종목명
//
//    public static String includedCode = "E4012042"; // 28 종목 코드
//    public static String includedName = "IT S/W & 서비스"; // 28 종목명
//
//    public static String includedCode = "E4012031"; // 29 종목 코드
//    public static String includedName = "금융"; // 29 종목명
//
//    public static String includedCode = "E4012027"; // 30 종목 코드
//    public static String includedName = "유통"; // 30 종목명
//
//    public static String includedCode = "E4012015"; // 31 종목 코드
//    public static String includedName = "IT 지수"; // 31 종목명
//
//    public static String includedCode = "E4012066"; // 32 종목 코드
//    public static String includedName = "제약"; // 32 종목명
//
//    public static String includedCode = "E4012024"; // 33 종목 코드
//    public static String includedName = "제조"; // 33 종목명
//
//    public static String includedCode = "E4012043"; // 34 종목 코드
//    public static String includedName = "IT 하드웨어"; // 34 종목명
//
//    public static String includedCode = "E4012077"; // 35 종목 코드
//    public static String includedName = "기타 제조"; // 35 종목명
//
//    public static String includedCode = "E4012075"; // 36 종목 코드
//    public static String includedName = "운송장비·부품"; // 36 종목명
//
//    public static String includedCode = "E4012062"; // 37 종목 코드
//    public static String includedName = "종이·목재"; // 37 종목명
//
//    public static String includedCode = "E4012063"; // 38 종목 코드
//    public static String includedName = "출판·매체복제"; // 38 종목명
//
//    public static String includedCode = "E4012074"; // 39 종목 코드
//    public static String includedName = "의료·정밀기기"; // 39 종목명
//
//    public static String includedCode = "E4012067"; // 40 종목 코드
//    public static String includedName = "비금속"; // 40 종목명
//
//    public static String includedCode = "E4012155"; // 41 종목 코드
//    public static String includedName = "소프트웨어"; // 41 종목명
//
//    public static String includedCode = "E4012158"; // 42 종목 코드
//    public static String includedName = "정보기기"; // 42 종목명
//
//    public static String includedCode = "E4012159"; // 43 종목 코드
//    public static String includedName = "반도체"; // 43 종목명
//
//    public static String includedCode = "E4012012"; // 44 종목 코드
//    public static String includedName = "기타서비스"; // 44 종목명
//
//    public static String includedCode = "E4012065"; // 45 종목 코드
//    public static String includedName = "화학"; // 45 종목명
//
//    public static String includedCode = "E4012151"; // 46 종목 코드
//    public static String includedName = "통신서비스"; // 46 종목명
//
//    public static String includedCode = "E4012041"; // 47 종목 코드
//    public static String includedName = "통신방송서비스"; // 47 종목명
//
//    public static String includedCode = "E4012152"; // 48 종목 코드
//    public static String includedName = "방송서비스"; // 48 종목명
//
//    public static String includedCode = "E4012070"; // 49 종목 코드
//    public static String includedName = "기계·장비"; // 49 종목명
//
//    public static String includedCode = "E4012056"; // 50 종목 코드
//    public static String includedName = "음식료·담배"; // 50 종목명
//
//    public static String includedCode = "E4012058"; // 51 종목 코드
//    public static String includedName = "섬유·의류"; // 51 종목명
//
//    public static String includedCode = "E4012156"; // 52 종목 코드
//    public static String includedName = "컴퓨터서비스"; // 52 종목명
//
//    public static String includedCode = "E4012153"; // 53 종목 코드
//    public static String includedName = "인터넷"; // 53 종목명
//
//    public static String includedCode = "E4012029"; // 54 종목 코드
//    public static String includedName = "운송"; // 54 종목명

    // 종목코드 리스트
    @GetMapping("/includedStocks")
    public void getIncludedStocks() {
        String url = "https://finance.daum.net/api/sectors/"+includedCode+"/includedStocks?symbolCode="+includedCode+"&page=1&perPage=100&fieldName=changeRate&order=desc&pagination=true";
        JSONObject jObject = CallApi.get(url);
        if(jObject == null) {
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setDate(Util.getTodayString());
            historyDTO.setName(includedName);
            historyDTO.setReason(includedName + "종목코드 리스트 api 호출 실패");
            history.insert(historyDTO);
            System.out.println("error: 종목코드 리스트 api 호출 실패");
        } else {
            includedStocks = jObject.getJSONArray("includedStocks");
        }
    }

    // 상세정보
    // https://finance.daum.net/api/quotes/A034020?summary=false&changeStatistics=true
    public JSONObject setQuotes(JSONObject object) {
        String code = object.getString("code");
        //String name = object.getString("name");
        String url = "https://finance.daum.net/api/quotes/"+code+"?summary=false&changeStatistics=true";
        JSONObject data = CallApi.get(url);

        //HistoryDTO historyDTO = new HistoryDTO();
        //historyDTO.setDate(Util.getTodayString());
        if(data == null) {
            // 실패
            //historyDTO.setName(name);
            //historyDTO.setReason("setQuotes : api 호출 실패");
            // 실패시 다시 콜
            return setQuotes(object);
            // System.out.println("error: 상세정보 api 호출 실패");
            // if(!history.insert(historyDTO)) { // 로그 남기기
            //     historyDTO.setReason("setQuotes : history insert 실패");
            //     history.insert(historyDTO);
            //     System.out.println("error: history insert 실패");
            // }
        } else {
            data.put("currentTime", Util.getTodayString());
            // 성공
            return data;
            //if(!stock.insert(data)) {
            //    historyDTO.setName(name);
            //    historyDTO.setReason("setQuotes : stock insert 실패");
            //    history.insert(historyDTO);
            //    System.out.println("error: stock insert 실패");
            //};
        }
    }

    // 재귀 호출 상세 주식정보 재귀호출
    public void recursionQuotes() {
        //ArrayList<StockDTO> stocks = new ArrayList<>();
        JSONArray array = new JSONArray();

        if(DaumApi.includedStocks != null) {

            for (int i = 0; i < DaumApi.includedStocks.length(); i++) {
                JSONObject included = DaumApi.includedStocks.getJSONObject(i);
                JSONObject quote = setQuotes(included);
                array.put(quote);
                //stocks.add(toStockDTO(quotes));
            }

            quotes = array;

            //System.out.println("stock.insert(stocks)");
            //if(stock.insert(stocks)) {
            //    HistoryDTO historyDTO = new HistoryDTO();
            //    historyDTO.setDate(Util.getTodayString());
            //    historyDTO.setName(includedName);
            //    historyDTO.setReason("setQuotes : api 호출 실패");
            //}
        } else {
            System.out.println("not includedStocks");
        }
    }

    @GetMapping("/quotes")
    @ResponseBody
    public List getQuotes() {
        return quotes.putAll(quotes).toList();
    }
}