package com.boshko.IEShop.controller;

import com.boshko.IEShop.controller.repr.CartItemRepr;
import com.boshko.IEShop.controller.repr.ProductRepr;
import com.boshko.IEShop.service.CartService;
import com.boshko.IEShop.service.ProductService;
import com.boshko.IEShop.service.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final ProductService productService;

    private final CartService cartService;

    @Autowired
    public MainController(ProductService productService,CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("cartItems", cartService.findAllItems());
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

    @PostMapping("/cart/update")
    public String updateCart(CartItemRepr cartItemRepr, HttpServletRequest httpServletRequest) {
        logger.info("Update customer cart");
        ProductRepr productRepr = productService.findById(cartItemRepr.getProductId());

        if (productRepr != null) {
            cartService.addItemQty(new ProductInfo(productRepr, "", ""), cartItemRepr.getQty());
        }
        return "redirect:" + cartItemRepr.getPageUrl();
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
