package controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    UserService userService = new UserServiceImpl();

    @GetMapping("/list")
    public ModelAndView getListPage(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("eList", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView = new ModelAndView("/create");

        // create user with  a constructor without parameter and send to the create form for setter.
        modelAndView.addObject("user", new User());

        modelAndView.addObject("gendersArray", new String[]{"male", "female", "other"});
        modelAndView.addObject("hobbiesArray", new String[]{"sport", "swimming", "reading", "music", "painting", "travel"});
        modelAndView.addObject("typesArray", new String[]{"internal", "external", "other"});
        modelAndView.addObject("countriesArray", new String[]{"Vietnam", "Thailand", "USA", "Japan", "Korea"});

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreateDone(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView("/list");
        userService.save(user);
        //modelAndView.addObject("user", user);
        modelAndView.addObject("eList", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("user", userService.findById(id));

        modelAndView.addObject("gendersArray", new String[]{"male", "female", "other"});
        modelAndView.addObject("hobbiesArray", new String[]{"sport", "swimming", "reading", "music", "painting", "travel"});
        modelAndView.addObject("typesArray", new String[]{"internal", "external", "other"});
        modelAndView.addObject("countriesArray", new String[]{"Vietnam", "Thailand", "USA", "Japan", "Korea"});
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEditDone(@ModelAttribute User user, @RequestParam String id){
        ModelAndView modelAndView = new ModelAndView("/list");
        userService.update(user.getId(), user);
        modelAndView.addObject("eList", userService.findAll());
        return modelAndView;
    }
}
