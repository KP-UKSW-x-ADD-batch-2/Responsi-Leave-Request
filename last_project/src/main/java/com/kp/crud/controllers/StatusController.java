/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Status;
import com.kp.crud.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dhanuaji Pratama
 */
@Controller
public class StatusController {
    @Autowired
    StatusService statusService;
    
    @RequestMapping("status")
    public String showStatus(Model model){
        model.addAttribute("status", new Status());
        model.addAttribute("stats", statusService.getAll());
        return "status";
    }
    
//    @PostMapping("save")
//    public String saveRequest(@Validated Status status){
////        request.setCurrentStatus(new Status("S003"));
//        statusService.save(status);
//        return "redirect:/";
//    }
}
