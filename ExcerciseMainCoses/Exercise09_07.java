import java.util.Date;
import Exercise.Account;
public class Exercise09_07 {
  public static void main(String args[]) {
    Account acco = new Account(1122, 20000);
    acco.setAnnualInterestRate(0.045);
    acco.printInfo();
    acco.withDraw(2500);
    acco.deposit(3000);
    acco.printInfo();
    acco.getMonthlyInterestRate();

  }

};
