package com.erfan.bank.service;

import com.erfan.bank.dto.CreateAccountRequest;
import com.erfan.bank.dto.TransactionDTO;
import com.erfan.bank.dto.TransferRequest;
import com.erfan.bank.model.Account;
import com.erfan.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    // Create a new account
    public Account createAccount(CreateAccountRequest request) {
        return repository.save(request.getName(), request.getInitialBalance());
    }

    // Perform money transfer between accounts
    public void transferFunds(TransferRequest request) {
        Account from = repository.findById(request.getFromAccountId());
        Account to = repository.findById(request.getToAccountId());

        if (from == null || to == null) {
            throw new IllegalArgumentException("Invalid account ID(s)");
        }

        if (from.getBalance() < request.getAmount()) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        // Perform transfer
        from.setBalance(from.getBalance() - request.getAmount());
        to.setBalance(to.getBalance() + request.getAmount());

        // Record transaction in both accounts
        TransactionDTO transaction = new TransactionDTO(from.getId(), to.getId(), request.getAmount());
        from.getTransactions().add(transaction);
        to.getTransactions().add(transaction);
    }

    // Retrieve all transactions for an account
    public List<TransactionDTO> getTransactionHistory(int accountId) {
        Account account = repository.findById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return account.getTransactions();
    }
}
