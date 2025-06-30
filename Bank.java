
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
        System.out.println("----------------------------------------");
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
        System.out.println("----------------------------------------");
        return account;

    }

    public void updateAccount(Account account1, Scanner sc) {
        System.out.println("select what you want to update");
        System.err.println("1 Name");
        System.err.println("2 phone no");
        System.err.println("3 Email");
        System.err.println("4 Address");
        System.err.println("5 Password");
        System.err.println("6 Exit");
        System.out.print("Enter your choice :- ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the updated name ");
                String name=sc.nextLine();
                account1.setName(name);
                System.out.println("Successfully updated");
            }
            case 2 -> {
                System.out.println("Enter the updated phone no ");
                String phone=sc.nextLine();
                account1.setPhoneNumber(phone);
                System.out.println("Successfully updated");
            }
            case 3 -> {
                System.out.println("Enter the updated email ");
                String email=sc.nextLine();
                account1.setEmail(email);
                System.out.println("Successfully updated");
            }
            case 4 -> {
                System.out.println("Enter the updated address ");
                String address=sc.nextLine();
                account1.setAddress(address);
                System.out.println("Successfully updated");
            }
            case 5 -> {
                System.out.println("Enter the updated password ");
                String password=sc.nextLine();
                account1.setPassword(password);
                System.out.println("Successfully updated");
            }
            case 6 -> {
                System.out.println("Exited without changes.");
                break;
            }

            default ->
            System.out.println("input a valid option  ") ;
        }

    }

    public void depositMoney(Account account1, Scanner sc) {
        System.out.println("Enter how much you want to deposit");
        double deposit = sc.nextDouble();
        if (deposit > 0 && deposit <= 1000000) {
            account1.setBalance(account1.getBalance() + deposit);
            account1.getTransactionHistory().add("Deposited ₹" + deposit);
            System.out.println("Deposit successfully ");
        } else {
            System.out.println("the amount should be greater then 0 and less then 1000000 ");
        }
        System.out.println("----------------------------------------");
    }

    public void withdrawMoney(Account account1, Scanner sc) {
        System.out.println("Enter the amount you want to withdraw: ");
        double withdraw = sc.nextDouble();
        sc.nextLine();
        if (withdraw > 0 && withdraw <= account1.getBalance()) {
            account1.setBalance(account1.getBalance() - withdraw);
            account1.getTransactionHistory().add("Withdrew ₹" + withdraw);
            System.out.println("Withdrawal successful! Remaining Balance: ₹" + account1.getBalance());
        } else {
            System.out.println("Invalid amount. It must be greater than 0 and less than or equal to your balance.");
        }
        System.out.println("----------------------------------------");
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
        System.out.println("----------------------------------------");
    }

    public void deleteAccount(Account account1) {
        if (account1 == null) {
            System.out.println("no account to delet ");
            return;
        }
        loginMapByUserId.remove(account1.getUserId());
        accountMapByAccNumber.remove(account1.getAccountNumber());
        System.out.println("You have successfully deleted the account ");
        System.out.println("----------------------------------------");

    }

    public void generateStatement(Account account1) {
        if (!account1.getTransactionHistory().isEmpty()) {
            System.err.println("all the treanscation ");
            {
                for (String str : account1.getTransactionHistory()) {
                    System.out.println("- " + str);
                }
            }
        } else {
            System.out.println("NO TRANSCATION TILL NOW ");
        }
        System.out.println("----------------------------------------");
    }

}
