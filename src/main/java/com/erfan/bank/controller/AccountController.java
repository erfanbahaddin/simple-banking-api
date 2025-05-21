package com.erfan.bank.controller;

import com.erfan.bank.dto.CreateAccountRequest;
import com.erfan.bank.dto.TransferRequest;
import com.erfan.bank.model.Account;
import com.erfan.bank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        return ResponseEntity.ok(service.createAccount(request));
    }

    // Transfer funds between accounts
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequest request) {
        try {
            service.transferFunds(request);
            return ResponseEntity.ok("Transfer successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Retrieve transaction history
    @GetMapping("/{id}/transactions")
    public ResponseEntity<?> getTransactions(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.getTransactionHistory(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
