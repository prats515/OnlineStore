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

    @PostMapping("/registrationmethod")
    public String registerUserAccount(@ModelAttribute("user") User user) {
        System.out.println("In controller"+user);
        userService.saveUser(user);
        return "redirect:/registration?success";
    }

    @ModelAttribute("user")
    public User userDto() {
        return new User();
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
