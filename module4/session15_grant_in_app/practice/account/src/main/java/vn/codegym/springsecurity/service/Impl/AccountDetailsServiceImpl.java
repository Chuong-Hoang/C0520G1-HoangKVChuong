package vn.codegym.springsecurity.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.springsecurity.model.Account;
import vn.codegym.springsecurity.model.MyAccountDetails;
import vn.codegym.springsecurity.repository.AccountRepository;

@Service
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        if(account == null){
            throw new UsernameNotFoundException("Account not found");
        }
        return new MyAccountDetails(account);
    }
}
