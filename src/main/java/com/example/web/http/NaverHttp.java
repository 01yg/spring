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

public class NaverHttp {
    public static JSONObject get(String strUrl) {
        try {
            HttpURLConnection con = getCon(strUrl);
            StringBuilder sb = getSb(con);

            JSONObject jObject = new JSONObject(sb.toString());
            return jObject;
        } catch (Exception e) {
            System.out.println(Util.getTodayString() + " : " + DaumApi.includedName + " : api call exception");
            return null;
        }
    }

    public static JSONArray gets(String strUrl) {
        try {
            HttpURLConnection con = getCon(strUrl);
            StringBuilder sb = getSb(con);

            JSONArray jArray = new JSONArray(sb.toString());
            return jArray;
        } catch (Exception e) {
            System.out.println(Util.getTodayString() + " : " + DaumApi.includedName + " : api call exception");
            return null;
        }
    }

    public static StringBuilder getSb(HttpURLConnection con) throws Exception {
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

            System.out.println(Util.getTodayString() + " : api ok");
            return sb;
        } else {
            System.out.println(Util.getTodayString() + " : api not ok");
            return null;
        }
    }

    public static HttpURLConnection getCon(String strUrl) throws Exception {
        URL url = new URL(strUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
        con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

        con.setRequestMethod("GET");
        con.setDoOutput(true);

        return con;
    }
}
