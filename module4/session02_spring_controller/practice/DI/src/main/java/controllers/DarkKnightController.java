package controllers;

import model.DarkKnight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DarkKnightController {
    @Autowired
    DarkKnight darkKnight1;
    @Autowired
    DarkKnight darkKnight2;
    @Autowired
    DarkKnight darkKnight3;

    @GetMapping("/darkKnight")
    public String getDarkKnightPage(Model model){
        String result1 = darkKnight1.operate();
        String result2 = darkKnight2.operate();
        String result3 = darkKnight3.operate();
        model.addAttribute("result1", result1);
        model.addAttribute("result2", result2);
        model.addAttribute("result3", result3);
        return "/dark_knight";
    }
}
