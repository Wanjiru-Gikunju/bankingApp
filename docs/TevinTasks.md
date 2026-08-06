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

* [x] Read `TEAM_GUIDE.md`
* [x] Read `TASKBOARD.md`
* [x] Understand the project structure
* [x] Update documentation if the team agrees on any changes

---

# Testing Tasks

## Login

Test the following:

* [x] Login with Alice
* [x] Login with Bob
* [x] Login with Charlie
* [x] Login with Diana
* [x] Attempt to log in with an invalid username

---

## Menu

Verify that:

* [x] All 9 menu options appear
* [x] Invalid menu choices are handled correctly
* [x] The menu is displayed again after completing an operation

---

## Savings Account

Test:

* [x] Depositing money
* [x] Withdrawing money
* [x] Insufficient funds
* [x] Interest is applied correctly when viewing the balance

---

## Money Transfers

Test:

* [x] Sending money to another user
* [x] Sending more money than available
* [x] Sending money to a non-existent user

---

## Investments

Test:

* [x] Investing in LOW_RISK
* [x] Investing in MEDIUM_RISK
* [x] Investing in HIGH_RISK
* [x] Growth is applied when viewing balances
* [x] Withdraw all investments

---

## Input Validation

Test:

* [x] Letters where numbers are expected
* [x] Negative amounts
* [x] Zero amounts
* [x] Empty input
* [x] EOF (Ctrl + D)

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

* [x] Fixing typos
* [x] Updating comments
* [x] Improving documentation
* [x] Fixing small validation issues
* [x] Running the application and confirming features work

---

# Before You Commit

* [x] Verify your changes
* [x] Ensure the project still compiles
* [x] Inform Abbie what you changed

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
