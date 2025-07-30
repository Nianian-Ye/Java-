package Exercise;

public class SavingAccount extends Account{
  public SavingAccount() {
    super();
  }
  public SavingAccount(int id, double balance) {
    super(id, balance);
  }
  @Override
  public void withDraw(double amount) {
    double balance = super.getBalance();
    if(balance < amount) {
      System.out.println("Failed withdraw! The balance is insufficient.");
    }
    else{
      super.withDraw(amount);
    }
  }
}
