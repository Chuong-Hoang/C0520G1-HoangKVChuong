package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping
    public String getCalculatorScreen(Model model){
        model.addAttribute("equal", "calculate");
        return "/index";
    }

    @PostMapping("/calculate")
    public String getResultPage(@RequestParam String num1, String num2, String operator, Model model){
        if(num1 == "") {
            num1 = "0";
        }
        if(num2 == "") {
            num2 = "0";
        }
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        double result = 0;
        String msg = "";

        switch (operator){
            case "+":
                result = (number1 + number2);
                break;
            case "-":
                result = (number1 - number2);
                break;
            case "*":
                result = (number1 * number2);
                break;
            case "/":
                if(number2 == 0) {
                    msg = "Cannot divide by zero";
                } else {
                    result = (number1 / number2);
                }
            default: break;
        }

        model.addAttribute("num1", number1);
        model.addAttribute("num2", number2);
        model.addAttribute("result", result);
        model.addAttribute("operator", operator);
        model.addAttribute("msg", msg);
        model.addAttribute("equal", " = ");
        return "/index";
    }
}
