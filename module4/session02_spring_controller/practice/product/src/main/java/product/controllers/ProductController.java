package product.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product.model.Product;
import product.service.ProductService;
import product.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService = new ProductServiceImpl();
    String id_tit = "Product Id";  //id
    String  a_tit = "Product Name";   //a
    String b_tit = "Product Price";  //b
    String c_tit = "Product Quantity"; //c
    String  d_tit = "Product Color"; //d
    String  e_tit = "Product Description"; //e
    String f_tit = "Product Category";	 //f

    String redirectToListPage = "redirect:/product";
    String list_page = "/product/list";
    String create_page = "/product/create";
    String edit_page = "/product/edit";
    String delete_page = "/product/delete";

    private static final String MSG_CREATE = "New element has been added successfully: id = ";
    private static final String MSG_UPDATE = "The element has been updated successfully: id = ";
    private static final String MSG_DELETE = "The element has been delete successfully: id = ";
    private static final String MSG_FOUND = "Result found as the table below";
    private static final String MSG_NOT_FOUND = "No element found!";

    private Model initParam(Model model){
        model.addAttribute("id_tit", id_tit);
        model.addAttribute("a_tit", a_tit);
        model.addAttribute("b_tit", b_tit);
        model.addAttribute("c_tit", c_tit);
        model.addAttribute("d_tit", d_tit);
        model.addAttribute("e_tit", e_tit);
        model.addAttribute("f_tit", f_tit);

        model.addAttribute("list_page", list_page);
        model.addAttribute("create_page", create_page);
        model.addAttribute("edit_page", edit_page);
        model.addAttribute("delete_page", delete_page);
        return model;
    }

    // 1. LIST
    @GetMapping
    public String getListPage(Model model){
        initParam(model);
        model.addAttribute("eList", this.productService.findAll());
        return list_page;
    }

    // 2. CREATE
    @GetMapping("/create")
    public String getCreatePage(Model model){
        initParam(model);
        model.addAttribute("create_option", 1);
        model.addAttribute("eList", this.productService.findAll());
//        return create_page;  // create on create_page
        return list_page;      // create on LIST_PAGE
    }

    @PostMapping("/create")
    public String saveIn(@RequestParam String id, String a, String b, String c, String d, String e, String f, RedirectAttributes redirectAttributes){
        this.productService.save(new Product(id, a,b,c,d,e,f));
        redirectAttributes.addFlashAttribute("msg", MSG_CREATE + id);
        return redirectToListPage;
    }

    // 3. EDIT
    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable String id, Model model){
        initParam(model);
        model.addAttribute("edit_option", 1);
        model.addAttribute("eList", this.productService.findAll());
        model.addAttribute("el", this.productService.findById(id));
//        return edit_page;    // edit on edit_page
        return list_page;      // edit on LIST_PAGE
    }

    @PostMapping("/edit")
    public String editAndSave(@RequestParam String id, String a, String b, String c, String d, String e, String f, RedirectAttributes redirectAttributes){
        this.productService.update(id, new Product(id, a,b,c,d,e,f));
        redirectAttributes.addFlashAttribute("msg", MSG_UPDATE + id);
        return redirectToListPage;
    }

    // 4. DELETE
    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable String id, Model model){
        initParam(model);
        model.addAttribute("el", this.productService.findById(id));
        return delete_page;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id, RedirectAttributes redirectAttributes){
        this.productService.remove(id);
        redirectAttributes.addFlashAttribute("msg", MSG_DELETE + id);
        return redirectToListPage;
    }

    // 5. SEARCH
    @GetMapping("/search")
    public String searchList(@RequestParam String search, Model model){
        initParam(model);
        List<Product> allList = this.productService.findAll();
        List<Product> eList = new ArrayList<>();

        for (Product el : allList) {
            if(el.getProductName().contains(search)){
                eList.add(el);
            }
        }

        if (eList.size() > 0) {
            model.addAttribute("eList", eList);
            model.addAttribute("msg", MSG_FOUND);
        } else {
            model.addAttribute("msg", MSG_NOT_FOUND);
        }

        return list_page;
    }
}
