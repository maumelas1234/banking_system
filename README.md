# Java Banking System - Rebuilt by Tshifhiwa Maumela

**Original:** Udemy Course by Tim Buchalka (Tim Chuck) - Java Banking System  
**Rebuilt:** 2026 by Tshifhiwa Maumela - Enhanced for Andela Banking Payments Role

## Features - Banking / Payment Systems
- Customer management (create, lookup)
- Account creation (SAVINGS, CHECKING) with auto-generated account numbers
- Deposit, Withdrawal, Transfer between accounts
- Transaction history with timestamp, type, balance after
- Interest calculation (SAVINGS 5%, CHECKING 1%)
- Transaction integrity - synchronized methods
- Console banking app with menu

## Tech Stack
- **Java** - OOP (Encapsulation, Inheritance, Polymorphism), Collections, Exception handling
- **SQL Concepts** - Transaction history, account lookup, ready for JDBC MySQL migration
- **Backend Services** - Bank service class managing accounts & customers
- **Git Bash & GitHub** - Version controlled

## How to Run (Git Bash)
```bash
git clone https://github.com/maumelas1234/JavaBankingSystem.git
cd JavaBankingSystem
javac -d out src/com/maumela/banking/*.java
java -cp out com.maumela.banking.BankingApp
```

## Next Steps - Spring Boot Version (For Andela)
- [ ] Convert to Spring Boot REST API
- [ ] Add MySQL with JDBC / Spring Data JPA
- [ ] REST endpoints: POST /customers, POST /accounts, POST /deposit, POST /withdraw, POST /transfer, GET /accounts/{id}/transactions
- [ ] Add Spring Security & transaction management

## Author
Maumela Tshifhiwa - 0764244889 - maumela.tshifhiwa.2@gmail.com
BSc Mathematical Science (CS Stream) - Final Year 74.5% - University of Limpopo
Soweto, Orlando West, Johannesburg, Gauteng - Hybrid 3 days onsite

## GitHub
github.com/maumelas1234
