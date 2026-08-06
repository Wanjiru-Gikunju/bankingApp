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

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Implement account deposit logic.
        //
        // Requirements:
        // 1. Call validatePositiveAmount(amount).
        // 2. Increase the account balance.
        // 3. Do not print anything.
        //==================================================

    }

    /**
     * Withdraws money from the account.
     *
     * @param amount Amount to withdraw.
     * @throws InvalidAmountException if the amount is invalid or funds are insufficient.
     */
    public void withdraw(BigDecimal amount) throws InvalidAmountException {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Implement account withdrawal logic.
        //
        // Requirements:
        // 1. Call validatePositiveAmount(amount).
        // 2. Ensure sufficient funds exist.
        // 3. Subtract the amount from the balance.
        // 4. Throw InvalidAmountException if validation fails.
        //==================================================

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

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Validate a monetary amount.
        //
        // Requirements:
        // 1. Check that amount is not null.
        // 2. Check that amount is greater than zero.
        // 3. Throw InvalidAmountException with a meaningful
        //    message if validation fails.
        //==================================================

    }

}