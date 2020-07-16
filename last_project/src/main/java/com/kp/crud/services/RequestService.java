/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.services;

import com.kp.crud.entities.Request;
import com.kp.crud.repositories.RequestRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yosef Febrianes
 */
@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository;
    
    public List<Request> getAll(){
        return requestRepository.findAll();
    }
    
    public Optional<Request> findbyId(String id){
        return requestRepository.findById(id);
    }
    
    public Request save(Request request){
        return requestRepository.save(request);
    }
    
    public List<Request> managerShowRequest(){
        return requestRepository.managerViewRequest();
    }
    
    public Request updateStatus(Request request){
        return requestRepository.save(request);
    }
    
//    public List<Request> updateRequestManager(){
//        return requestRepository.managerUpdateRequest();
//    }
}
