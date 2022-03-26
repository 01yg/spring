package com.example.web.dao;

import com.example.web.dto.HistoryDTO;

public interface HistoryDAO {
    void createHistory();
    int insertHistory(HistoryDTO historyDTO);
    //HistoryDAO selecteHistory();
}
