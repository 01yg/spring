package com.example.web.controller.db;

import com.example.web.crawling.InvestingCrawling;
import com.example.web.dao.InvestingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestingCtrl {
    @Autowired
    private InvestingDAO investingDAO;

    public boolean insert() {
        return investingDAO.insertInvesting(InvestingCrawling.getInvestings()) == 1;
    }
}
