
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        LogicHandling LG = new LogicHandling();
        System.out.println("------------------Bank Menu------------------");
        LG.loopLogic();
    }
}

class LogicHandling {

    Bank b = new Bank();
    Scanner sc = new Scanner(System.in);

    void loopLogic() {

        try {

            for (;;) {

                System.out.println(" --Select the operation yo want to perform-- ");
                System.out.println("         1 if you want to create account ");
                System.out.println("         2 if you want to deposit money ");
                System.out.println("         3 if you want to withdraw money ");
                System.out.println("         4 if you want to update account ");
                System.out.println("         5 if you want to display account  ");
                System.out.println("         6 if you want to delete account ");
                System.out.println("         7 if you want to generate statement ");
                System.out.println("         8 if you want to terminate the session ");
                System.out.print("         Enter the number :- ");
                int selectCase = sc.nextInt();
                System.out.println("");
                if (selectCase == 8) {
                    System.out.println("       You terminated the session.");
                    System.out.println("");
                    break;
                }
                if (selectCase >= 1 && selectCase <= 7) {

                    System.out.println("");

                    switch (selectCase) {
                        case 1 ->
                            b.createAccount(sc);
                        case 2 ->
                            b.depositMoney();
                        case 3 ->
                            b.withdrawMoney();
                        case 4 ->
                            b.updateAccount();
                        case 5 ->
                            b.displayAccount();
                        case 6 ->
                            b.deleteAccount();
                        case 7 ->
                            b.generateStatement();
                        default ->
                            System.out.println("Illegal value chosen between 1 to 5 ");
                    }
                } else if (selectCase < 1 || selectCase > 8) {
                    System.out.println("      Illegal value. Re-enter the value ");
                    System.out.println("");
                }

            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("You entered something illegal, so the whole session was terminated ");
            System.out.println("");
        }
        sc.close();
    }
    
}
