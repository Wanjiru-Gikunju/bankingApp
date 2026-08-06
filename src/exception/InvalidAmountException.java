package exception;

/**
 * ============================================================
 * Green Day Bank
 * Kood Java Selection Sprint
 *
 * File: InvalidAmountException.java
 *
 * Purpose:
 * A custom exception thrown when a banking operation
 * receives an invalid monetary amount.
 *
 * Examples:
 * - Deposit amount is zero
 * - Deposit amount is negative
 * - Withdrawal amount is zero
 * - Withdrawal amount is negative
 *
 * This exception helps separate business validation
 * from normal program flow.
 * ============================================================
 */
public class InvalidAmountException extends Exception {

    /**
     * Creates a new InvalidAmountException with
     * a descriptive error message.
     *
     * @param message Explanation of why the amount is invalid.
     */
    public InvalidAmountException(String message) {
        super(message);
    }
}