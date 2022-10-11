package com.example.accounts.controller;

import com.example.accounts.model.Account;
import com.example.accounts.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")

public class Controller {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping(path = "/", produces = "application/json")
    public List<Account> getUser() {
        return accountRepository.findAll();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Account addUser(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Optional<Account> getUser(@PathVariable String id) {
        return accountRepository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    Optional<Account> updateAccount(@RequestBody Account newAccount, @PathVariable String id) {
        Optional<Account> acc = accountRepository.findById(Long.valueOf(id));

        if (acc.isPresent()) {
            String accType = acc.get().getAccountType();
            String accNum = acc.get().getAccNumber();
            String accName = acc.get().getAccountName();
            String accBalance = acc.get().getBalance();

            if (!newAccount.getAccountType().equals(accType)){
                acc.get().setAccountType(newAccount.getAccountType());
            }
            else if (!newAccount.getAccNumber().equals(accNum)){
                acc.get().setAccNumber(newAccount.getAccNumber());
            }
            else if (!newAccount.getAccountName().equals(accName)){
                acc.get().setAccountName(newAccount.getAccountName());
            }
            else if (!newAccount.getBalance().equals(accBalance)){
                acc.get().setBalance(newAccount.getBalance());
            }
        }

        return acc;
    }

    @DeleteMapping("/{id}")
    Optional<Account> deleteAccount(@PathVariable String id) {
        Optional<Account> acc = accountRepository.findById(Long.valueOf(id));

        if (acc.isPresent())
            accountRepository.deleteById(Long.valueOf(id));

        return acc;
    }
}

