package vn.codegym.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.springsecurity.model.Account;
import vn.codegym.springsecurity.service.AccountService;

@Controller
public class MainController {
    @Autowired
    AccountService accountService;

    @GetMapping({"/", "/home"})
    public String getHomePage(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        accountService.save(new Account("hai", password, "USER", true));
        accountService.save(new Account("tra", password, "CREATOR", true));
        return "home";
    }

    @GetMapping("/hello")
    public String getHelloPage(){
        return "hello";
    }

}
