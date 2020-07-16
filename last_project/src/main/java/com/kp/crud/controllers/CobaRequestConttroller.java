/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Request;
import com.kp.crud.entities.Status;
import com.kp.crud.services.RequestService;
import java.text.SimpleDateFormat;
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
public class CobaRequestConttroller {
    @Autowired
    RequestService requestService;
    
    @RequestMapping("cobarequest")
    public String cobareqView(Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("requests", requestService.getAll());
        return "cobarequest";
    }
    
//    @PostMapping("save")
//    public String saveRequest(@Validated Request request){
////        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
////        request.setCurrentStatus(new Status("S003"));
//        requestService.save(request);
//        return "redirect:/";
//    }
}
