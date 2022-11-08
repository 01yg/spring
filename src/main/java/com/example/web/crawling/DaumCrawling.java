package com.example.web.crawling;

import com.example.web.controller.api.KrxApi;
import com.example.web.dto.InvestingDTO;
import com.example.web.util.Util;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class DaumCrawling {
    // 기업개요
    public static HashMap getDaumC1020001(String isuName) throws Exception {
        System.out.println("isuName : " + isuName);
        String isuCode = KrxApi.isu.get(isuName);
        System.out.println("isuCode : " + isuCode);
        //String isuCode = "005930";
        final String stockList = "https://wisefn.finance.daum.net/v1/company/c1020001.aspx?cmp_cd=" + isuCode;

        try {
            Connection conn = Jsoup.connect(stockList)
                    .header("x-requested-with", "XMLHttpRequest")
                    .method(Connection.Method.GET);
            Document document = conn.get();

            HashMap<String, HashMap> map = new HashMap<>();
            map.put("summary", getSummary(document));
            map.put("history", getHistory(document));

            return map;

            //return getItem(document);
            //HashMap<String, InvestingDTO> investings = getStockList(document);   // 데이터 리스트
            //System.out.println(Util.getTodayString() + ": investing crawling success");
            //return investings;
        } catch (IOException ignored) {
            System.out.println(Util.getTodayString() + ": investing crawling fail");
            throw ignored;
        }
    }

    // 세부 기업 개요
    public static HashMap<String, String> getSummary(Document document) {
        Elements tr = document.select("table#cTB201 tbody > tr");

        HashMap<String, String> hashMap = new HashMap();
        // 본사주소, 홈페이지, 대표전화, 설립일, 대표이사, 계열, 종업원수, 발행주식수, 감사인, 명의개서, 주거래은행
        String tdTitle[] = {"address", "website", "phone", "establishmentDate", "ceo", "affiliate", "employees", "issued", "auditor", "transfer", "bank"};
        int index = 0;
        for (Element element : tr) {
            for (Element td : element.select("td")) {
                hashMap.put(tdTitle[index++], td.text());
            }
        }
        return hashMap;
    }

    // 최근연혁
    public static HashMap<String, String> getHistory(Document document) {
        Elements tr = document.select("table#cTB202 tbody > tr");

        HashMap<String, String> hashMap = new HashMap();
        // 본사주소, 홈페이지, 대표전화, 설립일, 대표이사, 계열, 종업원수, 발행주식수, 감사인, 명의개서, 주거래은행
        String tdTitle[] = {"address", "website", "phone", "establishmentDate", "ceo", "affiliate", "employees", "issued", "auditor", "transfer", "bank"};
        int index = 0;
        for (Element element : tr) {
            Element th = element.select("th").first();
            Element td = element.select("td").first();
            hashMap.put(th.text(), td.text());
        }
        return hashMap;
    }

    // 다음 투자의견 컨센서스 가져오기 위함
    public static HashMap<String, String> getDaumC1010001(String isuName) throws Exception {
        String isuCode = KrxApi.isu.get(isuName);
        final String stockList = "http://wisefn.finance.daum.net/v1/company/c1010001.aspx?cmp_cd=" + isuCode;

        try {
            Connection conn = Jsoup.connect(stockList)
                    .header("x-requested-with", "XMLHttpRequest")
                    .method(Connection.Method.GET);
            Document document = conn.get();
            return getItem(document);
            //HashMap<String, InvestingDTO> investings = getStockList(document);   // 데이터 리스트
            //System.out.println(Util.getTodayString() + ": investing crawling success");
            //return investings;
        } catch (IOException ignored) {
            System.out.println(Util.getTodayString() + ": investing crawling fail");
            throw ignored;
        }
    }

    public static HashMap<String, String> getItem(Document document) {
        Elements tr = document.select("table#cTB15 tbody > tr:nth-child(2):not(.txt)");

        HashMap<String, String> hashMap = new HashMap();
        String tdTitle[] = {"investmentOpinion","targetPrice","eps","per", "estimatedNumberOfOrgans"};
        for (Element element : tr) {
            int index = 0;
            for (Element td : element.select("td")) {
                hashMap.put(tdTitle[index++], td.text());
            }
        }
        return hashMap;
    }
}
