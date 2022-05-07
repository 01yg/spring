package com.example.web.dao;

import com.example.web.dto.HistoryDTO;
import com.example.web.dto.IsuDTO;

import java.util.ArrayList;

public interface IsuDAO {
    void deleteIsu();
    void insertIsu(ArrayList<IsuDTO> isuDTO);
}
