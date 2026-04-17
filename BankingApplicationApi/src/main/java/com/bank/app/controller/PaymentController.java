package com.bank.app.controller;

import com.bank.app.entity.Payment;
import com.bank.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/transfer")
    public Payment transfer(@RequestParam String fromAcc,
                            @RequestParam String beneficiary,
                            @RequestParam double amount) {
        return service.transfer(fromAcc, beneficiary, amount);
    }
}