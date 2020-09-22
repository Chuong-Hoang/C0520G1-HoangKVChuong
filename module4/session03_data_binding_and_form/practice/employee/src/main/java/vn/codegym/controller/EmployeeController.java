package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/create")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("el", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView showInfo(@ModelAttribute Employee el){
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("el", el);
        return modelAndView;
    }


}
