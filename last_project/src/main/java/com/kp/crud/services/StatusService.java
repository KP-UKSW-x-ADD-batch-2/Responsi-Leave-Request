/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.services;

import com.kp.crud.entities.Status;
import com.kp.crud.repositories.StatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dhanuaji Pratama
 */
@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;
    
    public List<Status> getAll(){
        return statusRepository.findAll();
    }
    
    public Status save(Status status){
        return statusRepository.save(status);
    }
}
