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
import vn.codegym.chuong.model.contact_model.Contact;
import vn.codegym.chuong.service.contact_service.ContactService;
import vn.codegym.chuong.service.contact_service.GroupService;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {
    // Constants
    private final String EL_NAME = "contact";
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
    private ContactService contactService;
    @Autowired
    private GroupService groupService;

    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                    @RequestParam(value = "propSelected", defaultValue = "") String propSelected,
                                    @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Contact> eList = null;
        //long total = contactService.count();

        if ("".equals(search) && typeId == 0) {
            // (1) show all
            eList = contactService.findAllByStatusTrue(pageable);
        } else if ("".equals(search) && typeId != 0) {
            // (2) show by type (attr = object)
            eList = new PageImpl<>(groupService.findById(typeId).getContactList());
            modelAndView.addObject("typeSelected", groupService.findById(typeId));
        } else if(!("".equals(propSelected))){
            // (3) show by selected field (propSelected)
            switch (propSelected){
                case "name":
                    eList = contactService.findByNameContaining(pageable, search);
                    break;
                case "birthday":
                    eList = contactService.findByBirthdayContaining(pageable, search);
                    break;
                case "address":
                    eList = contactService.findByAddressContaining(pageable, search);
                    break;
            }
            modelAndView.addObject("propSelected", propSelected);
        } else {
            // (4) show by search on (name/address/email)
            eList = contactService.findByNameAddressEmail(pageable, search);
        }
        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);
        modelAndView.addObject("typeId", typeId);
        modelAndView.addObject("propSelected", propSelected);
        modelAndView.addObject("groupList", groupService.findAll());

        // add new on modal
        modelAndView.addObject("contact", new Contact());
        return modelAndView;
    }

    // 2.Create
    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("groupList", groupService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@Validated @ModelAttribute Contact contact,
                                   BindingResult bindingResult,
                                   @PageableDefault(value = 5) Pageable pageable,
                                   RedirectAttributes redirect) {
        new Contact().validate(contact, bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
            modelAndView.addObject("groupList", groupService.findAll());
            return modelAndView;
        } else {
            contactService.save(contact);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", CREATE_MSG);
            return modelAndView;
        }
    }

    // 3.Edit
    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("contact", contactService.findById(id));
        modelAndView.addObject("groupList", groupService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@Validated @ModelAttribute Contact contact,
                                  BindingResult bindingResult,
                                  @PageableDefault(value = 5) Pageable pageable,
                                  RedirectAttributes redirect) {
        new Contact().validate(contact, bindingResult);
        if(bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
            modelAndView.addObject("groupList", groupService.findAll());
            return modelAndView;
        }else {
            contactService.save(contact);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", EDIT_MSG);
            return modelAndView;
        }
    }

    // 4. Delete
    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("contact", contactService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("contactId") long id,
                                   @PageableDefault(value = 5) Pageable pageable, RedirectAttributes redirect) {
        contactService.remove(id);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // 5.View
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("contact", contactService.findById(id));
        return modelAndView;
    }

    // 6. Disable/available
    @PostMapping("/setStatus")
    public ModelAndView turnCustomerOnOff(@RequestParam("contactId") Long[] contactId,
                                          @PageableDefault(value = 5) Pageable pageable,
                                          RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        Contact contact = null;
        for (Long id : contactId){
            contact = contactService.findById(id);
            if(contact != null) {
                contact.setStatus(false);
                contactService.save(contact);
            }
        }
        redirectAttributes.addFlashAttribute("msg", DELETE_MANY_MSG);
        return modelAndView;
    }
}
