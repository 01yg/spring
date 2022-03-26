package com.example.web.dao;

import com.example.web.dto.StockDTO;

import java.util.ArrayList;

public interface StockDAO {
    void createStock();
    //List<StockDTO> selectStock();
    int insertStock(ArrayList<StockDTO> stocks);
}
