# TevinTasks.md

# Tevin Rugano - Testing & Documentation

## Primary Responsibilities

Your role is to help the team produce a polished, working project.

You are **not** expected to implement the core banking logic. Instead, you will help by testing features, improving documentation, and fixing simple issues.

If you are unsure about any task, ask Abbie before making changes.

---

# Files You Own

```text
docs/
├── README.md
├── TEAM_GUIDE.md
└── TASKBOARD.md
```

You may also make **small fixes** in Java files if Abbie assigns them to you.

---

# Development Rules

* Do not edit `BankingService.java` unless instructed.
* Do not edit `Account.java`, `SavingsAccount.java`, or `InvestmentAccount.java`.
* Follow the existing project structure.
* If you discover a bug, write it down and inform the team before attempting to fix it.
* Test one feature at a time.

---

# Documentation Tasks

## Review Documentation

### Checklist

* [ ] Read `TEAM_GUIDE.md`
* [ ] Read `TASKBOARD.md`
* [ ] Understand the project structure
* [ ] Update documentation if the team agrees on any changes

---

# Testing Tasks

## Login

Test the following:

* [ ] Login with Alice
* [ ] Login with Bob
* [ ] Login with Charlie
* [ ] Login with Diana
* [ ] Attempt to log in with an invalid username

---

## Menu

Verify that:

* [ ] All 9 menu options appear
* [ ] Invalid menu choices are handled correctly
* [ ] The menu is displayed again after completing an operation

---

## Savings Account

Test:

* [ ] Depositing money
* [ ] Withdrawing money
* [ ] Insufficient funds
* [ ] Interest is applied correctly when viewing the balance

---

## Money Transfers

Test:

* [ ] Sending money to another user
* [ ] Sending more money than available
* [ ] Sending money to a non-existent user

---

## Investments

Test:

* [ ] Investing in LOW_RISK
* [ ] Investing in MEDIUM_RISK
* [ ] Investing in HIGH_RISK
* [ ] Growth is applied when viewing balances
* [ ] Withdraw all investments

---

## Input Validation

Test:

* [ ] Letters where numbers are expected
* [ ] Negative amounts
* [ ] Zero amounts
* [ ] Empty input
* [ ] EOF (Ctrl + D)

---

# Bug Reporting

When you find a bug, record:

### Feature

Example:

```
Deposit Money
```

### Steps to Reproduce

```
1. Login as Alice
2. Choose Deposit
3. Enter -50
```

### Expected Result

Describe what should happen.

### Actual Result

Describe what actually happened.

---

# Small Coding Tasks

If assigned by Abbie, you may help with:

* [ ] Fixing typos
* [ ] Updating comments
* [ ] Improving documentation
* [ ] Fixing small validation issues
* [ ] Running the application and confirming features work

---

# Before You Commit

* [ ] Verify your changes
* [ ] Ensure the project still compiles
* [ ] Inform Abbie what you changed

---

# Git Workflow

Create your own branch:

```bash
git pull origin main
git checkout -b tevin-testing
```

Commit your work:

```bash
git add .
git commit -m "Complete testing and documentation updates"
git push origin tevin-testing
```

Notify **Abbie** before any merge. Do **not** merge directly into `main`.

---

# Goal

Your work helps ensure the application is reliable, easy to understand, and ready for submission. Careful testing and clear documentation are just as important as writing code.
