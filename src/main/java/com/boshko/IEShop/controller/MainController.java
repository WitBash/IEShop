package com.boshko.IEShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String indexPage() {
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
