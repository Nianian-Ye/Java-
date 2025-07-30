package Exercise;
import java.util.Date;
public class CheckingAccount extends Account {
  private double  overdraftLimit;
  public CheckingAccount() {
    super();
    overdraftLimit = 100;
  }

  public CheckingAccount(int id, double balance, double overdraftLimit) {
    super(id, balance);
    this.overdraftLimit = overdraftLimit;
  }
  public void  setOverdraftLimit(double limit) {
    overdraftLimit = limit;
  }
  public double getOverdraftLimit() {
    return overdraftLimit;
  }
  @Override
  public void withDraw(double amount)  {
    double balance = super.getBalance();
    if(Math.abs(balance - amount ) > overdraftLimit) {
      System.out.println("Failed withdraw! Overdraft limit exceeded.");
    }
    else{
      super.withDraw(amount);
//      super.setBalance(balance - amount);
//      System.out.println("Successfully withdrew");
    }
  }
  @Override
  public String toString() {
    return super.toString() + "\noverdraft limit: " + overdraftLimit;
  }

}
