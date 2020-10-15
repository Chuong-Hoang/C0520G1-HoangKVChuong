package vn.codegym.furama.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Transactional
public class LoginController {

    @GetMapping("/")
    public String index(){
        return "login/page_login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "home/index";
    }

    @GetMapping("/403")
    public String accessDenied(){
        return "login/403";
    }

    @GetMapping(value = "/login")
    public String getLogin(){
        return "login/page_login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
