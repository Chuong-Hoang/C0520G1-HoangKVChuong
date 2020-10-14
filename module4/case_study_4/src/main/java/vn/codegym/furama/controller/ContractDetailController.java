package vn.codegym.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furama.model.main_model.Contract;
import vn.codegym.furama.model.main_model.ContractDetail;
import vn.codegym.furama.service.main_service.*;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    // Constants
    private final String EL_NAME = "contractDetail";
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
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceFuService attachServiceFuService;
    @Autowired
    private ContractService contractService;


    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<ContractDetail> eList = null;
        long total = contractDetailService.count();

        if ("".equals(search)) {
            eList = contractDetailService.findAll(pageable);
        } else {
            eList = contractDetailService.findByAttachServiceName(pageable, search);
//            eList = contractDetailService.findAll(pageable); // test
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);

        // add new on modal
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("attachServiceList", attachServiceFuService.findAll());
        modelAndView.addObject("contractList", contractService.findAll());
        return modelAndView;
    }

    // 2.Create
    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("attachServiceList", attachServiceFuService.findAll());
        modelAndView.addObject("contractList", contractService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute ContractDetail contractDetail,
                                   Pageable pageable, RedirectAttributes redirect) {
        contractDetailService.save(contractDetail);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

    // 3.Edit
    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("contract", contractDetailService.findById(id));
        modelAndView.addObject("attachServiceList", attachServiceFuService.findAll());
        modelAndView.addObject("contractList", contractService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@ModelAttribute ContractDetail contractDetail, Pageable pageable, RedirectAttributes redirect) {

        contractDetailService.save(contractDetail);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", EDIT_MSG);
        return modelAndView;
    }

    // 4. Delete
    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable(value = "id") long contractDetailId) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("contract", contractDetailService.findById(contractDetailId));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("contractDetailId") long contractDetailId, Pageable pageable, RedirectAttributes redirect) {
        contractDetailService.remove(contractDetailId);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // 5.View
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("contract", contractDetailService.findById(id));
        return modelAndView;
    }
}
