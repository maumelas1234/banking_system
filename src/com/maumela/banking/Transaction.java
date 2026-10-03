package com.maumela.banking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public enum Type { DEPOSIT, WITHDRAWAL, TRANSFER_IN, TRANSFER_OUT, INTEREST }
    private Type type;
    private double amount;
    private LocalDateTime timestamp;
    private double balanceAfter;
    private String description;

    public Transaction(Type type, double amount, double balanceAfter, String description) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
    public Type getType() { return type; }
    public double getAmount() { return amount; }
    @Override
    public String toString() {
        return String.format("[%s] %s: R%.2f | Balance: R%.2f | %s",
            timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
            type, amount, balanceAfter, description);
    }
}
