package com.boshko.IEShop.controller;

import com.boshko.IEShop.persist.repo.CategoryProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminCategoriesController {

    private final CategoryProductsRepository categoryProductsRepository;

    @Autowired
    public AdminCategoriesController(CategoryProductsRepository categoryProductsRepository) {
        this.categoryProductsRepository = categoryProductsRepository;
    }

    @GetMapping("/admin/categories")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryProductsRepository.getAllCategoryRepr());
        return "admin/categories";
    }

    @GetMapping("/admin/category/{id}/edit")
    public String adminEditCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Categories");
        return "admin/categories";
    }

    @GetMapping("/admin/category/{id}/delete")
    public String adminDeleteCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Categories");
        return "admin/categories";
    }
}
