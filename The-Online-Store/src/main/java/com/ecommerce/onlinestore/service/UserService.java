package com.ecommerce.onlinestore.service;

import com.ecommerce.onlinestore.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    List<User> getUser();
}
