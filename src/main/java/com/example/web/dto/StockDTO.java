package com.example.web.dto;

public class StockDTO {
    String currentTime;
    String symbolCode; // "A145990", 코드
    String code; // "KR7145990008", 코드
    int openingPrice; // 62500, 시가
    int highPrice; // 63700, 고가
    int lowPrice; // 62200, 저가
    int tradePrice; // 63700, 현재가
    int prevClosingPrice; // 62400, 전일
    String change; // "RISE", 업종
    int changePrice; // 1300, 등락금액
    double changeRate; // 0.0208333333, 등락률?
    String name; // "삼양사", 회사명
    String date; // "2022-02-04", 오늘 날짜
    String tradeDate; // "20220204", 오늘 날짜
    String exchangeDate; // "2022-02-04 18:00:30", 마지막 변화 날?
    String market; // "KOSPI", 시장
    double accTradePrice; // 1624757500, 거래대금
    int accTradeVolume; // 25701, 거래량
    int prevAccTradeVolume; // 12611, 전일 거래량
    String prevAccTradeVolumeChangeRate; // 2.0379827135040838,
    int marketCap; // 656966701300, 시가총액
    double high52wPrice; // 80000.0, 52주 최고
    String high52wDate; // "2021-09-16", 52주 최고 일
    double low52wPrice; // 53900.0, 52주 최저
    String low52wDate; // "2021-02-26", 52주 최저 일
    double upperLimitPrice; // 81100.0, 상한가
    double lowerLimitPrice; // 43700.0, 하한가
    double foreignRatio; // 5.79, 외국인 비율
    double parValue; // 5000.0, 액면가
    int eps; // 5396, EPS
    int dps; // 1250, DPS
    double per; // 11.57, PER
    int bps; // 116622, BPS
    double pbr; // 0.54, PBR
    String sectorName; // "음식료품", 업종
    String wicsSectorName; // "식품", WICS
    double wicsSectorChangeRate; // 0.0273307302, WICS 업종 상승률?
    int listedShareCount; // 10313449, 상장주식수
    double sectorPer; // 11.83352, 업종 PER
    double highInYearPrice; // 64700.0, 연중 최고가
    double lowInYearPrice; // 58000.0, 연중 최저가
    double capitalStock; // 51567245000.0, 자본금
    int bidPrice; // 63600, 매도
    int askPrice; // 63700, 매수

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getSymbolCode() {
        return symbolCode;
    }

    public String getCode() {
        return code;
    }

    public int getOpeningPrice() {
        return openingPrice;
    }

    public int getHighPrice() {
        return highPrice;
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public int getTradePrice() {
        return tradePrice;
    }

    public int getPrevClosingPrice() {
        return prevClosingPrice;
    }

    public String getChange() {
        return change;
    }

    public int getChangePrice() {
        return changePrice;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public String getMarket() {
        return market;
    }

    public double getAccTradePrice() {
        return accTradePrice;
    }

    public int getAccTradeVolume() {
        return accTradeVolume;
    }

    public int getPrevAccTradeVolume() {
        return prevAccTradeVolume;
    }

    public String getPrevAccTradeVolumeChangeRate() {
        return prevAccTradeVolumeChangeRate;
    }

    public int getMarketCap() {
        return marketCap;
    }

    public double getHigh52wPrice() {
        return high52wPrice;
    }

    public String getHigh52wDate() {
        return high52wDate;
    }

    public double getLow52wPrice() {
        return low52wPrice;
    }

    public String getLow52wDate() {
        return low52wDate;
    }

    public double getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public double getLowerLimitPrice() {
        return lowerLimitPrice;
    }

    public double getForeignRatio() {
        return foreignRatio;
    }

    public double getParValue() {
        return parValue;
    }

    public int getEps() {
        return eps;
    }

    public int getDps() {
        return dps;
    }

    public double getPer() {
        return per;
    }

    public int getBps() {
        return bps;
    }

    public double getPbr() {
        return pbr;
    }

    public String getSectorName() {
        return sectorName;
    }

    public String getWicsSectorName() {
        return wicsSectorName;
    }

    public double getWicsSectorChangeRate() {
        return wicsSectorChangeRate;
    }

    public int getListedShareCount() {
        return listedShareCount;
    }

    public double getSectorPer() {
        return sectorPer;
    }

    public double getHighInYearPrice() {
        return highInYearPrice;
    }

    public double getLowInYearPrice() {
        return lowInYearPrice;
    }

    public double getCapitalStock() {
        return capitalStock;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public int getAskPrice() {
        return askPrice;
    }

    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOpeningPrice(int openingPrice) {
        this.openingPrice = openingPrice;
    }

    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setTradePrice(int tradePrice) {
        this.tradePrice = tradePrice;
    }

    public void setPrevClosingPrice(int prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setChangePrice(int changePrice) {
        this.changePrice = changePrice;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setAccTradePrice(double accTradePrice) {
        this.accTradePrice = accTradePrice;
    }

    public void setAccTradeVolume(int accTradeVolume) {
        this.accTradeVolume = accTradeVolume;
    }

    public void setPrevAccTradeVolume(int prevAccTradeVolume) {
        this.prevAccTradeVolume = prevAccTradeVolume;
    }

    public void setPrevAccTradeVolumeChangeRate(String prevAccTradeVolumeChangeRate) {
        this.prevAccTradeVolumeChangeRate = prevAccTradeVolumeChangeRate;
    }

    public void setMarketCap(int marketCap) {
        this.marketCap = marketCap;
    }

    public void setHigh52wPrice(double high52wPrice) {
        this.high52wPrice = high52wPrice;
    }

    public void setHigh52wDate(String high52wDate) {
        this.high52wDate = high52wDate;
    }

    public void setLow52wPrice(double low52wPrice) {
        this.low52wPrice = low52wPrice;
    }

    public void setLow52wDate(String low52wDate) {
        this.low52wDate = low52wDate;
    }

    public void setUpperLimitPrice(double upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public void setLowerLimitPrice(double lowerLimitPrice) {
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public void setForeignRatio(double foreignRatio) {
        this.foreignRatio = foreignRatio;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public void setBps(int bps) {
        this.bps = bps;
    }

    public void setPbr(double pbr) {
        this.pbr = pbr;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public void setWicsSectorName(String wicsSectorName) {
        this.wicsSectorName = wicsSectorName;
    }

    public void setWicsSectorChangeRate(double wicsSectorChangeRate) {
        this.wicsSectorChangeRate = wicsSectorChangeRate;
    }

    public void setListedShareCount(int listedShareCount) {
        this.listedShareCount = listedShareCount;
    }

    public void setSectorPer(double sectorPer) {
        this.sectorPer = sectorPer;
    }

    public void setHighInYearPrice(double highInYearPrice) {
        this.highInYearPrice = highInYearPrice;
    }

    public void setLowInYearPrice(double lowInYearPrice) {
        this.lowInYearPrice = lowInYearPrice;
    }

    public void setCapitalStock(double capitalStock) {
        this.capitalStock = capitalStock;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }
}
