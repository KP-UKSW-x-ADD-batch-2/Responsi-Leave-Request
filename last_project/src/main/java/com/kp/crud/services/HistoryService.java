/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.services;

import com.kp.crud.entities.History;
import com.kp.crud.repositories.HistoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dhanuaji Pratama
 */
@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;
    
    public List<History> showHistory(){
        return historyRepository.historyView();
    }
    
//    public List<History> managerShowHistory(){
//        return historyRepository.managerViewHistory();
//    }
}
