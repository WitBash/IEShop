package com.boshko.ieshop.controller.repr;

import com.boshko.ieshop.controller.validation.EmailNotRegistered;

import javax.validation.constraints.NotBlank;

public class SignupForm {

    @NotBlank
    @EmailNotRegistered
    private String email;

    public SignupForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
