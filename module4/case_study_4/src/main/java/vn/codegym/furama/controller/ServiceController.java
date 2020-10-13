package vn.codegym.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furama.model.main_model.Service;
import vn.codegym.furama.service.main_service.ServiceFuService;
import vn.codegym.furama.service.sub_service.RentTypeService;
import vn.codegym.furama.service.sub_service.ServiceTypeService;

@Controller
@RequestMapping("/service")
public class ServiceController {
    // Constants
    private final String EL_NAME = "service";
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
    private ServiceFuService serviceFuService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Service> eList = null;
        long total = serviceFuService.count();

        if ("".equals(search) && typeId == 0) {
            eList = serviceFuService.findAll(pageable);
        } else if ("".equals(search) && typeId != 0) {
            eList = new PageImpl<>(serviceTypeService.findById(typeId).getServiceList());
            modelAndView.addObject("serviceTypeSelected", serviceTypeService.findById(typeId));
        } else {
            eList = serviceFuService.findByServiceNameContaining(pageable, search);
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);
        modelAndView.addObject("typeId", typeId);
        modelAndView.addObject("rentTypeList", rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList", serviceTypeService.findAll());

        // add new on modal
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    // 2.Create
    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute Service service,
                                   Pageable pageable, RedirectAttributes redirect) {
        serviceFuService.save(service);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

}
