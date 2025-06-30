
import java.util.HashMap;
import java.util.Scanner;

public class Bank {

    Account account;
    HashMap<String, Account> loginMapByUserId = new HashMap<>();
    HashMap<Long, Account> accountMapByAccNumber = new HashMap<>();

    public void createAccount(Scanner sc) {
        System.out.println("Enter your name ");
        String name = sc.nextLine();
        System.out.println("Enter your phone no");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter you email ");
        String email = sc.nextLine();
        System.out.println("Enter your address ");
        String address = sc.nextLine();
        System.out.println("Enter the account type eg:- savinng or current ");
        String accountType = sc.nextLine();
        System.out.println("Enter your user id");
        String userId = sc.nextLine();
        System.out.println("Enter you password ");
        String password = sc.nextLine();
        long accountNumber = 100000000L + (long) (Math.random() * 900000000L);

        account = new Account(userId, password, name, phoneNumber, email, address, accountNumber, accountType);
        accountMapByAccNumber.put(accountNumber, account);
        loginMapByUserId.put(userId, account);

    }

    public Account login(Scanner sc) {
        System.out.println("Enter the userID");
        String userId = sc.nextLine();
        System.out.println("Enter you password ");
        String password = sc.nextLine();
        if (!loginMapByUserId.containsKey(userId)) {
            System.out.println(" User ID not found.");
            return null;
        }
        Account account = loginMapByUserId.get(userId);

        if (!account.getPassword().equals(password)) {
            System.out.println(" Incorrect password ");
            return null;
        }
        System.out.println(" Login successful! Welcome " + account.getName());
        return account;

    }

    public void updateAccount(Account account1, Scanner sc) {

    }

    public void depositMoney(Account account1, Scanner sc) {
        System.out.println("Enter how much you want to deposit");
        double deposit = sc.nextDouble();
        if (deposit > 0 && deposit <= 1000000) {
            account1.setBalance(account1.getBalance() + deposit);
            System.out.println("Deposit successfully ");
        } else {
            System.out.println("the amount should be greater then 0 and less then 1000000 ");
        }

    }

    public void withdrawMoney(Account account1, Scanner sc) {
        System.out.println("Enter the amount you want to withdraw: ");
        double withdraw = sc.nextDouble();
        sc.nextLine();
        if (withdraw > 0 && withdraw <= account1.getBalance()) {
            account1.setBalance(account1.getBalance() - withdraw);
            System.out.println("Withdrawal successful! Remaining Balance: ₹" + account1.getBalance());
        } else {
            System.out.println("Invalid amount. It must be greater than 0 and less than or equal to your balance.");
        }
    }

    public void displayAccount(Account account1) {
        System.out.println("----------- Account Details -----------");
        System.out.println("Name: " + account1.getName());
        System.out.println("Phone Number: " + account1.getPhoneNumber());
        System.out.println("Email: " + account1.getEmail());
        System.out.println("Address: " + account1.getAddress());
        System.out.println("User ID: " + account1.getUserId());
        System.out.println("Account Number: " + account1.getAccountNumber());
        System.out.println("Account Type: " + account1.getAccountType());
        System.out.println("Current Balance: ₹" + account1.getBalance());
    }

    public void deleteAccount(Account account1) {

    }

    public void generateStatement(Account account1) {

    }

}
