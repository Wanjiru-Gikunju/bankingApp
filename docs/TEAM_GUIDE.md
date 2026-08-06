# Green Day Bank - Team Guide

## Welcome

Welcome to the Green Day Bank project.

This project is being completed as part of the Kood Java Selection Sprint.

Before writing any code, please read this document completely.

Our goal is to build a clean, organized project where every team member understands their responsibilities and can work independently with minimal merge conflicts.

---

# Project Structure

```
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
```

---

# Team Members

* **Abbie Gikunju** — Team Lead
* **Eric Kamau**
* **Tevin Rugano**

---

# Development Rules

## 1. Do not work directly on the main branch.

Always create your own branch before writing code.

Example:

```
git checkout -b eric-account
```

or

```
git checkout -b tevin-testing
```

---

## 2. Commit often

Make small commits.

Good example:

```
Implemented Account.deposit()
```

Avoid large commits that change many unrelated files.

---

## 3. Only edit your assigned files

Do not modify another team member's files unless the team has agreed to the change.

This helps prevent merge conflicts.

---

## 4. Keep business logic in the correct place

Model classes (`model/`) should contain account logic.

Examples:

* deposit()
* withdraw()
* applyInterest()
* invest()

Service classes (`service/`) should control program flow.

Examples:

* login()
* displayMenu()
* processMenuChoice()

---

## 5. Do not print inside model classes

Printing belongs inside `BankingService`.

Model classes should only update data.

---

## 6. Follow the TODOs

Every unfinished method contains a TODO block.

Only implement the requirements listed in that TODO unless the team agrees to additional changes.

---

## 7. Ask before changing the architecture

Do not rename classes or move methods without discussing it with the team.

The project architecture has already been planned.

---

# Git Workflow

### Step 1

Pull the latest changes.

```
git pull origin main
```

### Step 2

Create your branch.

```
git checkout -b your-branch-name
```

### Step 3

Write your code.

### Step 4

Commit your changes.

```
git add .
git commit -m "Implemented assigned task"
```

### Step 5

Push your branch.

```
git push origin your-branch-name
```

### Step 6

Notify Abbie before merging into `main`.

Only the team lead will merge completed work into the main branch.

---

# Coding Standards

* Keep methods short.
* Write readable code.
* Reuse helper methods where possible (DRY principle).
* Do not duplicate logic.
* Keep comments simple and meaningful.
* Follow the existing formatting.

---

# Testing

Before submitting your work:

* Check that your code compiles.
* Test the feature you implemented.
* Ensure no existing functionality is broken.
* Inform the team if you discover a bug.

---

# Goal

Our goal is not only to finish the assignment, but to build a project that is clean, easy to understand, and easy to maintain.

Good communication and small commits will help us finish quickly and avoid unnecessary debugging.
