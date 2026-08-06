# EricTasks.md

# Eric Kamau - Model Layer Developer

## Primary Responsibilities

Your responsibility is to implement the banking logic inside the model classes.

**Do not add application flow or user interaction to these classes.**

The `BankingService` will call your methods.

---

# Files You Own

```text
model/
├── Account.java
├── SavingsAccount.java
└── InvestmentAccount.java
```

---

# Development Rules

* Only edit your assigned files.
* Follow the TODO blocks already placed in each method.
* Do not use `Scanner` inside model classes.
* Do not use `System.out.println()` inside model classes.
* Throw exceptions when validation fails instead of printing errors.
* Reuse existing methods where possible (DRY principle).

---

# Account.java

## Implement validatePositiveAmount(BigDecimal amount)

### Objective

Validate that an amount can be used in a banking operation.

### Checklist

* [x] Reject `null`
* [x] Reject zero
* [x] Reject negative values
* [x] Throw `InvalidAmountException` if validation fails

---

## Implement deposit(BigDecimal amount)

### Objective

Increase the account balance.

### Checklist

* [x] Validate the amount
* [x] Add the amount to the balance
* [x] Update the account balance

---

## Implement withdraw(BigDecimal amount)

### Objective

Decrease the account balance.

### Checklist

* [x] Validate the amount
* [x] Ensure sufficient funds exist
* [x] Subtract the amount from the balance
* [x] Throw `InvalidAmountException` if funds are insufficient

---

# SavingsAccount.java

## Implement applyInterest()

### Objective

Apply the bank's 1% savings interest.

### Checklist

* [x] Calculate 1% of the current savings balance
* [x] Add the interest to the balance
* [x] Update the account balance

---

# InvestmentAccount.java

## Implement invest()

### Objective

Move money from the investment account into a selected fund.

### Checklist

* [x] Validate the amount
* [x] Deduct the amount from the investment account
* [x] Add the amount to the selected fund

---

## Implement applyGrowth()

### Objective

Apply growth to each investment fund.

### Checklist

* [x] Apply the correct percentage based on the fund
* [x] Update the stored investment values

---

## Implement withdrawAllInvestments()

### Objective

Move every investment back into the investment account.

### Checklist

* [x] Calculate the total value of all funds
* [x] Add the total to the investment account balance
* [x] Reset all investment values to zero

---

# Before You Commit

* [x] Code compiles
* [x] No `Scanner` usage
* [x] No printing from model classes
* [x] No duplicated logic
* [x] TODOs completed
* [x] Methods tested

---

# Git Workflow

```bash
git pull origin main
git checkout -b eric-model
```

When your work is complete:

```bash
git add .
git commit -m "Implement account and investment logic"
git push origin eric-model
```

Notify **Abbie** before merging. Do **not** merge directly into `main`.
