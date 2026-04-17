package com.bank.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.app.entity.Loan;
import com.bank.app.repository.LoanRepository;

@Service
public class LoanService {

    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public Loan createLoan(Loan loan) {
        loan.setStatus("APPROVED");
        return repository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return repository.findAll();
    }
}
