/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.controllers;

import com.kp.crud.entities.Account;
import com.kp.crud.entities.Role;
import com.kp.crud.repositories.AccountRepository;
import com.kp.crud.repositories.RoleRepository;
import com.kp.crud.services.AccountService;
import com.kp.crud.services.RoleService;
import com.kp.crud.tools.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yosef Febrianes
 */
@Controller
public class LoginController {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository repository;

    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, String username, String password) {
        System.out.println("LOGIN ON");
//        model.addAttribute("login", accountService.login(username));
//        accountService.getByUsername("username", "password");

//        if (accountService != null && BCrypt.checkpw(password, password)) {
//            return "dashboard";
//        } else {
        return "login";
    }
//    }

    @GetMapping("/logout")
    public String logout(Model model, String username, String password) {
        System.out.println("LOGOUT ON");
        return "login";
    }

}
