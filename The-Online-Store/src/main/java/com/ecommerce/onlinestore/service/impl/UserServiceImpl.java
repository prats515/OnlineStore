package com.ecommerce.onlinestore.service.impl;

import com.ecommerce.onlinestore.entity.User;
import com.ecommerce.onlinestore.repos.UserRepo;
import com.ecommerce.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepo userRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
