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
        validatePositiveAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new InvalidAmountException("Insufficient investment account balance.");
        }

        balance = balance.subtract(amount);
        BigDecimal current = investments.getOrDefault(fund, BigDecimal.ZERO);
        investments.put(fund, current.add(amount));
    }

    /**
     * Applies growth to every investment fund.
     */
    public void applyGrowth() {
        for (Map.Entry<Fund, BigDecimal> entry : investments.entrySet()) {
            BigDecimal currentAmount = entry.getValue();
            BigDecimal growth = currentAmount.multiply(entry.getKey().getGrowthRate());
            entry.setValue(currentAmount.add(growth));
        }
    }

    /**
     * Withdraws all investments back into the investment account.
     */
    public void withdrawAllInvestments() {
        BigDecimal total = BigDecimal.ZERO;

        for (BigDecimal amount : investments.values()) {
            total = total.add(amount);
        }

        balance = balance.add(total);
        investments.clear();
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