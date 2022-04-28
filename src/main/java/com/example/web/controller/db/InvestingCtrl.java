package com.example.web.controller.db;

import com.example.web.crawling.InvestingCrawling;
import com.example.web.dao.InvestingDAO;
import com.example.web.dto.HistoryDTO;
import com.example.web.dto.InvestingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.web.util.Util.getOpeningInt;

@Service
public class InvestingCtrl {
    @Autowired
    private InvestingDAO investingDAO;

    @Autowired
    HistoryDbCtrl history;

    public HashMap<String, InvestingDTO>  getInvestings() {
        HashMap<String, InvestingDTO> investingDtos;

        try {
            investingDtos = InvestingCrawling.getInvestings();
        } catch (Exception e) {
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setName("investing crawling fail");
            historyDTO.setReason(e.getMessage());
            history.insert(historyDTO);

            return null;
        }

        return investingDtos;

        //try {
        //    int result = investingDAO.insertInvesting(investingDtos);
        //    return result != 0;
        //} catch (Exception e) {
        //    HistoryDTO historyDTO = new HistoryDTO();
        //    historyDTO.setName("investing insert fail");
        //    historyDTO.setReason(e.getMessage());
        //    history.insert(historyDTO);

        //    return false;
        //}
    }

    public HashMap<String, InvestingDTO> insertTechnical(HashMap<String, InvestingDTO> investings) {
        HashMap<String, InvestingDTO> investingDtos;
        try {
            investingDtos = InvestingCrawling.getInvestingsTechnical(investings);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setName("investing technical crawling fail");
            historyDTO.setReason(e.getMessage());
            history.insert(historyDTO);

            return null;
        }

        return investingDtos;

        //try {
        //    int result = investingDAO.updateInvestingTechnical(investingDtos);
        //    return result != 0;
        //} catch (Exception e) {
        //    System.out.println(e.getMessage());

        //    HistoryDTO historyDTO = new HistoryDTO();
        //    historyDTO.setName("investing technical insert fail");
        //    historyDTO.setReason(e.getMessage());
        //    history.insert(historyDTO);

        //    return false;
        //}
    }

    public List<InvestingDTO> select() {
        try {
            return investingDAO.select();
        } catch (Exception e) {
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setName("investing select fail");
            historyDTO.setReason(e.getMessage());
            history.insert(historyDTO);

            return null;
        }
    }

    // 하루전 데이터 넣기
    public boolean updateDataTheDayBefore(HashMap<String, InvestingDTO> investings) {
        try {
            int result = investingDAO.updateDataTheDayBefore(getOpeningInt());
            return result != 0;
        } catch (Exception e) {
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setName("investing day before update fail");
            historyDTO.setReason(e.getMessage());
            history.insert(historyDTO);

            return false;
        }
    }
}