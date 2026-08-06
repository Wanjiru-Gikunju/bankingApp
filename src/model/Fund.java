package model;

import java.math.BigDecimal;

/**
 * ============================================================
 * Green Day Bank
 * Kood Java Selection Sprint
 *
 * File: Fund.java
 *
 * Purpose:
 * Represents the investment funds offered by the bank.
 * Each fund has a fixed growth rate that is used when
 * calculating investment returns.
 *
 * ============================================================
 */
public enum Fund {

    LOW_RISK(new BigDecimal("0.02")),
    MEDIUM_RISK(new BigDecimal("0.05")),
    HIGH_RISK(new BigDecimal("0.10"));

    /**
     * The percentage growth rate for this investment fund.
     */
    private final BigDecimal growthRate;

    /**
     * Creates a fund with its associated growth rate.
     *
     * @param growthRate Percentage growth for the fund.
     */
    Fund(BigDecimal growthRate) {
        this.growthRate = growthRate;
    }

    /**
     * Returns the growth rate of this fund.
     *
     * @return growth rate as a BigDecimal.
     */
    public BigDecimal getGrowthRate() {
        return growthRate;
    }
}