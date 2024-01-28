package com.ecommerce.onlinestore.controller;

import com.ecommerce.onlinestore.entity.User;
import com.ecommerce.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    public UserService userService;
    @GetMapping("/user")
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping("/logged-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

}
