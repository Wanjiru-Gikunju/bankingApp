# Green Day Bank

A command-line banking application built in Java as part of the **Kood Java Selection Sprint**.

The application allows multiple users to log in and perform everyday banking operations, including deposits, withdrawals, money transfers, savings management, and investments in predefined funds.

---

# Project Overview

Green Day Bank simulates a simple banking system where each user has:

* Cash available outside the bank
* A Savings Account
* An Investment Account
* Investment Funds

Users can securely manage their money through an interactive command-line interface.

---

# Features

## User Authentication

The application supports four predefined users:

* Alice
* Bob
* Charlie
* Diana

Users can log in, log out, and switch between accounts without restarting the application.

---

## Savings Account

Users can:

* View their savings balance
* Deposit money
* Withdraw money

A **1% interest** is automatically applied whenever the balance is viewed.

---

## Investment Account

Users can:

* Transfer money into their investment account
* Invest in predefined funds
* Withdraw all investments back into the investment account

Available funds:

| Fund        | Growth Rate |
| ----------- | ----------: |
| LOW_RISK    |          2% |
| MEDIUM_RISK |          5% |
| HIGH_RISK   |         10% |

Investment growth is automatically applied whenever balances are viewed.

---

## Money Transfers

Users can transfer money directly from their savings account to another registered user.

---

## Menu

```text
--- Banking App Menu ---
1. Show balance
2. Deposit money
3. Withdraw money
4. Send money to a person
5. Invest in funds
6. Transfer between accounts
7. Withdraw all investments
8. Logout
9. Exit
```

---

# Technologies Used

* Java
* Object-Oriented Programming (OOP)
* BigDecimal
* Scanner
* HashMap
* Enums
* Inheritance
* Exception Handling
* Git & GitHub
* Visual Studio Code

---

# Project Structure

```text
bankingApp/
│
├── BankingApp.java
│
├── exception/
│   └── InvalidAmountException.java
│
├── model/
│   ├── Account.java
│   ├── SavingsAccount.java
│   ├── InvestmentAccount.java
│   ├── User.java
│   └── Fund.java
│
├── service/
│   └── BankingService.java
│
└── docs/
    ├── TEAM_GUIDE.md
    ├── TASKBOARD.md
    ├── AbbieTasks.md
    ├── EricTasks.md
    └── TevinTasks.md
```

---

# Object-Oriented Design

The project follows a layered architecture:

* **Model Layer** – Represents the banking entities and business logic.
* **Service Layer** – Controls application flow and user interaction.
* **Exception Layer** – Contains custom exceptions for validation and error handling.
* **Application Layer** – Starts the program and initializes the banking service.

This separation keeps the code modular, reusable, and easy to maintain.

---

# How to Run

1. Clone the repository.
2. Open the project in Visual Studio Code.
3. Ensure Java is installed.
4. Compile the project.
5. Run `BankingApp.java`.
6. Log in as one of the predefined users and begin using the application.

---

# Error Handling

The application validates user input and handles common errors such as:

* Invalid usernames
* Invalid menu selections
* Invalid monetary amounts
* Insufficient funds
* Unexpected input (including EOF where applicable)

---

# Team

| Team Member   | Responsibility                                            |
| ------------- | --------------------------------------------------------- |
| Abbie Gikunju | Project architecture, service layer, integration, testing |
| Eric Kamau    | Model layer implementation and banking logic              |
| Tevin Rugano  | Testing, documentation, validation and project support    |

---

# Learning Objectives

This project demonstrates practical application of:

* Java fundamentals
* Object-oriented programming
* Inheritance
* Encapsulation
* Custom exceptions
* Collections
* BigDecimal for financial calculations
* Modular software design
* Team collaboration using Git and GitHub

---

# Future Improvements

Potential enhancements include:

* Persistent data storage
* Password-based authentication
* Transaction history
* Account creation
* Interest scheduling
* Additional investment products
* Unit testing
* Graphical user interface (GUI)

---

# License

This project was created for educational purposes as part of the Kood Java Selection Sprint.
