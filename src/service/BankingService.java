package service;

import exception.InvalidAmountException;
import model.Fund;
import model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** Coordinates the command-line banking application. */
public class BankingService {

    private final Scanner scanner;
    private final Map<String, User> users;
    private User currentUser;
    private boolean running;

    public BankingService() {
        scanner = new Scanner(System.in);
        users = new HashMap<>();
        currentUser = null;
        running = true;
        initializeUsers();
    }

    /** Runs the login and menu loops until the user exits or input ends. */
    public void start() {
        while (running) {
            if (currentUser == null) {
                login();
            } else {
                displayMenu();
                int choice = readMenuChoice();
                if (choice != -1) {
                    processMenuChoice(choice);
                }
            }
        }
    }

    private void login() {
        System.out.print("Enter your name to login: ");
        if (!scanner.hasNextLine()) {
            running = false;
            return;
        }

        User user = findUser(scanner.nextLine());
        if (user == null) {
            System.out.println("User not found. Please try again.");
            return;
        }

        currentUser = user;
        System.out.println("Welcome, " + currentUser.getName() + "!");
    }

    private void logout() {
        currentUser = null;
    }

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

    private int readMenuChoice() {
        System.out.print("Enter your choice: ");
        if (!scanner.hasNextLine()) {
            running = false;
            return -1;
        }

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice >= 1 && choice <= 9) {
                return choice;
            }
        } catch (NumberFormatException ignored) {
            // Invalid input is handled below.
        }
        System.out.println("Invalid choice. Please try again.");
        return -1;
    }

    private void processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                showBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                sendMoney();
                break;
            case 5:
                investMoney();
                break;
            case 6:
                transferBetweenAccounts();
                break;
            case 7:
                withdrawAllInvestments();
                break;
            case 8:
                logout();
                System.out.println("You have been logged out.");
                break;
            case 9:
                running = false;
                System.out.println("Thank you for using our banking app. Goodbye!");
                break;
            default:
                break;
        }
    }

    private void showBalance() {
        try {
            currentUser.getSavingsAccount().applyInterest();
        } catch (InvalidAmountException exception) {
            return;
        }
        currentUser.getInvestmentAccount().applyGrowth();

        System.out.println("Savings account balance: "
                + formatMoney(currentUser.getSavingsAccount().getBalance()));
        System.out.println("Investment account balance:");
        System.out.println("* Not Invested: "
                + formatMoney(currentUser.getInvestmentAccount().getBalance()));
        for (Fund fund : Fund.values()) {
            BigDecimal amount = currentUser.getInvestmentAccount()
                    .getInvestments().getOrDefault(fund, BigDecimal.ZERO);
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                System.out.println("* " + fund + ": " + formatMoney(amount));
            }
        }
    }

    private void depositMoney() {
        BigDecimal amount = readAmount("Enter amount to deposit to savings account: $");
        if (amount == null) {
            return;
        }
        if (currentUser.getCash().compareTo(amount) < 0) {
            System.out.println("Deposit failed: Insufficient cash on hand");
            return;
        }
        try {
            currentUser.getSavingsAccount().deposit(amount);
            currentUser.setCash(currentUser.getCash().subtract(amount));
            System.out.println("Deposit successful.");
        } catch (InvalidAmountException exception) {
            System.out.println("Deposit failed: " + exception.getMessage());
        }
    }

    private void withdrawMoney() {
        BigDecimal amount = readAmount("Enter amount to withdraw from savings account: $");
        if (amount == null) {
            return;
        }
        try {
            currentUser.getSavingsAccount().withdraw(amount);
            currentUser.setCash(currentUser.getCash().add(amount));
            System.out.println("Withdrawal successful.");
        } catch (InvalidAmountException exception) {
            System.out.println("Withdrawal failed: " + exception.getMessage());
        }
    }

    private void sendMoney() {
        System.out.println("Available recipients:");
        for (String name : new String[] {"Alice", "Bob", "Charlie", "Diana"}) {
            if (!name.equalsIgnoreCase(currentUser.getName())) {
                System.out.println(name);
            }
        }
        System.out.print("Enter recipient's name: ");
        if (!scanner.hasNextLine()) {
            running = false;
            return;
        }
        User recipient = findUser(scanner.nextLine());
        if (recipient == null || recipient == currentUser) {
            System.out.println("Invalid recipient.");
            return;
        }

        BigDecimal amount = readAmount("Enter amount to send: $");
        if (amount == null) {
            return;
        }
        try {
            currentUser.getSavingsAccount().withdraw(amount);
            recipient.getSavingsAccount().deposit(amount);
            System.out.println("Sent " + formatInputAmount(amount) + " to " + recipient.getName());
        } catch (InvalidAmountException exception) {
            System.out.println("Failed to send money: " + exception.getMessage());
        }
    }

    private void investMoney() {
        System.out.println("Available funds:");
        System.out.println("LOW_RISK");
        System.out.println("MEDIUM_RISK");
        System.out.println("HIGH_RISK");
        System.out.print("Enter fund to invest in: ");
        if (!scanner.hasNextLine()) {
            return;
        }

        Fund fund = parseFund(scanner.nextLine());
        if (fund == null) {
            System.out.println("Invalid fund.");
            return;
        }

        BigDecimal amount = readAmount("Enter amount to invest: $");
        if (amount == null) {
            return;
        }
        try {
            currentUser.getInvestmentAccount().invest(fund, amount);
            System.out.println("Successfully invested " + formatInputAmount(amount)
                    + " in " + fund + " fund");
        } catch (InvalidAmountException exception) {
            System.out.println("Failed to invest: " + exception.getMessage());
        }
    }

    private void transferBetweenAccounts() {
        System.out.println("1. Transfer from savings to investment");
        System.out.println("2. Transfer from investment to savings");
        System.out.print("Enter your choice: ");
        if (!scanner.hasNextLine()) {
            return;
        }
        String direction = scanner.nextLine().trim();

        BigDecimal amount = readAmount("Enter amount to transfer: $");
        if (amount == null) {
            return;
        }
        try {
            if (direction.equals("1")) {
                currentUser.getSavingsAccount().withdraw(amount);
                currentUser.getInvestmentAccount().deposit(amount);
                System.out.println("Successfully transferred " + formatInputAmount(amount)
                        + " to investment account.");
            } else if (direction.equals("2")) {
                currentUser.getInvestmentAccount().withdraw(amount);
                currentUser.getSavingsAccount().deposit(amount);
                System.out.println("Successfully transferred " + formatInputAmount(amount)
                        + " to savings account.");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (InvalidAmountException exception) {
            System.out.println("Transfer failed: " + exception.getMessage());
        }
    }

    private void withdrawAllInvestments() {
        currentUser.getInvestmentAccount().withdrawAllInvestments();
        System.out.println("All investments have been withdrawn and added to your investment account balance.");
    }

    private void initializeUsers() {
        for (String name : new String[] {"Alice", "Bob", "Charlie", "Diana"}) {
            users.put(name, new User(name));
        }
    }

    private User findUser(String name) {
        if (name == null) {
            return null;
        }
        for (Map.Entry<String, User> entry : users.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name.trim())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private BigDecimal readAmount(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            return null;
        }
        try {
            return new BigDecimal(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private Fund parseFund(String input) {
        String value = input.trim().toUpperCase();
        if (value.equals("LOW_RISK")) {
            return Fund.LOW_RISK;
        }
        if (value.equals("MEDIUM_RISK")) {
            return Fund.MEDIUM_RISK;
        }
        if (value.equals("HIGH_RISK")) {
            return Fund.HIGH_RISK;
        }
        return null;
    }

    private String formatMoney(BigDecimal amount) {
        return "$" + amount.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    private String formatInputAmount(BigDecimal amount) {
        return "$" + amount.stripTrailingZeros().toPlainString();
    }
}
