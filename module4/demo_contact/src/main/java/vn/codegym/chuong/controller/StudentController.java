package vn.codegym.chuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.chuong.common.SettingCode;
import vn.codegym.chuong.model.student_model.Student;
import vn.codegym.chuong.service.student_service.DivisionService;
import vn.codegym.chuong.service.student_service.HobbyService;
import vn.codegym.chuong.service.student_service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    // Constants
    private final String EL_NAME = "student";
    private final String LIST_PAGE = EL_NAME + "/list";
    private final String CREATE_PAGE = EL_NAME + "/create";
    private final String EDIT_PAGE = EL_NAME + "/edit";
    private final String DELETE_PAGE = EL_NAME + "/delete";
    private final String VIEW_PAGE = EL_NAME + "/view";
    private final String REDIRECT_TO_LIST = "redirect:/" + EL_NAME;

    private final String LIST_MSG = "Total of " + EL_NAME + ": ";
    private final String CREATE_MSG = "Create new " + EL_NAME + " successfully.";
    private final String EDIT_MSG = "Update the " + EL_NAME + " successfully.";
    private final String DELETE_MSG = "Delete the " + EL_NAME + " successfully.";
    private final String DELETE_MANY_MSG = "Delete the selected " + EL_NAME + "(s) successfully.";

    @Autowired
    private StudentService studentService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private HobbyService hobbyService;

    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                    @RequestParam(value = "propSelected", defaultValue = "") String propSelected,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Student> eList = null;
        //long total = studentService.count();

        if ("".equals(search) && typeId == 0) {
            // (1) show all
            eList = studentService.findAllByStatusTrue(pageable);
        } else if ("".equals(search) && typeId != 0) {
            // (2) show by type (attr = object)
            eList = new PageImpl<>(divisionService.findById(typeId).getStudentList());
            modelAndView.addObject("typeSelected", divisionService.findById(typeId));
        } else if(!("".equals(propSelected))){
            // (3) show by selected field (propSelected)
            switch (propSelected){
                case "name":
                    eList = studentService.findByNameContaining(pageable, search);
                    break;
                case "birthday":
                    eList = studentService.findByBirthdayContaining(pageable, search);
                    break;
                case "address":
                    eList = studentService.findByAddressContaining(pageable, search);
                    break;
            }
            modelAndView.addObject("propSelected", propSelected);
        } else {
            // (4) show by search on (name/address/email)
            eList = studentService.findByNameAddressEmail(pageable, search);
        }

        // set code as 'SV-zzzz'
        if(!eList.isEmpty()) {
            for (Student student : eList) {
                if(student.getCode() == null) {
                    student.setCode(SettingCode.setUpCode(student));
                    studentService.save(student);
                }
            }
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);
        modelAndView.addObject("typeId", typeId);
        modelAndView.addObject("propSelected", propSelected);
        modelAndView.addObject("divisionList", divisionService.findAll());
        modelAndView.addObject("hobbyList", hobbyService.findAll());

        // add new on modal for CREATE and EDIT
        modelAndView.addObject("student", new Student()); // create
        modelAndView.addObject("studentEdit", new Student()); // edit
        return modelAndView;
    }

    // 2.Create
    @PostMapping("/create")
    public ModelAndView getCreated(@Validated @ModelAttribute("student") Student student,
                                   BindingResult bindingResult,
                                   @RequestParam(value = "search", defaultValue = "") String search,
                                   @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                   @RequestParam(value = "propSelected", defaultValue = "") String propSelected,
                                   @PageableDefault(value = 5) Pageable pageable,
                                   RedirectAttributes redirect) {
        new Student().validate(student, bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
            modelAndView.addObject("eList", studentService.findAllByStatusTrue(pageable));

//            modelAndView.addObject("student", student);
            modelAndView.addObject("studentEdit", new Student());

            modelAndView.addObject("search", search);
            modelAndView.addObject("typeId", typeId);
            modelAndView.addObject("propSelected", propSelected);
            modelAndView.addObject("divisionList", divisionService.findAll());
            modelAndView.addObject("hobbyList", hobbyService.findAll());
            return modelAndView;
        } else {
            // set code
            studentService.save(student);

            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", CREATE_MSG);
            return modelAndView;
        }
    }

    // 3.Edit --> studentEdit
    @PostMapping("/edit")
    public ModelAndView getEdited(@Validated @ModelAttribute("studentEdit") Student student,
                                  BindingResult bindingResult,
                                  @RequestParam(value = "search", defaultValue = "") String search,
                                  @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                  @RequestParam(value = "propSelected", defaultValue = "") String propSelected,
                                  @PageableDefault(value = 5) Pageable pageable,
                                  RedirectAttributes redirect) {
        new Student().validate(student, bindingResult);
        if(bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
            modelAndView.addObject("eList", studentService.findAllByStatusTrue(pageable));
            modelAndView.addObject("search", search);
            modelAndView.addObject("typeId", typeId);
            modelAndView.addObject("propSelected", propSelected);
            modelAndView.addObject("divisionList", divisionService.findAll());
            modelAndView.addObject("hobbyList", hobbyService.findAll());
            modelAndView.addObject("student", new Student());
//            modelAndView.addObject("studentEdit", student);
            return modelAndView;
        } else {
            // set code
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", EDIT_MSG);
            return modelAndView;
        }
    }

    // 4. Delete
    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("studentId") long studentId,
                                   @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {
        studentService.remove(studentId); // ---> s t u d e n t Id
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // 5.View
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    // 6. Disable/available
    @PostMapping("/setStatus")
    public ModelAndView turnCustomerOnOff(@RequestParam("studentId") Long[] studentId,
                                          @PageableDefault(value = 5) Pageable pageable,
                                          RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        Student student = null;
        for (Long id : studentId){
            student = studentService.findById(id);
            if(student != null) {
                student.setStatus(false);
                studentService.save(student);
            }
        }
        redirectAttributes.addFlashAttribute("msg", DELETE_MANY_MSG);
        return modelAndView;
    }
}
