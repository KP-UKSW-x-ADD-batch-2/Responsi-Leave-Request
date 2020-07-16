/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Request;
import com.kp.crud.services.RequestService;
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
public class managerreqcoba {
    @Autowired
    RequestService requestService;
    
    @RequestMapping("cobareq")
    public String showReq(Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("showreq", requestService.managerShowRequest());
        return "cobareq";
    }
    
    @PostMapping("updatereq")
    public String updatereq(@Validated Request request){
        requestService.findbyId(request.getId());
        request.setReason(request.getReason());
        request.setCurrentStatus(request.getCurrentStatus());
        requestService.save(request);
        return "redirect:/";
    }
}
