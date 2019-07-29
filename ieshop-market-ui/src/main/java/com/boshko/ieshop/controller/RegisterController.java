package com.boshko.ieshop.controller;

import com.boshko.ieshop.controller.repr.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/registration")
    public String registerForm(SignupForm signupForm) {
        return "register";
    }

    @PostMapping("/signup")
    public String signup(@Valid SignupForm signupForm, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        attributes.addAttribute("email", signupForm.getEmail());
        return "redirect:/register";
    }
}
