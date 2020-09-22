package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;
import vn.codegym.service.ProductServiceImplement;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImplement productService;

    @GetMapping
    public ModelAndView getListPage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("eList", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/product/create")
    public ModelAndView getCreatePage() {
        List<String> category = new ArrayList<>();
        category.add("phone");
        category.add("tv");
        category.add("car");
//        ModelAndView modelAndView = new ModelAndView("/create");
        ModelAndView modelAndView = new ModelAndView("/list");
        Product el = new Product();
        el.setProductId(String.valueOf((int) (Math.random() * 1000)));
        modelAndView.addObject("el", el);
        modelAndView.addObject("eList", productService.findAll());
        modelAndView.addObject("create_option", 1);
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/product/save")
    public ModelAndView save(Product el, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
//        el.setProductId(String.valueOf((int) (Math.random()*1000)));
        productService.save(el);
        redirectAttributes.addFlashAttribute("success", "Adding new successfully");
        return modelAndView;
    }

    @GetMapping("/product/edit/{id}")
    public ModelAndView getEditPage(@PathVariable String id) {
//        ModelAndView modelAndView = new ModelAndView("/edit");
        ModelAndView modelAndView = new ModelAndView("/list");
        List<String> category = new ArrayList<>();
        category.add("phone");
        category.add("tv");
        category.add("car");
        modelAndView.addObject("category", category);
        modelAndView.addObject("eList", productService.findAll());
        modelAndView.addObject("el", productService.findById(id));
        modelAndView.addObject("edit_option", 1);
        return modelAndView;
    }

    @PostMapping("/product/update")
    public ModelAndView update(Product el, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        productService.update(el.getProductId(), el);
        redirectAttributes.addFlashAttribute("success", "Updating successfully");
        return modelAndView;
    }

    @GetMapping("/product/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("el", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product/delete")
    public ModelAndView delete(Product el, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        productService.remove(el.getProductId());
        redirectAttributes.addFlashAttribute("success", "Deleting successfully");
        return modelAndView;
    }

    @GetMapping("product/view/{id}")
    public ModelAndView view(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("el", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("product/search")
    public ModelAndView search(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Product> products = productService.findAll();
        List<Product> eList = new ArrayList<>();
        for (Product el : products) {
            if (el.getProductName().toLowerCase().contains(search)) {
                eList.add(el);
            }
        }
        modelAndView.addObject("eList", eList);
        return modelAndView;
    }

}
