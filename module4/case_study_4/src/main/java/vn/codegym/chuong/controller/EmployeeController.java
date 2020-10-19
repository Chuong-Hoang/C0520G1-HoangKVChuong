package vn.codegym.chuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.chuong.model.main_model.Employee;
import vn.codegym.chuong.service.main_service.EmployeeService;
import vn.codegym.chuong.service.sub_service.DivisionService;
import vn.codegym.chuong.service.sub_service.EducationDegreeService;
import vn.codegym.chuong.service.sub_service.PositionService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    // Constants
    private final String EL_NAME = "employee";
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
    private EmployeeService employeeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;

    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Employee> eList = null;
        long total = employeeService.count();

        if ("".equals(search)) {
            eList = employeeService.findAll(pageable);
        } else {
            eList = employeeService.findByEmployeeName(pageable, search);
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);

        // add new on modal
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("positionList", positionService.findAll());
        modelAndView.addObject("divisionList", divisionService.findAll());
        modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
        return modelAndView;
    }

    // 2.Create
    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("positionList", positionService.findAll());
        modelAndView.addObject("divisionList", divisionService.findAll());
        modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                                   @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {
        new Employee().validate(employee, bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
            modelAndView.addObject("eList", employeeService.findAll(pageable));

            modelAndView.addObject("positionList", positionService.findAll());
            modelAndView.addObject("divisionList", divisionService.findAll());
            modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", CREATE_MSG);
            return modelAndView;
        }
    }

    // 3.Edit
    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("employee", employeeService.findById(id));
        modelAndView.addObject("positionList", positionService.findAll());
        modelAndView.addObject("divisionList", divisionService.findAll());
        modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                                  @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {
        new Employee().validate(employee, bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
            modelAndView.addObject("eList", employeeService.findAll(pageable));

            modelAndView.addObject("positionList", positionService.findAll());
            modelAndView.addObject("divisionList", divisionService.findAll());
            modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", EDIT_MSG);
            return modelAndView;
        }
    }

    // 4. Delete
    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable(value = "employeeId") long employeeId) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("employee", employeeService.findById(employeeId));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("employeeId") long employeeId, RedirectAttributes redirect) {
        employeeService.remove(employeeId);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // 5.View
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

}
