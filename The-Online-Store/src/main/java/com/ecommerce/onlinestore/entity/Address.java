package com.ecommerce.onlinestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private String city;
    private String state;
    private String country;
}
