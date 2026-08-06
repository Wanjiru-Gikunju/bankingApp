# Method Contracts

This document defines the structure of every class in the Green Day Bank project before implementation begins.

The purpose is to ensure every team member understands what each class should contain and what every method is responsible for.

---

# BankingApp.java

## Purpose

Application entry point.

## Fields

| Field          | Type           | Description                             |
| -------------- | -------------- | --------------------------------------- |
| scanner        | Scanner        | The application's only Scanner instance |
| bankingService | BankingService | Controls the application                |

## Methods

### main(String[] args)

Starts the application.

Responsibilities:

* Create Scanner.
* Create BankingService.
* Start the application.
* Close Scanner when finished.

---

# BankingService.java

## Purpose

Coordinates the application's workflow.

This class **does not directly manage account balances**. Instead, it delegates work to the model classes.

## Fields

| Field       | Type              | Description                        |
| ----------- | ----------------- | ---------------------------------- |
| scanner     | Scanner           | Reads user input                   |
| users       | Map<String, User> | Stores all predefined users        |
| currentUser | User              | Currently logged-in user           |
| running     | boolean           | Controls the main application loop |

## Methods

### start()

Starts the application.

---

### initializeUsers()

Creates the predefined users:

* Alice
* Bob
* Charlie
* Diana

---

### login()

Authenticates a user.

---

### displayMenu()

Prints the banking menu.

---

### processMenuChoice(int choice)

Routes the user's menu selection to the correct operation.

---

### showBalance()

Displays:

* Cash
* Savings balance
* Investment balance

---

### depositMoney()

Reads an amount and deposits it into the savings account.

---

### withdrawMoney()

Reads an amount and withdraws it from the savings account.

---

### sendMoney()

Transfers money from one user's savings account to another user's savings account.

---

### investMoney()

Moves money from the investment account into a selected fund.

---

### transferBetweenAccounts()

Transfers money between savings and investment accounts.

---

### withdrawInvestments()

Withdraws all investments back into the investment account.

---

### logout()

Logs out the current user.

---

### exitApplication()

Ends the application gracefully.

---

### Helper Methods

These methods keep the code organized.

* findUser(String username)
* readAmount()
* validateAmount(BigDecimal amount)

---

# Account.java

## Purpose

Abstract base class for all bank accounts.

## Fields

| Field   | Type       |
| ------- | ---------- |
| balance | BigDecimal |

## Constructor

Account()

Initializes balance to zero.

## Methods

### deposit(BigDecimal amount)

Adds money to the account.

---

### withdraw(BigDecimal amount)

Removes money from the account.

---

### getBalance()

Returns the account balance.

---

### setBalance(BigDecimal balance)

Updates the account balance.

---

# SavingsAccount.java

## Purpose

Represents a user's savings account.

## Inherits

Account

## Methods

### applyInterest()

Applies 1% interest to the current balance.

---

# InvestmentAccount.java

## Purpose

Stores investments made by the user.

## Inherits

Account

## Fields

| Field       | Type                  |
| ----------- | --------------------- |
| investments | Map<Fund, BigDecimal> |

## Methods

### invest(Fund fund, BigDecimal amount)

Invests money into the selected fund.

---

### applyGrowth()

Applies growth to every investment.

---

### withdrawAllInvestments()

Returns all investments to the investment account balance.

---

### getInvestments()

Returns the current investments.

---

# User.java

## Purpose

Represents one customer.

## Fields

| Field             | Type              |
| ----------------- | ----------------- |
| name              | String            |
| cash              | BigDecimal        |
| savingsAccount    | SavingsAccount    |
| investmentAccount | InvestmentAccount |

## Constructor

User(String name)

Creates a new user with:

* $1000 cash
* Empty savings account
* Empty investment account

## Methods

### getName()

Returns the user's name.

---

### getCash()

Returns available cash.

---

### setCash(BigDecimal cash)

Updates available cash.

---

### getSavingsAccount()

Returns the user's savings account.

---

### getInvestmentAccount()

Returns the user's investment account.

---

# Fund.java

## Purpose

Defines the available investment funds.

## Enum Values

* LOW_RISK
* MEDIUM_RISK
* HIGH_RISK

Each fund stores its own growth percentage.

---

# InvalidAmountException.java

## Purpose

Represents an invalid monetary amount.

## Constructor

InvalidAmountException(String message)

Creates a custom exception with an explanatory error message.

---

# General Rules

* All monetary values must use `BigDecimal`.
* Only one `Scanner` should exist in the application.
* No business logic should be placed in `BankingApp`.
* Business logic should be implemented in model classes where appropriate.
* `BankingService` coordinates operations but should avoid duplicating business logic already available in the model layer.
* Methods should perform one clear responsibility and remain as small and reusable as possible.
