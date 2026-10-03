package com.maumela.banking;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Maumela Bank - Andela Demo");

        System.out.println("=== Java Banking System - Rebuilt by Tshifhiwa Maumela ===");
        System.out.println("Based on Udemy Tim Buchalka / Tim Chuck course - Extended with Git Bash & GitHub");

        // Demo data
        Customer c1 = bank.createCustomer("Tshifhiwa Maumela", "maumela.tshifhiwa.2@gmail.com", "0764244889");
        Customer c2 = bank.createCustomer("Desmond Moroane", "desmond@example.com", "0820000000");

        Account acc1 = bank.createAccount(c1, "SAVINGS", 5000);
        Account acc2 = bank.createAccount(c2, "CHECKING", 3000);

        System.out.println("Created demo accounts:");
        System.out.println(acc1);
        System.out.println(acc2);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. View All Accounts");
            System.out.println("7. View Transaction History");
            System.out.println("8. Apply Interest");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Name: "); String name = scanner.nextLine();
                        System.out.print("Email: "); String email = scanner.nextLine();
                        System.out.print("Phone: "); String phone = scanner.nextLine();
                        Customer c = bank.createCustomer(name, email, phone);
                        System.out.println("Created: " + c);
                        break;
                    case "2":
                        System.out.print("Customer ID: "); String cid = scanner.nextLine();
                        Customer cust = null;
                        // simple lookup by iterating
                        for (Account a : bank.getAllAccounts()) {
                            if (a.getCustomer().getCustomerId().equals(cid)) { cust = a.getCustomer(); break; }
                        }
                        if (cust == null) { System.out.println("Customer not found, create customer first"); break; }
                        System.out.print("Type (SAVINGS/CHECKING): "); String type = scanner.nextLine();
                        System.out.print("Initial deposit: "); double init = Double.parseDouble(scanner.nextLine());
                        Account acc = bank.createAccount(cust, type, init);
                        System.out.println("Created: " + acc);
                        break;
                    case "3":
                        System.out.print("Account Number: "); String accNoDep = scanner.nextLine();
                        System.out.print("Amount: "); double amtDep = Double.parseDouble(scanner.nextLine());
                        Account aDep = bank.findAccount(accNoDep);
                        if (aDep != null && aDep.deposit(amtDep, "Deposit via console")) {
                            System.out.println("Deposited. New balance: R" + aDep.getBalance());
                        } else System.out.println("Failed");
                        break;
                    case "4":
                        System.out.print("Account Number: "); String accNoW = scanner.nextLine();
                        System.out.print("Amount: "); double amtW = Double.parseDouble(scanner.nextLine());
                        Account aW = bank.findAccount(accNoW);
                        if (aW != null && aW.withdraw(amtW, "Withdrawal via console")) {
                            System.out.println("Withdrawn. New balance: R" + aW.getBalance());
                        } else System.out.println("Failed - insufficient funds or not found");
                        break;
                    case "5":
                        System.out.print("From Account: "); String from = scanner.nextLine();
                        System.out.print("To Account: "); String to = scanner.nextLine();
                        System.out.print("Amount: "); double amtT = Double.parseDouble(scanner.nextLine());
                        Account aFrom = bank.findAccount(from);
                        Account aTo = bank.findAccount(to);
                        if (aFrom != null && aTo != null && aFrom.transferTo(aTo, amtT)) {
                            System.out.println("Transfer successful");
                        } else System.out.println("Transfer failed");
                        break;
                    case "6":
                        bank.printAllAccounts();
                        break;
                    case "7":
                        System.out.print("Account Number: "); String accHist = scanner.nextLine();
                        bank.printTransactionHistory(accHist);
                        break;
                    case "8":
                        System.out.print("Account Number: "); String accInt = scanner.nextLine();
                        Account aInt = bank.findAccount(accInt);
                        if (aInt != null) { aInt.applyInterest(); System.out.println("Interest applied. New balance: R" + aInt.getBalance()); }
                        break;
                    case "9":
                        System.out.println("Exiting... Thank you");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
