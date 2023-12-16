package com.ecommerce.onlinestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int customerId;

    private String firstName;

    private String lastName;

    private String mobNumber;

    private String email;

    private String password;

    private Address address;
}
