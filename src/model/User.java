package model;

import java.math.BigDecimal;

/**
 * Green Day Bank
 *
 * User.java
 *
 * Represents a bank customer.
 * Each user has cash, a savings account and an investment account.
 */
public class User {

    //==================================================
    // Fields
    //==================================================

    private final String name;
    private BigDecimal cash;
    private final SavingsAccount savingsAccount;
    private final InvestmentAccount investmentAccount;

    //==================================================
    // Constructors
    //==================================================

    /**
     * Creates a new user with:
     * - $1000 cash
     * - Empty savings account
     * - Empty investment account
     *
     * @param name User's name.
     */
    public User(String name) {
        this.name = name;
        this.cash = new BigDecimal("1000.00");
        this.savingsAccount = new SavingsAccount();
        this.investmentAccount = new InvestmentAccount();
    }

    //==================================================
    // Public Methods
    //==================================================

    /**
     * Returns the user's name.
     *
     * @return User's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user's available cash.
     *
     * @return Cash available.
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * Updates the user's available cash.
     *
     * @param cash New cash balance.
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * Returns the user's savings account.
     *
     * @return Savings account.
     */
    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    /**
     * Returns the user's investment account.
     *
     * @return Investment account.
     */
    public InvestmentAccount getInvestmentAccount() {
        return investmentAccount;
    }

}