package com.ecommerce.onlinestore.entity;

import jakarta.persistence.*;
import lombok.Data;

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

}
