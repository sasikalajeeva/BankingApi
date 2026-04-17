package com.bank.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String customerName;
    private int accountNumber;
    private String accountType;
    private Double balance;
    private String status;

   // @ManyToOne
    //private Customer customer;
}
