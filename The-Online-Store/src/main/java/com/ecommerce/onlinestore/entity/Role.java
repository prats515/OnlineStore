package com.ecommerce.onlinestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(300)")
    private String name;

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
    }
}
