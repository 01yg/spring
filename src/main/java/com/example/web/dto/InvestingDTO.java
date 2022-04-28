package com.example.web.dto;

public class InvestingDTO {
    String stock;
    int current;
    int high;
    int low;
    int changePrice;
    float changeRate;
    double tradingVolume;
    String tradeTime;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setChangePrice(int changePrice) {
        this.changePrice = changePrice;
    }

    public void setChangeRate(float changeRate) {
        this.changeRate = changeRate;
    }

    public void setTradingVolume(double tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getStock() {
        return stock;
    }

    public int getCurrent() {
        return current;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public int getChangePrice() {
        return changePrice;
    }

    public float getChangeRate() {
        return changeRate;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public String getTradeTime() {
        return tradeTime;
    }
}