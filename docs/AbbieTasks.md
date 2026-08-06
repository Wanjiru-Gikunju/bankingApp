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

* [ ] Keep the application running while `running == true`
* [ ] If no user is logged in:

  * call `login()`
* [ ] Otherwise:

  * display the menu
  * read the menu choice
  * process the selected option
* [ ] Handle EOF (Ctrl + D) gracefully

---

## Task 2 - Implement login()

### Objective

Authenticate a user.

### Checklist

* [ ] Ask for the user's name
* [ ] Search using `findUser()`
* [ ] Display an error if the user does not exist
* [ ] Set `currentUser` when login succeeds

---

## Task 3 - Implement readMenuChoice()

### Objective

Read a valid menu option.

### Checklist

* [ ] Reject empty input
* [ ] Reject letters
* [ ] Reject numbers outside 1–9
* [ ] Continue prompting until a valid option is entered

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

* [ ] Apply savings interest
* [ ] Apply investment growth

Display:

* [ ] Cash
* [ ] Savings balance
* [ ] Investment account balance
* [ ] Investments

---

## Task 6 - Implement readAmount()

### Objective

Read a valid monetary amount.

### Checklist

* [ ] Reject invalid decimal numbers
* [ ] Reject empty input
* [ ] Handle EOF
* [ ] Return a `BigDecimal`

---

# BankingApp.java

## Objective

Create the application's entry point.

### Checklist

* [ ] Instantiate `BankingService`
* [ ] Call `start()`

---

# Integration

After Eric completes the model classes:

* [ ] Connect every operation
* [ ] Ensure all classes compile
* [ ] Resolve merge conflicts if any
* [ ] Review teammates' code before merging

---

# Testing

Before submission, verify:

* [ ] Login
* [ ] Logout
* [ ] Deposits
* [ ] Withdrawals
* [ ] Transfers
* [ ] Investments
* [ ] Interest calculations
* [ ] Fund growth
* [ ] Invalid usernames
* [ ] Invalid menu choices
* [ ] Invalid monetary amounts
* [ ] EOF handling

---

# Git Responsibilities

* [ ] Review pull requests
* [ ] Merge approved branches into `main`
* [ ] Keep `main` stable
* [ ] Create the final submission version

---

# Definition of Done

This document is complete when:

* Every assigned method is implemented.
* The project compiles without errors.
* All teammates' work has been merged.
* The application has been tested end-to-end.
* The project is ready for submission.
