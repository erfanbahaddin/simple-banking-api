package com.erfan.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateAccountRequest {
    // Name must not be empty
    @NotBlank
    private String name;

    // Initial balance must be greater than 0
    @Positive
    private double initialBalance;

    // Getters and setters:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }
}
