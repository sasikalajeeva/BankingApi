package com.bank.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id @GeneratedValue
    private Long id;
    private String type; // CREDIT / DEBIT
    private double amount;
    private LocalDateTime timestamp;

    @ManyToOne
    private Account account;
}
