package service;

import exception.InvalidAmountException;
import model.Fund;
import model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** Handles application flow, user sessions, and banking operations. */
public class BankingService {

    private final Scanner scanner;
    private final Map<String, User> users;
    private User currentUser;
    private boolean running;

    /** Creates the banking service and its predefined users. */
    public BankingService() {
        scanner = new Scanner(System.in);
        users = new HashMap<>();
        currentUser = null;
        running = true;
        initializeUsers();
    }

    /** Starts the interactive banking application. */
    public void start() {
        System.out.println("Welcome to Green Day Bank!");
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
        System.out.println("Thank you for banking with Green Day Bank.");
    }

    private void login() {
        System.out.print("Enter your name (Alice, Bob, Charlie, or Diana): ");
        if (!scanner.hasNextLine()) {
            running = false;
            return;
        }
        User user = findUser(scanner.nextLine().trim());
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
        while (running) {
            System.out.print("Choose an option: ");
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
                // The message below covers empty and non-numeric input too.
            }
            System.out.println("Please enter a number from 1 to 9.");
        }
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
                break;
            default:
                throw new IllegalArgumentException("Unexpected menu choice: " + choice);
        }
    }

    private void showBalance() {
        try {
            currentUser.getSavingsAccount().applyInterest();
        } catch (InvalidAmountException exception) {
            System.out.println("Could not apply savings interest: " + exception.getMessage());
            return;
        }
        currentUser.getInvestmentAccount().applyGrowth();

        System.out.println();
        System.out.println("--- " + currentUser.getName() + "'s balances ---");
        System.out.println("Cash: " + formatMoney(currentUser.getCash()));
        System.out.println("Savings: " + formatMoney(currentUser.getSavingsAccount().getBalance()));
        System.out.println("Investment account: "
                + formatMoney(currentUser.getInvestmentAccount().getBalance()));
        System.out.println("Investments:");
        if (currentUser.getInvestmentAccount().getInvestments().isEmpty()) {
            System.out.println("  None");
            return;
        }
        for (Map.Entry<Fund, BigDecimal> entry
                : currentUser.getInvestmentAccount().getInvestments().entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + formatMoney(entry.getValue()));
        }
    }

    private void depositMoney() {
        BigDecimal amount = readAmount();
        if (amount == null) {
            return;
        }
        if (currentUser.getCash().compareTo(amount) < 0) {
            System.out.println("Insufficient cash.");
            return;
        }
        try {
            currentUser.getSavingsAccount().deposit(amount);
            currentUser.setCash(currentUser.getCash().subtract(amount));
            System.out.println("Deposited " + formatMoney(amount) + " into savings.");
        } catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void withdrawMoney() {
        BigDecimal amount = readAmount();
        if (amount == null) {
            return;
        }
        try {
            currentUser.getSavingsAccount().withdraw(amount);
            currentUser.setCash(currentUser.getCash().add(amount));
            System.out.println("Withdrew " + formatMoney(amount) + " from savings.");
        } catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void sendMoney() {
        System.out.print("Enter the recipient's name: ");
        if (!scanner.hasNextLine()) {
            running = false;
            return;
        }
        User recipient = findUser(scanner.nextLine().trim());
        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }
        if (recipient == currentUser) {
            System.out.println("You cannot send money to yourself.");
            return;
        }

        BigDecimal amount = readAmount();
        if (amount == null) {
            return;
        }
        try {
            currentUser.getSavingsAccount().withdraw(amount);
            recipient.getSavingsAccount().deposit(amount);
            System.out.println("Sent " + formatMoney(amount) + " to " + recipient.getName() + ".");
        } catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void investMoney() {
        System.out.println("Available funds:");
        for (Fund fund : Fund.values()) {
            String percentage = fund.getGrowthRate().movePointRight(2)
                    .stripTrailingZeros().toPlainString();
            System.out.println("  " + fund + " (" + percentage + "% growth)");
        }
        System.out.print("Choose a fund: ");
        if (!scanner.hasNextLine()) {
            running = false;
            return;
        }
        Fund fund;
        try {
            fund = Fund.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid fund. Please choose one of the listed funds.");
            return;
        }

        BigDecimal amount = readAmount();
        if (amount == null) {
            return;
        }
        try {
            currentUser.getInvestmentAccount().invest(fund, amount);
            System.out.println("Invested " + formatMoney(amount) + " in " + fund + ".");
        } catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void transferBetweenAccounts() {
        System.out.println("1. Savings to investment account");
        System.out.println("2. Investment account to savings");
        System.out.print("Choose a transfer direction: ");
        if (!scanner.hasNextLine()) {
            running = false;
            return;
        }
        String direction = scanner.nextLine().trim();
        if (!direction.equals("1") && !direction.equals("2")) {
            System.out.println("Please enter 1 or 2.");
            return;
        }

        BigDecimal amount = readAmount();
        if (amount == null) {
            return;
        }
        try {
            if (direction.equals("1")) {
                currentUser.getSavingsAccount().withdraw(amount);
                currentUser.getInvestmentAccount().deposit(amount);
            } else {
                currentUser.getInvestmentAccount().withdraw(amount);
                currentUser.getSavingsAccount().deposit(amount);
            }
            System.out.println("Transferred " + formatMoney(amount) + ".");
        } catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void withdrawAllInvestments() {
        if (currentUser.getInvestmentAccount().getInvestments().isEmpty()) {
            System.out.println("You have no investments to withdraw.");
            return;
        }
        currentUser.getInvestmentAccount().withdrawAllInvestments();
        System.out.println("All investments have been moved to your investment account.");
    }

    private void initializeUsers() {
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};
        for (String name : names) {
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

    private BigDecimal readAmount() {
        while (running) {
            System.out.print("Enter an amount: ");
            if (!scanner.hasNextLine()) {
                running = false;
                return null;
            }
            try {
                BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    return amount;
                }
            } catch (NumberFormatException ignored) {
                // The message below covers invalid decimal input too.
            }
            System.out.println("Please enter an amount greater than zero.");
        }
        return null;
    }

    private String formatMoney(BigDecimal amount) {
        return "$" + amount.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
