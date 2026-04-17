package com.bank.app.service;

import com.bank.app.entity.Account;
import com.bank.app.entity.Payment;
import com.bank.app.repository.AccountRepository;
import com.bank.app.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment transfer(String fromAccNo, String beneficiary, double amount) {
        Account acc = accountRepo.findByAccountNumber(fromAccNo)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        acc.setBalance(acc.getBalance() - amount);
        accountRepo.save(acc);

        Payment payment = new Payment();
        payment.setBeneficiary(beneficiary);
        payment.setAmount(amount);
        payment.setStatus("SUCCESS");
        payment.setFromAccount(acc);

        return paymentRepo.save(payment);
    }
}