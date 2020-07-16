/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.repositories;

import com.kp.crud.entities.History;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dhanuaji Pratama
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, String>{
    @Query(value = "SELECT * FROM History", nativeQuery = true)
    public List<History> historyView();
    
//    @Query(value = "")
//    public List<History> managerViewHistory(); 
}
