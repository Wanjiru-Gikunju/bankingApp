# Architecture

## Overview

Green Day Bank is a command-line banking application written in Java.

The project follows Object-Oriented Programming (OOP) principles by separating responsibilities across multiple classes. Each class has a single purpose, making the code easier to understand, maintain, and test.

The application is divided into four main parts:

* Application Entry Point
* Service Layer
* Model Layer
* Exception Layer

---

# High-Level Architecture

```text
                     BankingApp
                          │
                          ▼
                  BankingService
                          │
      ┌───────────────────┼───────────────────┐
      ▼                   ▼                   ▼
    User           SavingsAccount    InvestmentAccount
      │                                        │
      └───────────────────┬────────────────────┘
                          ▼
                 Account (Abstract)
                          │
                          ▼
                        Fund
```

---

# Application Entry Point

## BankingApp

This is the application's starting point.

Responsibilities:

* Create the Scanner.
* Create the BankingService.
* Start the application.
* Close the Scanner before the program exits.

This class should contain **no banking logic**.

---

# Service Layer

## BankingService

The BankingService controls the entire application.

It is responsible for:

* Logging users in and out.
* Displaying the menu.
* Reading user input.
* Calling the correct banking operations.
* Validating requests.
* Coordinating communication between users and accounts.

The BankingService does not permanently store account balances itself. Instead, it delegates work to the model classes.

---

# Model Layer

The model layer represents the real-world banking objects.

## User

Represents a single customer.

Each user owns:

* A name
* Cash
* One savings account
* One investment account

The User class stores information but does not handle user interaction.

---

## Account (Abstract)

Represents a generic bank account.

Shared responsibilities:

* Store account balance.
* Deposit money.
* Withdraw money.

SavingsAccount and InvestmentAccount inherit from this class.

---

## SavingsAccount

Extends Account.

Additional responsibility:

* Apply 1% interest whenever the balance is viewed.

---

## InvestmentAccount

Extends Account.

Additional responsibilities:

* Store investments.
* Invest money into funds.
* Apply fund growth.
* Withdraw investments back into the investment account.

---

## Fund

Represents the available investment funds.

Available funds:

* LOW_RISK (2%)
* MEDIUM_RISK (5%)
* HIGH_RISK (10%)

Each fund knows its own growth rate.

---

# Exception Layer

## InvalidAmountException

Custom exception used whenever a user enters an invalid monetary amount.

Examples include:

* Negative values
* Zero values
* Invalid deposits
* Invalid withdrawals

---

# Data Flow

Example: Deposit Money

```text
User
 ↓
BankingService
 ↓
Current User
 ↓
SavingsAccount.deposit()
 ↓
Account Balance Updated
```

Example: Send Money

```text
Sender
 ↓
BankingService
 ↓
Sender SavingsAccount.withdraw()
 ↓
Recipient SavingsAccount.deposit()
```

Example: Invest Money

```text
User
 ↓
InvestmentAccount
 ↓
Selected Fund
 ↓
Investment Recorded
```

---

# Design Principles

This project follows these principles:

### Single Responsibility Principle

Each class has one primary responsibility.

### Encapsulation

Each object manages its own data.

### Inheritance

SavingsAccount and InvestmentAccount inherit common functionality from Account.

### Reusability

Common methods should be written once and reused whenever possible.

Avoid duplicating business logic.

---

# Package Responsibilities

```text
src
│
├── BankingApp.java
│
├── model/
│   Stores banking data and business objects.
│
├── service/
│   Controls program execution and user interaction.
│
└── exception/
    Stores custom exceptions.
```

---

# Summary

Every operation in the application follows the same pattern:

1. The user selects an action.
2. BankingService receives the request.
3. BankingService calls the appropriate model class.
4. The model updates its data.
5. BankingService displays the result.

Keeping responsibilities separated makes the project easier to develop as a team and reduces the likelihood of merge conflicts.
