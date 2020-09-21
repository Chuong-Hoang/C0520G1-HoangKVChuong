package student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import student.model.Student;
import student.service.StudentService;
import student.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @GetMapping
    public String getListPage(Model model){
        model.addAttribute("eList", studentService.findAll());
        return "/student/list";
    }

    @GetMapping("/create")
    public String getCreatePage(){
        return "/student/create";
    }

    @PostMapping("/create")
    public String saveIn(@RequestParam String id, String name, String age, RedirectAttributes redirectAttributes){
        studentService.save(new Student(id, name, age));
        redirectAttributes.addFlashAttribute("msg", "The element id '" + id + "' has been added successfully.");
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable String id, Model model){
        model.addAttribute("edit", 1);
        model.addAttribute("eList", studentService.findAll());
        //model.addAttribute("el", studentService.findById(id));
        //return "/student/edit"; // edit on edit_page
        return "/student/list"; // edit on LIST_PAGE
    }
    @PostMapping("/confirm-edit")
    public String getConfirmPage(@RequestParam String id, String name, String age, Model model){
        model.addAttribute("el", new Student(id, name, age));
        return "/student/confirm_edit";
    }

    @PostMapping("/edit")
    public String editAndSave(@RequestParam String id, String name, String age, RedirectAttributes redirectAttributes){
        studentService.update(id, new Student(id, name, age));
        redirectAttributes.addFlashAttribute("msg", "The element id '" + id + "' has been updated successfully.");
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable String id, Model model){
        model.addAttribute("el", studentService.findById(id));
        return "/student/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id, RedirectAttributes redirectAttributes){
        studentService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "The element id '" + id + "' has been removed from the list.");
        return "redirect:/student";
    }

    @PostMapping("/find")
    public String searchName(@RequestParam String search, Model model){
        List<Student> studentList = studentService.findAll();
        List<Student> eList = new ArrayList<>();
        for(Student el : studentList) {
            if(el.getName().toLowerCase().contains(search)){
                eList.add(el);
            }
        }
        if(eList.size() > 0) {
            model.addAttribute("search", search);
            model.addAttribute("eList", eList);
        } else {
            model.addAttribute("msg", "No element found.");
        }
        return "/student/list";
    }
}
