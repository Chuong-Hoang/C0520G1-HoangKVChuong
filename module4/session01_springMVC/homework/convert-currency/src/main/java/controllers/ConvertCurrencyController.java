package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ConvertCurrencyController {
    @GetMapping(value = "/form")
    public String getForm() {
        return "form";
    }

    @PostMapping(value = "/form")
    public ModelAndView changeCurrency(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("form");
        int usd = Integer.parseInt(request.getParameter("usd"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        double result = usd * rate;
        modelAndView.addObject("result", result);
        modelAndView.addObject("usd", usd);
        modelAndView.addObject("rate", rate);
        return modelAndView;
    }
}
