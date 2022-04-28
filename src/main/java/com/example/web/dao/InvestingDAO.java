package com.example.web.dao;

import com.example.web.dto.InvestingDTO;

import java.util.ArrayList;
import java.util.List;

public interface InvestingDAO {
    int insertInvesting(ArrayList<InvestingDTO> investings);
    int updateInvestingTechnical(ArrayList<InvestingDTO> investings);
    int updateDataTheDayBefore(int i);
    List<InvestingDTO> select();
}
