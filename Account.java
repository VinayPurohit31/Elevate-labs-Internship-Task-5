
import java.util.ArrayList;
import java.util.List;

public class Account extends User {

    private String userId;
    private String password;
    private long accountNumber;
    private String accountType;
    private double balance;
    private List<String> transactionHistory;

    public Account(String userId, String password, String name, String phoneNumber, String email, String address,long accountNumber, String accountType) {
        super(name, phoneNumber, email, address);
        this.userId = userId;
        this.password = password;
        this.accountNumber=accountNumber;
        this.accountNumber = 100000000L + (long)(Math.random() * 900000000L);
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public long  getAccountNumber() {
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public void setAccountNumber(long  accountNumber) {
        this.accountNumber = accountNumber;
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
