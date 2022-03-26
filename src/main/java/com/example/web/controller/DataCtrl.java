package com.example.web.controller;

import com.example.web.controller.api.DaumApi;
import com.example.web.controller.db.StockDbCtrl;
import com.example.web.dto.HistoryDTO;
import com.example.web.dto.StockDTO;
import com.example.web.util.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataCtrl {
    @Autowired
    DaumApi daum;

    @Autowired
    StockDbCtrl stock;

    // 재귀 호출 상세 주식정보 재귀호출
    public void recursionQuotes() {
        ArrayList<StockDTO> stocks = new ArrayList<>();

        if(DaumApi.includedStocks != null) {
            for (int i = 0; i < DaumApi.includedStocks.length(); i++) {
                JSONObject included = DaumApi.includedStocks.getJSONObject(i);
                JSONObject quotes = daum.setQuotes(included);

                stocks.add(toStockDTO(quotes));
            }

            if(stock.insert(stocks)) {
                HistoryDTO historyDTO = new HistoryDTO();
                historyDTO.setDate(Util.getTodayString());
                historyDTO.setName(daum.includedName);
                historyDTO.setReason("setQuotes : api 호출 실패");
            }
        }
    }

    public static StockDTO toStockDTO(JSONObject jsonObject){
        StockDTO stockDTO = new StockDTO();
        stockDTO.setCurrentTime(jsonObject.getString("currentTime"));
        stockDTO.setSymbolCode(jsonObject.getString("symbolCode"));
        stockDTO.setCode(jsonObject.getString("code"));
        stockDTO.setOpeningPrice(jsonObject.getInt("openingPrice"));
        stockDTO.setHighPrice(jsonObject.getInt("highPrice"));
        stockDTO.setLowPrice(jsonObject.getInt("lowPrice"));
        stockDTO.setTradePrice(jsonObject.getInt("tradePrice"));
        stockDTO.setPrevClosingPrice(jsonObject.getInt("prevClosingPrice"));
        stockDTO.setChange(jsonObject.getString("change"));
        stockDTO.setChangePrice(jsonObject.getInt("changePrice"));
        stockDTO.setChangeRate(jsonObject.getInt("changeRate"));
        stockDTO.setName(jsonObject.getString("name"));
        stockDTO.setDate(jsonObject.getString("date"));
        stockDTO.setTradeDate(jsonObject.getString("tradeDate"));
        stockDTO.setExchangeDate(jsonObject.getString("exchangeDate"));
        stockDTO.setMarket(jsonObject.getString("market"));
        stockDTO.setAccTradeVolume(jsonObject.getInt("accTradePrice"));
        stockDTO.setAccTradeVolume(jsonObject.getInt("accTradeVolume"));
        stockDTO.setPrevAccTradeVolume(jsonObject.getInt("prevAccTradeVolume"));
        stockDTO.setPrevAccTradeVolumeChangeRate(String.valueOf(jsonObject.get("prevAccTradeVolumeChangeRate")));
        stockDTO.setMarketCap(jsonObject.getInt("marketCap"));
        stockDTO.setHigh52wPrice(jsonObject.getInt("high52wPrice"));
        stockDTO.setHigh52wDate(jsonObject.getString("high52wDate"));
        stockDTO.setLow52wPrice(jsonObject.getInt("low52wPrice"));
        stockDTO.setLow52wDate(jsonObject.getString("low52wDate"));
        stockDTO.setUpperLimitPrice(jsonObject.getInt("upperLimitPrice"));
        stockDTO.setLowerLimitPrice(jsonObject.getInt("lowerLimitPrice"));
        stockDTO.setForeignRatio(jsonObject.getInt("foreignRatio"));
        stockDTO.setParValue(jsonObject.getInt("parValue"));
        stockDTO.setEps(jsonObject.getInt("eps"));
        stockDTO.setDps(jsonObject.getInt("dps"));
        stockDTO.setPer(jsonObject.getInt("per"));
        stockDTO.setBps(jsonObject.getInt("bps"));
        stockDTO.setPbr(jsonObject.getInt("pbr"));
        stockDTO.setSectorName(jsonObject.getString("sectorName"));
        stockDTO.setWicsSectorName(jsonObject.getString("wicsSectorName"));
        stockDTO.setWicsSectorChangeRate(jsonObject.getInt("wicsSectorChangeRate"));
        stockDTO.setListedShareCount(jsonObject.getInt("listedShareCount"));
        stockDTO.setSectorPer(jsonObject.getInt("sectorPer"));
        stockDTO.setHighInYearPrice(jsonObject.getInt("highInYearPrice"));
        stockDTO.setLowInYearPrice(jsonObject.getInt("lowInYearPrice"));
        stockDTO.setCapitalStock(jsonObject.getInt("capitalStock"));
        stockDTO.setBidPrice(jsonObject.getInt("bidPrice"));
        stockDTO.setAskPrice(jsonObject.getInt("askPrice"));

        return stockDTO;
    }
}
