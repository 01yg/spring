/*
* 해당 문서는 크롤링 예시 파일 입니다.
*
* getStockPriceList()
* 네이버에서 데이터 가져와서 헤더와 바디 출력함
*
* getStockHeader()
* 여기서 테이블 헤더를 읽어옴
*
* getStockList()
* 여기서는 테이블의 바디 부분을 읽어 옴
* */
package com.example.web.crawling;

import com.example.web.controller.api.KrxApi;
import com.example.web.dto.InvestingDTO;
import com.example.web.util.Util;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InvestingCrawling {
    public static HashMap<String, InvestingDTO> getInvestings() throws Exception {
        final String stockList = "https://kr.investing.com/equities/StocksFilter?noconstruct=1&smlID=694&sid=&tabletype=price&index_id=all";

        try {
            Connection conn = Jsoup.connect(stockList)
                    .header("x-requested-with", "XMLHttpRequest")
                    .method(Connection.Method.GET);
            Document document = conn.get();
            HashMap<String, InvestingDTO> investings = getStockList(document);   // 데이터 리스트
            System.out.println(Util.getTodayString() + ": investing crawling success");
            return investings;
        } catch (IOException ignored) {
            System.out.println(Util.getTodayString() + ": investing crawling fail");
            throw ignored;
        }
    }

    public static HashMap<String, InvestingDTO> getInvestingsTechnical(HashMap<String, InvestingDTO> investings) throws Exception {
        final String stockList = "https://kr.investing.com/equities/StocksFilter?noconstruct=1&smlID=695&sid=&tabletype=technical&index_id=all";

        try {
            Connection conn = Jsoup.connect(stockList)
                    .header("x-requested-with", "XMLHttpRequest")
                    .method(Connection.Method.GET)
                    .timeout(60000);
            Document document = conn.get();
            HashMap<String, InvestingDTO> newInvestings = getStockListTechnical(investings, document);   // 데이터 리스트
            System.out.println(Util.getTodayString() + ": investing technical crawling success");
            return newInvestings;
        } catch (IOException ignored) {
            System.out.println(Util.getTodayString() + ": investing technical crawling fail");
            throw ignored;
        }
    }

    public static String getStockHeader(Document document) {
        Elements stockTableBody = document.select("#cross_rate_markets_stocks_1 thead tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            for (Element td : element.select("th")) {
                sb.append(td.text());
                sb.append("   ");
            }
            break;
        }
        return sb.toString();
    }

    public static HashMap<String, InvestingDTO> getStockList(Document document) {
        Elements stockTableBody = document.select("table#cross_rate_markets_stocks_1 tbody tr");

        HashMap<String, InvestingDTO> hashMap = new HashMap();

        for (Element element : stockTableBody) {
            int j = 0;
            InvestingDTO investing = new InvestingDTO();
            for (Element td : element.select("td")) {
                if(!td.select(".flag").isEmpty()){
                    continue;
                } else if (!td.select(".left a").isEmpty()){
                    investing.setStock(td.select(".left a").text());
                } else if (j < 8) {
                    switch (j) {
                        case 1:
                            investing.setCurrent(Integer.valueOf(td.text().replaceAll(",", "")));
                            break;
                        case 2:
                            investing.setHigh(Integer.valueOf(td.text().replaceAll(",", "")));
                            break;
                        case 3:
                            investing.setLow(Integer.valueOf(td.text().replaceAll(",", "")));
                            break;
                        case 4:
                            investing.setChangePrice(Integer.valueOf(td.text()));
                            break;
                        case 5:
                            investing.setChangeRate(100+Float.valueOf(td.text().replaceAll("%", "")));
                            break;
                        case 6:
                            if(td.text().contains("K")) { // K 가 포함된 경우
                                double tradingVolume = Double.valueOf(td.text().replaceAll("K", ""));
                                tradingVolume = tradingVolume * 1000;
                                investing.setTradingVolume(tradingVolume);
                            } else if (td.text().contains("M")) { // M 이 포함된 경우
                                double tradingVolume = Double.valueOf(td.text().replaceAll("M", ""));
                                tradingVolume = tradingVolume * 1000000;
                                investing.setTradingVolume(tradingVolume);
                            } else { // 그외
                                int tradingVolume = Integer.valueOf(td.text());
                                investing.setTradingVolume(tradingVolume);
                            }
                            break;
                        case 7:
                            investing.setTradeTime(td.text());
                            break;
                    }
                }
                j++;
            }
            hashMap.put(investing.getStock(), investing);
        }
        return hashMap;
    }

    public static HashMap<String, InvestingDTO> getStockListTechnical(HashMap<String, InvestingDTO> investings, Document document) {
        Elements stockTableBody = document.select("table#marketsTechnical tbody tr");

        for (Element element : stockTableBody) {
            int j = 0;
            int score = 0;
            InvestingDTO investing = new InvestingDTO();
            for (Element td : element.select("td")) {
                if(!td.select(".flag").isEmpty()){
                    continue;
                } else if (!td.select(".left a").isEmpty()){
                    investing.setStock(td.select(".left a").text());
                } else if (j < 8) {
                    switch (j) {
                        case 1:
                            score += getScore(td.text()) * 28 * 6.5; // 시간당
                            break;
                        case 2:
                            score += getScore(td.text()) * 28; // 일간
                            break;
                        case 3:
                            score += getScore(td.text()) * 4; // 주간
                            break;
                        case 4:
                            score += getScore(td.text()) * 1; // 월간
                            break;
                    }
                }
                j++;
            }

            investing = investings.get(investing.getStock());
            investing.setScore(score);
            investings.put(investing.getStock(), investing);
        }
        return investings;
    }

    static int getScore(String str) {
        switch (str) {
            case "적극 매수":
                return 5;
            case "매수":
                return 4;
            case "중립":
                return 3;
            case "매도":
                return 2;
            case "적극 매도":
                return 1;
            default:
                return 0;
        }
    }
}
