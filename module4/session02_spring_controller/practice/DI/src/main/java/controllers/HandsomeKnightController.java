package controllers;

import model.HandsomeKnight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandsomeKnightController {
    @Autowired
    HandsomeKnight handsomeKnight1;
    @Autowired
    HandsomeKnight handsomeKnight2;
    @Autowired
    HandsomeKnight handsomeKnight3;

    @GetMapping("/handsomeKnight")
    public String getHandsomeKnightPage(Model model){
        String result1 = handsomeKnight1.operate();
        String result2 = handsomeKnight2.operate();
        String result3 = handsomeKnight3.operate();
        model.addAttribute("result1", result1);
        model.addAttribute("result2", result2);
        model.addAttribute("result3", result3);
        return "/handsome_knight";
    }
}
