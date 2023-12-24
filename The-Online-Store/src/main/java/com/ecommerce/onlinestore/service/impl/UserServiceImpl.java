package com.ecommerce.onlinestore.service.impl;

import com.ecommerce.onlinestore.entity.Role;
import com.ecommerce.onlinestore.entity.User;
import com.ecommerce.onlinestore.repos.UserRepo;
import com.ecommerce.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Configuration
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /*@Override
    public void saveUser(User user) {
        userRepo.save(user);
    }*/


    @Override
    public User saveUser(User user) {
        System.out.println("User"+user);
        //User customer= dtoToCustomer(user);
        User emp = null;
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        User existingUser = userRepo.getByEmail(user.getEmail());
        if(existingUser == null){
            return emp = userRepo.save(user);
        }else{
            new Exception("User already exist");
        }
        return null;
    }

/*    private  User dtoToCustomer(User userDto) {
        User user= modelMapper().map(userDto, Customer.class);
        return user;
    }*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}
