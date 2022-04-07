package com.example.web.controller.db;

import com.example.web.crawling.InvestingCrawling;
import com.example.web.dao.InvestingDAO;
import com.example.web.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestingCtrl {
    @Autowired
    private InvestingDAO investingDAO;

    @Autowired
    HistoryDbCtrl history;

    public boolean insert() {
        try {
            boolean result = investingDAO.insertInvesting(InvestingCrawling.getInvestings()) == 1;
            //System.out.println(Util.getTodayString() + ": investing insert success");
            return result;
        } catch (Exception e) {
            System.out.println("-----------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------");

            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setName("investing insert fail");
            historyDTO.setReason(e.getMessage());
            history.insert(historyDTO);

            return false;
        }

    }
}
