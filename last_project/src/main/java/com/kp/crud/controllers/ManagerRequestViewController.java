/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Request;
import com.kp.crud.services.RequestService;
import java.util.Optional;
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
public class ManagerRequestViewController {
    @Autowired
    RequestService requestService;
    
    @RequestMapping("managerview")
    public String managerView(Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("showall", requestService.getAll());
        model.addAttribute("requests", requestService.managerShowRequest());
        
        return "managerview";
    }
    
    @PostMapping("update")
    public String updateRequest(@Validated Request request){
        requestService.updateStatus(request);
        return "redirect:/";
    }
}
