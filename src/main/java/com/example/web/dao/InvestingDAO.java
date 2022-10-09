package com.example.web.dao;

import com.example.web.dto.InvestingDTO;

import java.util.List;
import java.util.Map;

public interface InvestingDAO {
    int insertInvesting(Map<String,Object> map);
    void createInvesting(String value);
    int updateDataTheDayBefore(int i);
    List<InvestingDTO> select();
}
