package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Email;

@Controller
@RequestMapping("/email")
public class EmailController {

    @GetMapping
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("el", new Email());
        modelAndView.addObject("languageArray", new String[]{"Eng", "Viet", "US", "UK", "China"});
        modelAndView.addObject("pageSizeArray", new String[]{"5", "10", "25", "50", "100"});
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getInfoPage(@ModelAttribute Email email){
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("el", email);
        modelAndView.addObject("languageArray", new String[]{"Eng", "Viet", "US", "UK", "China"});
        modelAndView.addObject("pageSizeArray", new String[]{"5", "10", "25", "50", "100"});
        return modelAndView;
    }
}
