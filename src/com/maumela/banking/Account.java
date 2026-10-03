package com.maumela.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private String accountType; // SAVINGS, CHECKING
    private List<Transaction> transactionHistory;
    private double interestRate;

    public Account(Customer customer, String accountType, double initialDeposit) {
        this.accountNumber = "ACC" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        this.customer = customer;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        this.interestRate = accountType.equalsIgnoreCase("SAVINGS") ? 0.05 : 0.01;
        if (initialDeposit > 0) {
            transactionHistory.add(new Transaction(Transaction.Type.DEPOSIT, initialDeposit, balance, "Initial deposit"));
        }
    }

    public synchronized boolean deposit(double amount, String desc) {
        if (amount <= 0) return false;
        balance += amount;
        transactionHistory.add(new Transaction(Transaction.Type.DEPOSIT, amount, balance, desc));
        return true;
    }

    public synchronized boolean withdraw(double amount, String desc) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        transactionHistory.add(new Transaction(Transaction.Type.WITHDRAWAL, amount, balance, desc));
        return true;
    }

    public synchronized boolean transferTo(Account target, double amount) {
        if (target == null || amount <=0 || amount > this.balance) return false;
        if (this.withdraw(amount, "Transfer to " + target.getAccountNumber())) {
            target.deposit(amount, "Transfer from " + this.getAccountNumber());
            return true;
        }
        return false;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        deposit(interest, "Interest @" + (interestRate*100) + "%");
    }

    public String getAccountNumber() { return accountNumber; }
    public Customer getCustomer() { return customer; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactionHistory() { return transactionHistory; }
    public String getAccountType() { return accountType; }

    @Override
    public String toString() {
        return String.format("Account %s | %s | %s | Balance: R%.2f | Customer: %s",
            accountNumber, accountType, customer.getCustomerId(), balance, customer.getName());
    }
}
