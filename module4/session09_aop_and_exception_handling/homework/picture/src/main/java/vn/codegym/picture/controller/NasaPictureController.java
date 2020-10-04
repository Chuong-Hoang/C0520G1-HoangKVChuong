package vn.codegym.picture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.picture.exception.BadWordsException;
import vn.codegym.picture.model.NasaPicture;
import vn.codegym.picture.service.NasaPictureService;

@Controller
public class NasaPictureController {
    @Autowired
    private NasaPictureService nasaPictureService;

    @GetMapping("/picture")
    public String getListPage(Model model){
        model.addAttribute("objList", nasaPictureService.findAll());
        model.addAttribute("nasaPicture", new NasaPicture());
        return "picture/list";
    }

    @GetMapping("/picture/create")
    public String getCreatePage(Model model){
        model.addAttribute("nasaPicture", new NasaPicture());
        return "picture/list";
    }

    @PostMapping("/picture/create")
    public String getCreateDone(@ModelAttribute NasaPicture nasaPicture, Model model) throws BadWordsException {
        nasaPictureService.save(nasaPicture);
        return "redirect:/picture";
    }
}
