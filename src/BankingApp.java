import service.BankingService;

/**
 * Green Day Bank
 *
 * BankingApp.java
 *
 * Entry point of the application.
 */
public class BankingApp {

    /**
     * Starts the banking application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        bankingService.start();

    }

}