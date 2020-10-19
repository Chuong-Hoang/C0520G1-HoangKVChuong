package vn.codegym.chuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.chuong.model.main_model.Customer;
import vn.codegym.chuong.service.main_service.ContractService;
import vn.codegym.chuong.service.main_service.CustomerService;
import vn.codegym.chuong.service.sub_service.CustomerTypeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Constants
    private final String EL_NAME = "customer";
    private final String LIST_PAGE = EL_NAME + "/list";
    private final String LIST_PAGE_2 = EL_NAME + "/list_2";
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
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    ContractService contractService;
    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Customer> eList = null;
        long total = customerService.count();

        if ("".equals(search) && typeId == 0) {
            eList = customerService.findAll(pageable);
        } else if ("".equals(search) && typeId != 0) {
            eList = new PageImpl<>(customerTypeService.findById(typeId).getCustomerList());
            modelAndView.addObject("typeSelected", customerTypeService.findById(typeId));
        } else {
            eList = customerService.findByCustomerName(pageable, search);
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);
        modelAndView.addObject("typeId", typeId);
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());

        // add new on modal
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    // 2.Create
    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute Customer customer,
                                   @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

    // 3.Edit
    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@ModelAttribute Customer customer,
                                  @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {

        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", EDIT_MSG);
        return modelAndView;
    }

    // 4. Delete
    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("id") long id,
                                   @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {
        customerService.remove(id);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // 5.View
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    // 6. Disable/available
    @PostMapping("/setStatus")
    public ModelAndView turnCustomerOnOff(@RequestParam("customerId") Long customerId,
                                          @PageableDefault(value = 5) Pageable pageable,
                                          RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        Customer customer = customerService.findById(customerId);
        customer.setStatus("disable");
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

}
