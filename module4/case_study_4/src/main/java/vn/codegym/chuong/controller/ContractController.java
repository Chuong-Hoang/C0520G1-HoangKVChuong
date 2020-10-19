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
import vn.codegym.chuong.model.main_model.Contract;
import vn.codegym.chuong.model.main_model.ContractDetail;
import vn.codegym.chuong.service.main_service.ContractService;
import vn.codegym.chuong.service.main_service.CustomerService;
import vn.codegym.chuong.service.main_service.EmployeeService;
import vn.codegym.chuong.service.main_service.ServiceFuService;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    // Constants
    private final String EL_NAME = "contract";
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
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceFuService serviceFuService;

    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Contract> eList = null;
        long total = contractService.count();

        if ("".equals(search)) {
            eList = contractService.findAll(pageable);
        } else {
            eList = contractService.findByDate(pageable, search);
//            eList = contractService.findAll(pageable); // test
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);

        // add new on modal
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("employeeList", employeeService.findAll());
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("serviceFuList", serviceFuService.findAll());
        return modelAndView;
    }

    // 2.Create
    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("employeeList", employeeService.findAll());
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("serviceFuList", serviceFuService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute Contract contract,
                                   Pageable pageable, RedirectAttributes redirect) {
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

    // 3.Edit
    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("contract", contractService.findById(id));
        modelAndView.addObject("employeeList", employeeService.findAll());
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("serviceFuList", serviceFuService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@ModelAttribute Contract contract, Pageable pageable, RedirectAttributes redirect) {

        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", EDIT_MSG);
        return modelAndView;
    }

    // 4. Delete
    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable(value = "contractId") long contractId) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("contract", contractService.findById(contractId));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("contractId") long contractId, Pageable pageable, RedirectAttributes redirect) {
        contractService.remove(contractId);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // 5.View
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("contract", contractService.findById(id));
        return modelAndView;
    }

    // 6. ContractDetail List
    @GetMapping("/contractDetailList/{id}")
    public ModelAndView getContractDetailList(@PathVariable(value = "id") long id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contractDetail/list");
        List<ContractDetail> contractDetailList = contractService.findById(id).getContractDetailList();
        Page<ContractDetail> eList = new PageImpl<>(contractDetailList);
        Double totalAmount = 0.0D;
        for(ContractDetail cont : contractDetailList){
            totalAmount += (Double.parseDouble(cont.getQuantity()) * Double.parseDouble(cont.getAttachService().getAttachServiceCost()));
        }
        Double deposit = Double.parseDouble(contractService.findById(id).getContractDeposit());
        Double serviceCost = Double.parseDouble(contractService.findById(id).getService().getServiceCost());
        Double payment = totalAmount + serviceCost - deposit;
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("totalAmount", totalAmount);
        modelAndView.addObject("deposit", deposit);
        modelAndView.addObject("serviceCost", serviceCost);
        modelAndView.addObject("payment", payment);

        return modelAndView;
    }
}
