import java.util.Scanner;
import Exercise.Account;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

public class Exercise10_07 {
  Account[] account = new Account[10];

  public Exercise10_07() {
    double balance = 100;
    for (int i = 0; i < 10; i++) {
      account[i] = new Account(i, balance);
    }
  }

  public double getBalance(int id) {
    return account[id].getBalance();
  }

  public void withdraw(int id, double amount) {
    account[id].withDraw(amount);
  }

  public void deposit(int id, double amount) {
    account[id].deposit(amount);
  }


  public static void main(String[] args) {
    Exercise10_07 accountArray = new Exercise10_07();
    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.print("\nEnter an id:");
      int id = input.nextInt();
      if (id >= 0 && id <= 9) {
        int choice = 0;

        while (choice != 4) {
          System.out.println("\nMain menu");
          System.out.println("1: check balance");
          System.out.println("2: withdraw");
          System.out.println("3: deposit");
          System.out.println("4: exit");
          System.out.print("Enter a choice: ");
          choice = input.nextInt();
          switch (choice) {
            case 1: {
              double balance = accountArray.getBalance(id);
              System.out.printf("The balance is: %f", balance);
              break;
            }
            case 2: {
              double amount;
              System.out.print("Enter an amount to withdraw: ");
              amount = input.nextDouble();
              accountArray.withdraw(id, amount);
              break;
            }
            case 3: {
              double amount;
              System.out.print("Enter an amount to deposit: ");
              amount = input.nextDouble();
              accountArray.deposit(id, amount);
              break;
            }
            case 4: {
              break;
            }
          }

        }
      }

    }

  }
}