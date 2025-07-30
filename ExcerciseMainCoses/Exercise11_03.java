import Exercise.SavingAccount;
import Exercise.CheckingAccount;
import Exercise.Account;
public class Exercise11_03 {
  public static void main(String[] args) {
    Account account = new Account(123456, 500);
    CheckingAccount checkingAccount = new CheckingAccount(654321, 300, 100);
    SavingAccount savingAccount = new SavingAccount(234561, 600);
    String accountStr = account.toString();
    String checkingAccountStr = checkingAccount.toString();
    String savingAccountStr = savingAccount.toString();
    System.out.println(accountStr);

    System.out.println(checkingAccountStr);
    System.out.println(savingAccountStr);

  }
}
