/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kp.crud.repositories;

import com.kp.crud.entities.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Dhanuaji Pratama
 */
public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account> findByUsername(String username);

//    @Modifying
    @Query
        (value = "SELECT account.username, account.password, role.name "
                + "FROM account "
                + "JOIN account_role ON account.id = account_role.account "
                + "JOIN role ON account_role.role = role.id "
                + "where account.username = :username ", nativeQuery = true)
    
    public List<Account> login(String username);
//    public List<Account> login(@Param("username") String username);

}
