package model;

import exception.InvalidAmountException;

import java.math.BigDecimal;

/**
 * Green Day Bank
 *
 * Account.java
 *
 * Abstract base class representing all bank accounts.
 */
public abstract class Account {

    //==================================================
    // Fields
    //==================================================

    protected BigDecimal balance;

    //==================================================
    // Constructors
    //==================================================

    /**
     * Creates a new account with a starting balance of 0.00.
     */
    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    //==================================================
    // Public Methods
    //==================================================

    /**
     * Deposits money into the account.
     *
     * @param amount Amount to deposit.
     * @throws InvalidAmountException if the amount is invalid.
     */
    public void deposit(BigDecimal amount) throws InvalidAmountException {
        validatePositiveAmount(amount);
        balance = balance.add(amount);
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount Amount to withdraw.
     * @throws InvalidAmountException if the amount is invalid or funds are insufficient.
     */
    public void withdraw(BigDecimal amount) throws InvalidAmountException {
        validatePositiveAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new InvalidAmountException("Insufficient funds.");
        }

        balance = balance.subtract(amount);
    }

    /**
     * Returns the current account balance.
     *
     * @return Current account balance.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    //==================================================
    // Helper Methods
    //==================================================

    /**
     * Updates the account balance.
     *
     * @param balance New account balance.
     */
    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Validates that a monetary amount is greater than zero.
     *
     * @param amount Amount to validate.
     * @throws InvalidAmountException if the amount is null, zero or negative.
     */
    protected void validatePositiveAmount(BigDecimal amount)
            throws InvalidAmountException {

        if (amount == null) {
            throw new InvalidAmountException("Amount cannot be null.");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero.");
        }
    }

}