package vn.codegym.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.product.model.Cart;
import vn.codegym.product.model.Product;
import vn.codegym.product.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView showCartPage(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("cart/show");
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if(cartItems != null) {
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("myCartTotalAmount", totalAmount(cartItems));
            session.setAttribute("myCartNumber", cartItems.size());
            modelAndView.addObject("editItem", new Cart());
        }
        return modelAndView;
    }

    @GetMapping("/add/{productId}")
    public ModelAndView addProductToCartPage(@PathVariable("productId") int productId, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if(cartItems == null) {
            cartItems = new HashMap<>();
        }

        Product product = productService.findById(productId);
        if(product != null){
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }

        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotalAmount", totalAmount(cartItems));
        session.setAttribute("myCartNumber", cartItems.size());


        return modelAndView;
    }

    // update cart
    @GetMapping("/update/{productId}")
    public ModelAndView updateCart(@PathVariable("productId") int productId, @ModelAttribute("editItem") Cart editItem, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:/cart");
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if(cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(productId);
        if(cartItems.containsKey(productId)){
            Cart item = cartItems.get(productId);
            item.setProduct(product);
            item.setQuantity(editItem.getQuantity());
            cartItems.put(productId, item);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotalAmount", totalAmount(cartItems));
        session.setAttribute("myCartNumber", cartItems.size());

        return modelAndView;

    }

    // Delete
    @GetMapping(value = "delete/{id}")
    public String viewRemove(ModelMap modelMap, HttpSession session, @PathVariable("id") int productId) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productId)) {
            cartItems.remove(productId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotalAmount", totalAmount(cartItems));
        session.setAttribute("myCartNumber", cartItems.size());
        return "cart/show";
    }

    // total amount
    public double totalAmount(HashMap<Integer, Cart> cartItems){
        double sum = 0;
        int count = 0;
        double price = 0;
        for(Map.Entry<Integer, Cart> entry : cartItems.entrySet()){
            price = Double.parseDouble(entry.getValue().getProduct().getPrice());
            count = entry.getValue().getQuantity();
            sum += price * count;
        }
        return  sum;
    }

}
