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

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class naverCrawling {
    public static void getStockPriceList() {
        final String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Connection conn = Jsoup.connect(stockList);

        try {
            Document document = conn.get();
            String thead = getStockHeader(document); // 칼럼명
            String tbody = getStockList(document);   // 데이터 리스트
        } catch (IOException ignored) {
        }
    }

    public static String getStockHeader(Document document) {
        Elements stockTableBody = document.select("table.type_2 thead tr");
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

    public static String getStockList(Document document) {
        Elements stockTableBody = document.select("table.type_2 tbody tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            if (element.attr("onmouseover").isEmpty()) {
                continue;
            }

            for (Element td : element.select("td")) {
                String text;
                if(td.select(".center a").attr("href").isEmpty()){
                    text = td.text();
                }else{
                    text = "https://finance.naver.com"+td.select(".center a").attr("href");
                }
                sb.append(text);
                sb.append("   ");
            }
            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }
}
