package model;

import exception.InvalidAmountException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Green Day Bank
 *
 * InvestmentAccount.java
 *
 * Represents a user's investment account.
 * Allows users to invest in predefined funds and apply fund growth.
 */
public class InvestmentAccount extends Account {

    //==================================================
    // Fields
    //==================================================

    private final Map<Fund, BigDecimal> investments;

    //==================================================
    // Constructors
    //==================================================

    /**
     * Creates a new investment account.
     */
    public InvestmentAccount() {
        super();
        this.investments = new HashMap<>();
    }

    //==================================================
    // Public Methods
    //==================================================

    /**
     * Invests money into the selected fund.
     *
     * @param fund Investment fund.
     * @param amount Amount to invest.
     * @throws InvalidAmountException if the amount is invalid.
     */
    public void invest(Fund fund, BigDecimal amount)
            throws InvalidAmountException {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Invest money into the selected fund.
        //
        // Requirements:
        // 1. Validate the amount.
        // 2. Ensure sufficient investment account balance.
        // 3. Deduct the amount from this account balance.
        // 4. Add the amount to the selected fund.
        //==================================================

    }

    /**
     * Applies growth to every investment fund.
     */
    public void applyGrowth() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Apply growth to all investments.
        //
        // Requirements:
        // 1. Loop through every investment.
        // 2. Calculate growth using fund.getGrowthRate().
        // 3. Update each investment value.
        //==================================================

    }

    /**
     * Withdraws all investments back into the investment account.
     */
    public void withdrawAllInvestments() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Withdraw all invested money.
        //
        // Requirements:
        // 1. Calculate the total value of all investments.
        // 2. Add the total back to the account balance.
        // 3. Clear all investments.
        //==================================================

    }

    /**
     * Returns all current investments.
     *
     * @return Map of investment funds and their values.
     */
    public Map<Fund, BigDecimal> getInvestments() {
        return investments;
    }

}