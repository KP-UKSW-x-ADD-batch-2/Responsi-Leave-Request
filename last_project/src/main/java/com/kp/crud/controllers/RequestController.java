/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Employee;
import com.kp.crud.entities.Report;
import com.kp.crud.entities.Request;
import com.kp.crud.services.EmployeeService;
import com.kp.crud.services.ReportService;
import com.kp.crud.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yosef Febrianes
 */
@Controller
public class RequestController {
    @Autowired
    RequestService requestService;
    
    @RequestMapping("request")
    public String requestView(Model model){
        model.addAttribute("request", new Request());
        model.addAttribute("requests", requestService.getAll());
        return "request";
    }
    
    @PostMapping("save")
    public String saveRequest(@Validated Request request){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
//        request.setCurrentStatus(new Status("S003"));
        requestService.save(request);
        return "redirect:/";
    }
    
}
