package com.bank.app.entity;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
}