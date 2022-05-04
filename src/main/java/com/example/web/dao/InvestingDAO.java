package com.example.web.dao;

import com.example.web.dto.InvestingDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface InvestingDAO {
    int insertInvesting(HashMap<String, InvestingDTO> investings);
    int updateInvestingTechnical(ArrayList<InvestingDTO> investings);
    int updateDataTheDayBefore(int i);
    List<InvestingDTO> select();
}
