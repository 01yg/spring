package com.example.web.http;

import com.example.web.controller.api.DaumApi;
import com.example.web.util.Util;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KrxHttp {
    public static JSONObject get() {
        try {
            String parameter =  String.format(
                "bld=%s&" +
                "locale=%s&" +
                "mktId=%s&" +
                "share=%s&" +
                "csvxls_isNo=%s&",
                URLEncoder.encode("dbms/MDC/STAT/standard/MDCSTAT01901"),
                URLEncoder.encode("ko_KR"),
                URLEncoder.encode("ALL"),
                URLEncoder.encode("1"),
                URLEncoder.encode("false")
            );

            URL url = new URL("http://data.krx.co.kr/comm/bldAttendant/getJsonData.cmd" + "?" + parameter);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
            con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

            con.addRequestProperty("bld", "dbms/MDC/STAT/standard/MDCSTAT01901"); //key값 설정
            con.addRequestProperty("locale", "ko_KR"); //key값 설정
            con.addRequestProperty("mktId", "ALL"); //key값 설정
            con.addRequestProperty("share", "1"); //key값 설정
            con.addRequestProperty("csvxls_isNo", "false"); //key값 설정

            con.setRequestMethod("GET");
            con.setDoOutput(true);

            Map<String, List<String>> map = con.getHeaderFields();

            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
            }

            StringBuilder sb = new StringBuilder();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //Stream을 처리해줘야 하는 귀찮음이 있음.
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();

                JSONObject jObject = new JSONObject(sb.toString());
                System.out.println(Util.getTodayString() + " : CallApi : api ok");

                return jObject;
            } else {
                System.out.println(con.getResponseMessage());
                System.out.println(con.getResponseCode());
                System.out.println("api not ok");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("api call exception");
            return null;
        }
    }
}