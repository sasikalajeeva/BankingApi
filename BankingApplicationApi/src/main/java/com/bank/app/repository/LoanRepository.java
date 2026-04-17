package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {}

