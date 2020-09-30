package vn.codegym.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.product.model.Product;
import vn.codegym.product.service.CategoryService;
import vn.codegym.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    // Constants
    private final String EL_NAME = "product";
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
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ModelAndView getListPage(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        modelAndView.addObject("eList", productService.findAll(pageable));
        modelAndView.addObject("COUNT_MSG", LIST_MSG + productService.count());
        modelAndView.addObject("ids", new int[]{}); // only for delete many

        // Only for sort by category on list page
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("el", new Product());
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute Product el, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        productService.save(el);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("el", productService.findById(id));
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@ModelAttribute Product el, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        productService.save(el);
        redirect.addFlashAttribute("msg", EDIT_MSG);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("el", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@ModelAttribute Product el, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        productService.delete(el.getId());
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    // Search
    @GetMapping("/search")
    public ModelAndView getSearched(@RequestParam(value = "keyText", defaultValue = "") String keyText, @PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Product> elFound = productService.findByName(keyText, pageable);
        modelAndView.addObject("eList", elFound);
        modelAndView.addObject("keyText", keyText);
        if (elFound != null) {
            modelAndView.addObject("msg", "Result found as table below.");
        } else {
            modelAndView.addObject("msg", "Not any found.");
        }
        return modelAndView;
    }

    // View details
    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("el", productService.findById(id));
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    // Delete many elements
    @PostMapping("/delete-many")
    public ModelAndView getDeleteManyDone(@RequestParam int[] ids, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        if(ids != null) {
            for (Integer id : ids) {
                productService.delete(id);
            }
        }
        redirect.addFlashAttribute("msg", DELETE_MANY_MSG);
        return modelAndView;
    }

    // Create on list page
    @GetMapping("/create-on-list")
    public ModelAndView getCreateOnListPage(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        modelAndView.addObject("create_option", 1);
        modelAndView.addObject("elNew", new Product());
        modelAndView.addObject("eList", productService.findAll(pageable));
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-on-list")
    public ModelAndView getCreateOnListDone(@ModelAttribute Product elNew, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        productService.save(elNew);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

    // Edit on list page
    @GetMapping("/edit-on-list/{id}")
    public ModelAndView getEditOnListPage(@PathVariable int id, @PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        modelAndView.addObject("elEdit", productService.findById(id));
        modelAndView.addObject("edit_option", 1);
        modelAndView.addObject("eList", productService.findAll(pageable));
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit-on-list")
    public ModelAndView getEditOnListDone(@ModelAttribute Product elEdit, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        productService.save(elEdit);
        redirect.addFlashAttribute("msg", EDIT_MSG);
        return modelAndView;
    }

    // Find by category
    @GetMapping("/find-by-category/{cateId}")
    public ModelAndView getFoundByCategory(@PathVariable int cateId, @PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        Page<Product> elFound = productService.findByCategory(cateId, pageable);
        modelAndView.addObject("eList", elFound);
        modelAndView.addObject("cateList", categoryService.findAll());
        modelAndView.addObject("cateSelected", categoryService.findById(cateId));
        if (elFound != null) {
            modelAndView.addObject("msg", "Result found as table below.");
        } else {
            modelAndView.addObject("msg", "Not any found.");
        }
        return modelAndView;
    }

}
