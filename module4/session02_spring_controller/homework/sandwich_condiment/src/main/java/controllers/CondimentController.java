package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @PostMapping("/save")
    public String getCondimentListPage(@RequestParam String[] c05, Model model){
        model.addAttribute("c05", c05);
        return "/condiment";
    }
}
