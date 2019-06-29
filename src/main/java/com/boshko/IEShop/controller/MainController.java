package com.boshko.IEShop.controller;

import com.boshko.IEShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ProductService productService;

//    private final CartService cartService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
//        this.cartService = cartService;
    }
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/blogSingle")
    public String blogSinglePage() {
        return "blog_single";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/product")
    public String productPage() {
        return "product";
    }

    @GetMapping("/regular")
    public String regularPage() {
        return "regular";
    }

    @GetMapping("/shop")
    public String shopPage() {
        return "shop";
    }

}
