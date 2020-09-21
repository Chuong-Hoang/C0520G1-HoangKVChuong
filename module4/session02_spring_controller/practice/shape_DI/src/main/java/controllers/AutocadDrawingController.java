package controllers;

import model.AutocadDrawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.Shape;

@Controller
public class AutocadDrawingController {
    @Autowired
    AutocadDrawing autocadDrawing;
    @Autowired
    Shape shape;

    @GetMapping("/autocad")
    public String getAutocadPage(Model model){
        autocadDrawing.setShape(shape);
        String s1 = autocadDrawing.showContent();
        model.addAttribute("s1", s1);
        return "/autocad";
    }
}
