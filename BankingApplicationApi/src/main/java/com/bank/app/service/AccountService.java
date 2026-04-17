    package com.bank.app.service;

    import java.time.LocalDateTime;
    import java.util.List;

    import com.bank.app.entity.Transaction;
    import com.bank.app.repository.TransactionRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.bank.app.entity.Account;
    import com.bank.app.repository.AccountRepository;

    @Service
    public class AccountService {
        @Autowired
        private AccountRepository accountRepo;
        @Autowired
        private TransactionRepo txnRepo;

            public Account createAccount(Account account) {
            //account.setStatus("ACTIVE");
           // Account savedAccount =repository.save(account);
            return accountRepo.save(account);
        }

        public List<Account> getAllAccounts() {
            return accountRepo.findAll();
        }

        public Account getAccount(Long id) {
            return accountRepo.findById(id).orElseThrow();
        }

        public Account deposit(String accNo, double amount) {
            Account acc = accountRepo.findByAccountNumber(accNo)
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            acc.setBalance(acc.getBalance() + amount);
            accountRepo.save(acc);

            Transaction txn = new Transaction();
            txn.setType("CREDIT");
            txn.setAmount(amount);
            txn.setTimestamp(LocalDateTime.now());
            txn.setAccount(acc);
            txnRepo.save(txn);

            return acc;
        }

        public Account withdraw(String accNo, double amount) {
            Account acc = accountRepo.findByAccountNumber(accNo)
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            if (acc.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance");
            }

            acc.setBalance(acc.getBalance() - amount);
            accountRepo.save(acc);

            Transaction txn = new Transaction();
            txn.setType("DEBIT");
            txn.setAmount(amount);
            txn.setTimestamp(LocalDateTime.now());
            txn.setAccount(acc);
            txnRepo.save(txn);

            return acc;
        }
    }
