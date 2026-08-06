# AbbieTasks.md

# Abbie Gikunju - Team Lead

## Primary Responsibilities

As Team Lead, you are responsible for:

* Designing the project architecture.
* Implementing the application workflow.
* Connecting every class together.
* Reviewing teammates' code.
* Merging completed branches.
* Final testing before submission.

---

# Files You Own

```text
BankingApp.java

service/
└── BankingService.java
```

---

# BankingService.java

## Task 1 - Implement start()

### Objective

Control the entire application.

### Checklist

* [x] Keep the application running while `running == true`
* [x] If no user is logged in:

  * call `login()`
* [x] Otherwise:

  * display the menu
  * read the menu choice
  * process the selected option
* [x] Handle EOF (Ctrl + D) gracefully

---

## Task 2 - Implement login()

### Objective

Authenticate a user.

### Checklist

* [x] Ask for the user's name
* [x] Search using `findUser()`
* [x] Display an error if the user does not exist
* [x] Set `currentUser` when login succeeds

---

## Task 3 - Implement readMenuChoice()

### Objective

Read a valid menu option.

### Checklist

* [x] Reject empty input
* [x] Reject letters
* [x] Reject numbers outside 1–9
* [x] Continue prompting until a valid option is entered

---

## Task 4 - Implement processMenuChoice()

### Objective

Execute the selected operation.

### Checklist

Connect every menu option to the correct method.

```
1 -> showBalance()

2 -> depositToSavings()

3 -> withdrawFromSavings()

4 -> sendMoneyToUser()

5 -> investInFund()

6 -> transferBetweenAccounts()

7 -> withdrawAllInvestments()

8 -> logout()

9 -> Exit application
```

---

## Task 5 - Implement showBalance()

### Objective

Display every balance.

### Checklist

Before displaying balances:

* [x] Apply savings interest
* [x] Apply investment growth

Display:

* [x] Cash
* [x] Savings balance
* [x] Investment account balance
* [x] Investments

---

## Task 6 - Implement readAmount()

### Objective

Read a valid monetary amount.

### Checklist

* [x] Reject invalid decimal numbers
* [x] Reject empty input
* [x] Handle EOF
* [x] Return a `BigDecimal`

---

# BankingApp.java

## Objective

Create the application's entry point.

### Checklist

* [x] Instantiate `BankingService`
* [x] Call `start()`

---

# Integration

After Eric completes the model classes:

* [x] Connect every operation
* [x] Ensure all classes compile
* [x] Resolve merge conflicts if any
* [x] Review teammates' code before merging

---

# Testing

Before submission, verify:

* [x] Login
* [x] Logout
* [x] Deposits
* [x] Withdrawals
* [x] Transfers
* [x] Investments
* [x] Interest calculations
* [x] Fund growth
* [x] Invalid usernames
* [x] Invalid menu choices
* [x] Invalid monetary amounts
* [x] EOF handling

---

# Git Responsibilities

* [x] Review pull requests
* [x] Merge approved branches into `main`
* [x] Keep `main` stable
* [x] Create the final submission version

---

# Definition of Done

This document is complete when:

* Every assigned method is implemented.
* The project compiles without errors.
* All teammates' work has been merged.
* The application has been tested end-to-end.
* The project is ready for submission.
