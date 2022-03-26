package com.example.web.controller.db;

import com.example.web.dao.HistoryDAO;
import com.example.web.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryDbCtrl {
    @Autowired
    private HistoryDAO historyDAO;

    public boolean insert(HistoryDTO historyDTO) {
        /*
        * <Insert>
   - 성공 : 1 (여러개일경우도 1)
   - 실패 : 에러

<Update>
   - 성공 : Update된 행의 개수 반환 (없다면 0)
   - 실패 : 0

<delete>
   - 성공 : Delete된 행의개수 (없다면 0)
   - 실패 : 에러
        * */
        return(historyDAO.insertHistory(historyDTO) == 1);
    }
}
