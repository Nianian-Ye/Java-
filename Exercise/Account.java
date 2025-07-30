package Exercise;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Date;

public class Account{
  int id = 0;
  double balance = 0;
  double annualInterestRate =0;
  Date dateCreated;
//构造函数
  public Account(){
    dateCreated = new Date();
  }
  public Account(int newId, double newBalance) {
    id = newId;
    balance = newBalance;
    dateCreated = new Date();
  }

  //id, balance. annualinterestrate
  public int getId(){
    return id;
  }
  public void setId(int newId) {
    id = newId;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double newBalance) {
    balance = newBalance;
  }
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }
  public void setAnnualInterestRate(double newAnualInterestRate) {
    annualInterestRate = newAnualInterestRate;
  }

  //for test
  public void printInfo() {
    System.out.printf("\nAccount Information \nid: %d\nbalance: %f \nannual interest rate: %f\ncreated time: %s\n\n",id, balance, annualInterestRate,
      dateCreated);
  }
  public String toString() {
    return "\nAccount information\nid:" + id + " balance: " + balance + "\nannual interest rate: " + annualInterestRate + "\ncreated time: " + dateCreated ;
  }


  //date
  public Date getDateCreated() {
    return dateCreated;
  }

  //MonthlyInterestRate
  public double getMonthlyInterestRate() {
    double monthlRate = annualInterestRate/(12);
//    System.out.printf("monthly interest rate: %f\n", monthlRate);
    return monthlRate;
  }

  //withdraw & deposit
  public void withDraw(double amount) {
    if(amount>balance) {
      System.out.println("The balance is insufficient.");
      return ;
    }
    balance-=amount;
//    System.out.printf("Successful withdrawal %f\n", amount);
  }

  public void deposit(double amount) {
    balance += amount;
//    System.out.printf("Successful deposit %f\n",amount);
  }
};
