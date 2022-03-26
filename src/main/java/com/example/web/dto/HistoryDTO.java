package com.example.web.dto;

public class HistoryDTO {
    // 시간
    String date;
    // 종목명
    String name;
    // 사유
    String reason;

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }
}
