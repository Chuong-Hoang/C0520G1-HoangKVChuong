package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping(value = "/form")
    public String showForm(){
        return "form";
    }

    @PostMapping(value = "/form")
    public ModelAndView translate(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("form");
        Map<String, String> dict = new HashMap<>();
        dict.put("hello", "xin chào");
        dict.put("goodbye", "tạm biệt");
        dict.put("computer", "máy tính");
        dict.put("love", "yêu, tình yêu");
        dict.put("lover", "người yêu, người tình");
        dict.put("taciturn", "trầm mặc");
        dict.put("lamp", "đèn");
        String english = request.getParameter("english");
        String vietnamese = null;
        String msg = null;
        if (dict.containsKey(english)) {
            vietnamese = dict.get(english);
            modelAndView.addObject("vietnamese", vietnamese);
        } else {
            msg = "Result: not found any word.";
            modelAndView.addObject("msg", msg);
        }
        return modelAndView;
    }
}
