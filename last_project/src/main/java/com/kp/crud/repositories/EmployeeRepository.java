/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.repositories;

import com.kp.crud.entities.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dhanuaji Pratama
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
    @Query(value = "SELECT `id`, `name`, `email`, `phone_number`, `leave_quota`, "
            + "`manager`, `is_deleted` FROM `employee` WHERE `is_deleted`= \"0\"", nativeQuery = true)
    public List<Employee> employeenotleave();
    
    @Query(value = "SELECT `id`, `name`, `email`, `phone_number`, `leave_quota`, "
            + "`manager`, `is_deleted` FROM `employee` WHERE `is_deleted`= \"1\"", nativeQuery = true)
    public List<Employee> employeeleave();
}
