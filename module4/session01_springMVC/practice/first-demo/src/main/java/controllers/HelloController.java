package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public String getHelloPage(){
        return "hello";
    }

    @GetMapping(value = "/hello1")
    public String getHelloPage1(Model model){
        model.addAttribute("name", "Hoang Kim Van Chuong");
        return "hello";
    }

    @GetMapping(value = "/hello2")
    public String getHelloPage2(ModelMap modelMap){
        modelMap.addAttribute("name", "Hoang Kim Van Chuong");
        modelMap.addAttribute("address", "Quang Tri");
        modelMap.addAttribute("email", "chuonghoang@gmail.com");
        return "hello";
    }

    @GetMapping(value = "/hello3")
    public ModelAndView getHelloPage3(){
        ModelAndView modelAndView = new ModelAndView("hello_3");
        modelAndView.addObject("name", "Chuong Hoang");
        modelAndView.addObject("age", "32");
        modelAndView.addObject("gender", "male");
        modelAndView.addObject("appreance", "handsome");
        return modelAndView;
    }

    @GetMapping(value = "/hello4")
    public ModelAndView getHelloPage4(){
        return new ModelAndView("hello_model_and_view",
                "student", new Student("Chuong", "32", "Quang Tri"));
    }

    @GetMapping(value = "/hello5")
    public ModelAndView getHelloPage5(){
        List<Student> eList = new ArrayList<>();
        eList.add(new Student("Chuong", "32", "Quang Tri"));
        eList.add(new Student("Quang", "27", "Da Nang"));
        eList.add(new Student("Nhat", "22", "Quang Tri"));
        return new ModelAndView("hello_list", "eList", eList );
    }
}
