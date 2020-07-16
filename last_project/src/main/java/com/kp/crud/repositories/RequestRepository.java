/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.repositories;

import com.kp.crud.entities.Request;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yosef Febrianes
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, String>{
    @Query(value = "SELECT * FROM `request` WHERE `current_status` =  \"S003\"", nativeQuery = true)
    public List<Request> managerViewRequest();
    
//    @Modifying
//    @Query(value = "UPDATE `request` SET `current_status`= \"S001\" WHERE `current_status` = \"S003\"", nativeQuery = true)
//    public List<Request> managerUpdateRequest();
}
//`id`, `requester`, `type`, `total`, `start`, `end`, "
//            + "`reason` FROM `request` WHERE `current_status`=\"S003\"