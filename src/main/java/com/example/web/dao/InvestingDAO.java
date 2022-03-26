package com.example.web.dao;

import com.example.web.dto.InvestingDTO;

import java.util.ArrayList;

public interface InvestingDAO {
    int insertInvesting(ArrayList<InvestingDTO> investings);
}
