package com.example.web.controller.db;

import com.example.web.dao.StockDAO;
import com.example.web.dto.StockDTO;
import com.example.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StockDbCtrl {
    @Autowired
    private StockDAO stockDAO;

    public boolean insert(ArrayList<StockDTO> stocks) {
        // 성공 유무
        System.out.println(new Util().getTodayString() + "stockDAO.insertStock(stocks)");
        return stockDAO.insertStock(stocks) == 1;
    }
}