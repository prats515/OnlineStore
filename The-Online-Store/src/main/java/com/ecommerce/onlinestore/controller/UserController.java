package com.ecommerce.onlinestore.controller;

import com.ecommerce.onlinestore.entity.User;
import com.ecommerce.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    public UserService userService;
    //1- create a api to register user with email, firstname, lastname, mobile number, address
    @GetMapping("/registration")
    public String registerView(){
        return "registration";
    }

    @PostMapping("/save")
    public String registerUserAccount(@ModelAttribute("user") User registrationDto) {
        userService.saveUser(registrationDto);
        return "redirect:/registration?success";
    }

    @ModelAttribute("user")
    public User userDto() {
        return new User();
    }
}
