
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        LogicHandling LG = new LogicHandling();
        System.out.println("------------------Bank Menu------------------");
        LG.loopLogic();
    }
}

class LogicHandling {

    Bank bank = new Bank();
    Scanner sc = new Scanner(System.in);

    void loopLogic() {
        while (true) {
            System.out.println("\n---------- Bank Menu ----------");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine(); 

            switch (mainChoice) {
                case 1 -> bank.createAccount(sc);
                case 2 -> {
                    Account loggedInAccount = bank.login(sc);
                    if (loggedInAccount != null) {
                        loggedInMenu(loggedInAccount);
                    } else {
                        System.out.println("Login failed. Please try again.");
                    }
                }
                case 3 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void loggedInMenu(Account account) {
        while (true) {
            System.out.println("\n-- Logged In as: " + account.getUserId() + " --");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Update Account");
            System.out.println("4. Display Account");
            System.out.println("5. Generate Statement");
            System.out.println("6. Delete Account");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bank.depositMoney(account, sc);
                case 2 -> bank.withdrawMoney(account, sc);
                case 3 -> bank.updateAccount(account, sc);
                case 4 -> bank.displayAccount(account);
                case 5 -> bank.generateStatement(account);
                case 6 -> {
                    bank.deleteAccount(account);
                    return;
                }
                case 7 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
