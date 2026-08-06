package model;

import exception.InvalidAmountException;

import java.math.BigDecimal;

/**
 * Green Day Bank
 *
 * SavingsAccount.java
 *
 * Represents a user's savings account.
 * Applies 1% interest to the account balance.
 */
public class SavingsAccount extends Account {

    //==================================================
    // Constants
    //==================================================

    private static final BigDecimal INTEREST_RATE = new BigDecimal("0.01");

    //==================================================
    // Constructors
    //==================================================

    /**
     * Creates a new savings account.
     */
    public SavingsAccount() {
        super();
    }

    //==================================================
    // Public Methods
    //==================================================

    /**
     * Applies 1% interest to the current balance.
     */
    public void applyInterest() throws InvalidAmountException {
        BigDecimal interest = balance.multiply(INTEREST_RATE);
        balance = balance.add(interest);
    }

}