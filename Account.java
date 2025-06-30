import java.util.ArrayList;
import java.util.List;

public class Account extends User {
    private String accountNumber;
    private String accountType;
    private double balance;
    private List<String> transactionHistory;

   
    public Account(String name, String phoneNumber, String email, String address, String accountNumber, String accountType) {
        super(name, phoneNumber, email, address); 
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

  
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }


    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}
