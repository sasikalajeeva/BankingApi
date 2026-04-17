package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}