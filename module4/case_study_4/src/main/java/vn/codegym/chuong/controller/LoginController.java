package vn.codegym.chuong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.transaction.annotation.Transactional;

@Controller
@Transactional
public class LoginController {

    // home page
    @GetMapping(value = {"/","/home"})
    public String getHomePage(){
        return "home/index";
    }

    // login page
    @GetMapping(value = "/login")
    public String getLogin(){
        return "login/page_login";
    }

    // error page
    @GetMapping("/403")
    public String accessDenied(){
        return "login/403";
    }
}
