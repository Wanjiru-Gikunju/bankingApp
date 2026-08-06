package service;

import model.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Green Day Bank
 *
 * BankingService.java
 *
 * Handles application flow, user sessions and banking operations.
 */
public class BankingService {

    //==================================================
    // Fields
    //==================================================

    private final Scanner scanner;
    private final Map<String, User> users;

    private User currentUser;
    private boolean running;

    //==================================================
    // Constructors
    //==================================================

    /**
     * Creates the banking service.
     */
    public BankingService() {
        scanner = new Scanner(System.in);
        users = new HashMap<>();

        currentUser = null;
        running = true;

        initializeUsers();
    }

    //==================================================
    // Public Methods
    //==================================================

    /**
     * Starts the banking application.
     */
    public void start() {

        //==================================================
        // TODO (Abbie Gikunju)
        //
        // Objective:
        // Run the application's main loop.
        //
        // Requirements:
        // 1. Continue while running is true.
        // 2. If no user is logged in, call login().
        // 3. Otherwise:
        //      - displayMenu()
        //      - readMenuChoice()
        //      - processMenuChoice(choice)
        // 4. Handle EOF (Ctrl + D) gracefully.
        //==================================================

    }

    //==================================================
    // Login Methods
    //==================================================

    /**
     * Logs a user into the application.
     */
    private void login() {

        //==================================================
        // TODO (Abbie Gikunju)
        //
        // Objective:
        // Log a user into the banking system.
        //
        // Requirements:
        // 1. Ask for the user's name.
        // 2. Verify the user exists.
        // 3. Set currentUser.
        // 4. Display an error if the user is invalid.
        // 5. Handle EOF gracefully.
        //==================================================

    }

    /**
     * Logs out the current user.
     */
    private void logout() {
        currentUser = null;
    }

    //==================================================
    // Menu Methods
    //==================================================

    /**
     * Displays the banking menu.
     */
    private void displayMenu() {

        System.out.println();
        System.out.println("--- Banking App Menu ---");
        System.out.println("1. Show balance");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Send money to a person");
        System.out.println("5. Invest in funds");
        System.out.println("6. Transfer between accounts");
        System.out.println("7. Withdraw all investments");
        System.out.println("8. Logout");
        System.out.println("9. Exit");
    }

    /**
     * Reads a valid menu option.
     *
     * @return Menu choice.
     */
    private int readMenuChoice() {

        //==================================================
        // TODO (Abbie Gikunju)
        //
        // Objective:
        // Read and validate the user's menu choice.
        //
        // Requirements:
        // 1. Handle EOF gracefully.
        // 2. Reject non-numeric input.
        // 3. Reject values outside 1-9.
        // 4. Continue prompting until valid.
        //==================================================

        return -1;
    }

    /**
     * Executes the selected menu option.
     *
     * @param choice Menu option selected by the user.
     */
    private void processMenuChoice(int choice) {

        //==================================================
        // TODO (Abbie Gikunju)
        //
        // Objective:
        // Execute the selected menu option.
        //
        // Requirements:
        // 1 -> showBalance()
        // 2 -> depositMoney()
        // 3 -> withdrawMoney()
        // 4 -> sendMoney()
        // 5 -> investMoney()
        // 6 -> transferBetweenAccounts()
        // 7 -> withdrawAllInvestments()
        // 8 -> logout()
        // 9 -> running = false
        //==================================================

    }

    //==================================================
    // Banking Operations
    //==================================================

    /**
     * Displays the user's balances.
     */
    private void showBalance() {

        //==================================================
        // TODO (Abbie Gikunju)
        //
        // Objective:
        // Display all balances.
        //
        // Requirements:
        // 1. Apply savings interest.
        // 2. Apply investment growth.
        // 3. Display:
        //      - Cash
        //      - Savings balance
        //      - Investment account balance
        //      - Investments
        //==================================================

    }

    /**
     * Deposits money into the savings account.
     */
    private void depositMoney() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Deposit cash into the savings account.
        //
        // Requirements:
        // 1. Read deposit amount.
        // 2. Ensure user has enough cash.
        // 3. Call savingsAccount.deposit().
        // 4. Reduce the user's cash.
        //==================================================

    }

    /**
     * Withdraws money from the savings account.
     */
    private void withdrawMoney() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Withdraw money from the savings account.
        //
        // Requirements:
        // 1. Read withdrawal amount.
        // 2. Call savingsAccount.withdraw().
        // 3. Increase user's cash.
        //==================================================

    }

    /**
     * Sends money to another user.
     */
    private void sendMoney() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Transfer money between users.
        //
        // Requirements:
        // 1. Read recipient.
        // 2. Validate recipient.
        // 3. Read amount.
        // 4. Withdraw from sender.
        // 5. Deposit into recipient's savings account.
        //==================================================

    }
    /**
     * Invests money into one of the available funds.
     */
    private void investMoney() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Invest money from the investment account.
        //
        // Requirements:
        // 1. Display available funds.
        // 2. Read the selected fund.
        // 3. Read the investment amount.
        // 4. Call investmentAccount.invest().
        //==================================================

    }

    /**
     * Transfers money between savings and investment accounts.
     */
    private void transferBetweenAccounts() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Transfer money between accounts.
        //
        // Requirements:
        // 1. Ask for transfer direction.
        // 2. Read transfer amount.
        // 3. Withdraw from the source account.
        // 4. Deposit into the destination account.
        //==================================================

    }

    /**
     * Withdraws every investment back into the investment account.
     */
    private void withdrawAllInvestments() {

        //==================================================
        // TODO (Eric Kamau)
        //
        // Objective:
        // Withdraw all investments.
        //
        // Requirements:
        // 1. Call withdrawAllInvestments() on the investment account.
        // 2. Do not print anything inside the model classes.
        //==================================================

    }

    //==================================================
    // Helper Methods
    //==================================================

    /**
     * Creates the predefined users.
     */
    private void initializeUsers() {

        String[] names = {
                "Alice",
                "Bob",
                "Charlie",
                "Diana"
        };

        for (String name : names) {
            users.put(name, new User(name));
        }
    }

    /**
     * Finds a user by name.
     *
     * @param name User's name.
     * @return Matching user or null.
     */
    private User findUser(String name) {
        return users.get(name);
    }

    /**
     * Reads a monetary amount from the user.
     *
     * @return Amount entered by the user.
     */
    private BigDecimal readAmount() {

        //==================================================
        // TODO (Abbie Gikunju)
        //
        // Objective:
        // Read a valid monetary amount.
        //
        // Requirements:
        // 1. Handle EOF gracefully.
        // 2. Reject invalid decimal numbers.
        // 3. Continue prompting until a valid amount is entered.
        // 4. Return the amount as a BigDecimal.
        //==================================================

        return BigDecimal.ZERO;
    }

}