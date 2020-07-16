/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.services;

import com.kp.crud.entities.Employee;
import com.kp.crud.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dhanuaji Pratama
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<Employee> employeeNotLeaveView(){
        return employeeRepository.employeenotleave();
    }
    
    public List<Employee> employeeLeaveView(){
        return employeeRepository.employeeleave();
    }
    
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    
    public Employee save(Employee employees){
        return employeeRepository.save(employees);
    }
}
