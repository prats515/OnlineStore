package com.ecommerce.onlinestore.service;

import com.ecommerce.onlinestore.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
}
