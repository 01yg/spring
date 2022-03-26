/*
* http 콜하는 소스 입니다.
* 헤더에 referer 를 넣어 줍니다.
*
* 문자열 데이터를 json object로 변환하여 리턴 합니다.
* */
package com.example.web.http;

import com.example.web.controller.api.DaumApi;
import com.example.web.util.Util;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CallApi {
    public static JSONObject get(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
            con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

            con.addRequestProperty("referer", "https://finance.daum.net/domestic/sectors"); //key값 설정
            con.addRequestProperty("authority", "finance.daum.net"); //key값 설정
            con.addRequestProperty("sec-fetch-mode", "cors"); //key값 설정
            con.addRequestProperty("sec-fetch-site", "same-origin"); //key값 설정
            con.addRequestProperty("x-requested-with", "XMLHttpRequest"); //key값 설정
            con.addRequestProperty("sec-fetch-dest", "empty"); //key값 설정

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
                System.out.println(Util.getTodayString() + " : " + DaumApi.includedName + " : api ok");
                return jObject;
            } else {
                System.out.println(Util.getTodayString() + " : " + DaumApi.includedName + " : api not ok");
                return null;
            }
        } catch (Exception e) {
            System.out.println(Util.getTodayString() + " : " + DaumApi.includedName + " : api call exception");
            return null;
        }
    }

    public static JSONArray gets(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
            con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

            con.addRequestProperty("referer", "https://finance.daum.net/domestic/sectors"); //key값 설정
            con.addRequestProperty("authority", "finance.daum.net"); //key값 설정
            con.addRequestProperty("sec-fetch-mode", "cors"); //key값 설정
            con.addRequestProperty("sec-fetch-site", "same-origin"); //key값 설정
            con.addRequestProperty("x-requested-with", "XMLHttpRequest"); //key값 설정
            con.addRequestProperty("sec-fetch-dest", "empty"); //key값 설정

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

                JSONArray jArray = new JSONArray(sb.toString());

                System.out.println(Util.getTodayString() + " : api ok");
                return jArray;
            } else {
                System.out.println(Util.getTodayString() + " : api not ok");
                return null;
            }
        } catch (Exception e) {
            System.out.println(Util.getTodayString() + " : api call exception");
            return null;
        }
    }
}
