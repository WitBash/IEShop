package com.boshko.IEShop.controller;

import com.boshko.IEShop.controller.repr.ProductRepr;
import com.boshko.IEShop.persist.repo.BrandRepository;
import com.boshko.IEShop.persist.repo.CategoryProductsRepository;
import com.boshko.IEShop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminProductsController {

    private static final Logger logger = LoggerFactory.getLogger(AdminProductsController.class);

    private final ProductService productService;

    private final CategoryProductsRepository categoryProductsRepository;

    private final BrandRepository brandRepository;

    @Autowired
    public AdminProductsController(ProductService productService, CategoryProductsRepository categoryProductsRepository,
                                   BrandRepository brandRepository) {
        this.productService = productService;
        this.categoryProductsRepository = categoryProductsRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/admin/products")
    public String adminProductsPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @GetMapping("/admin/product/{id}/edit")
    public String adminEditProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryProductsRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/product_form";
    }

    @GetMapping("/admin/product/{id}/delete")
    public String adminDeleteProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Products");
        productService.deleteById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/create")
    public String adminCreateProduct(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", new ProductRepr());
        model.addAttribute("categories", categoryProductsRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/product_form";
    }

    @PostMapping("/admin/product")
    public String adminUpsertProduct(Model model, RedirectAttributes redirectAttributes, ProductRepr product) {
        model.addAttribute("activePage", "Products");

        try {
            productService.save(product);
        } catch (Exception ex) {
            logger.error("Problem with creating or updating product", ex);
            redirectAttributes.addFlashAttribute("error", true);
            if (product.getId() == null) {
                return "redirect:/admin/product/create";
            }
            return "redirect:/admin/product/" + product.getId() + "/edit";
        }
        return "redirect:/admin/products";
    }
}
