package com.kp.crud;

import com.kp.crud.entities.Account;
import com.kp.crud.entities.MyUserDetails;
import com.kp.crud.repositories.AccountRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyLoginDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(username);
        account.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return account.map(MyUserDetails::new).get();
    }

}
