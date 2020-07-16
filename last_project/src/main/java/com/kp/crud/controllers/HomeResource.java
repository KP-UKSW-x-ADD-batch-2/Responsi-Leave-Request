package com.kp.crud.controllers;

import com.kp.crud.entities.Employee;
import com.kp.crud.entities.History;
import com.kp.crud.entities.Request;
import com.kp.crud.services.EmployeeService;
import com.kp.crud.services.HistoryService;
import com.kp.crud.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    
    @Autowired
    RequestService requestService;
    
    @Autowired
    HistoryService historyService;
    
    @Autowired
    EmployeeService employeeService;
    
    
//    @RequestMapping("/")
//    public String home(Model model) {
//        model.addAttribute("request", new Request());
//        model.addAttribute("requests", requestService.getAll());
//        model.addAttribute("history", new History());
//        model.addAttribute("histories", historyService.showHistory());
//        model.addAttribute("employee", new Employee());
//        model.addAttribute("employees", employeeService.employeeLeaveView());
//        return ("index");
//    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
