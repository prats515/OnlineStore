package com.ecommerce.onlinestore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private UUID customerId;

    private String firstName;

    private String lastName;

    private String mobNumber;

    private String email;

    private String password;
    public User() {

    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
