    package com.bank.app.controller;

    import java.util.List;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import com.bank.app.entity.Account;
    import com.bank.app.service.AccountService;

    @RestController
    @RequestMapping("/api/accounts")
    public class AccountController {

        private final AccountService service;

        public AccountController(AccountService service) {
            this.service = service;
        }

        @PostMapping
        public Account addAccount(@RequestBody Account account) {
           /* System.out.println("Inside create account-->" +account.getAccountType());
            System.out.println("Inside create account-->" +account.getBalance());
            System.out.println("Inside create account-->" +account.getStatus());
            System.out.println("Inside create account-->" +account.getCustomerName());*/
            return service.createAccount(account);
        }
        /*public ResponseEntity<Account> addAccount(@RequestBody Account account){
            System.out.println("Inside controller addAccount method");
            return new ResponseEntity<>(service.createAccount(account), HttpStatus.CREATED);
        }*/

        @GetMapping
        public List<Account> getAllAccounts() {
            return service.getAllAccounts();
        }

        @GetMapping("/{id}")
        public Account getAccount(@PathVariable Long id) {
            return service.getAccount(id);
        }

        @PostMapping("/{accNo}/deposit")
        public Account deposit(@PathVariable String accNo, @RequestParam double amount) {
            return service.deposit(accNo, amount);
        }

        @PostMapping("/{accNo}/withdraw")
        public Account withdraw(@PathVariable String accNo, @RequestParam double amount) {
            return service.withdraw(accNo, amount);
        }
    }