    package com.bank.app.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.ManyToOne;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Loan {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Double amount;
        private Double interestRate;
        private int tenureMonths;
        private String status;

        @ManyToOne
        @JoinColumn(name = "account_id")
        private Account account;

    }