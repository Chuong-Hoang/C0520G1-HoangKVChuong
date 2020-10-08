package vn.codegym.springsecurity.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.springsecurity.model.Account;
import vn.codegym.springsecurity.repository.AccountRepository;
import vn.codegym.springsecurity.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
