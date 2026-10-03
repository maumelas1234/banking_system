package com.maumela.banking;

import java.util.*;

public class Bank {
    private String bankName;
    private Map<String, Account> accounts;
    private Map<String, Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new HashMap<>();
        this.customers = new HashMap<>();
    }

    public Customer createCustomer(String name, String email, String phone) {
        String id = "CUST" + UUID.randomUUID().toString().substring(0,6).toUpperCase();
        Customer c = new Customer(id, name, email, phone);
        customers.put(id, c);
        return c;
    }

    public Account createAccount(Customer customer, String type, double initialDeposit) {
        Account acc = new Account(customer, type, initialDeposit);
        accounts.put(acc.getAccountNumber(), acc);
        return acc;
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void printAllAccounts() {
        System.out.println("\n=== " + bankName + " - All Accounts ===");
        for (Account a : accounts.values()) {
            System.out.println(a);
        }
    }

    public void printTransactionHistory(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc == null) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        System.out.println("\n--- Transaction History for " + accountNumber + " ---");
        for (Transaction t : acc.getTransactionHistory()) {
            System.out.println(t);
        }
        System.out.println("Current Balance: R" + acc.getBalance());
    }
}
