/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.History;
import com.kp.crud.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dhanuaji Pratama
 */
@Controller
public class HistoryController {
    @Autowired
    HistoryService historyService;
    
    @RequestMapping("history")
    public String viewHistory(Model model){
        model.addAttribute("history", new History());
        model.addAttribute("histories", historyService.showHistory());
        return "history";
    }
}
