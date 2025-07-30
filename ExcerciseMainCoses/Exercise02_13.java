//compound interest calculation

import jdk.internal.cmm.SystemResourcePressureImpl;

import java.util.Scanner;

public class Exercise02_13 {
  public static void main(String[] args){
    final double MONTHLY_INTEREST = 0.00417;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the monthly saving amount: ");
    double saving;
    saving = input.nextDouble();
    double result = 0;
    for(int i=0; i<6; i++) {
       result = (saving+result)*(MONTHLY_INTEREST+1);
    }
    System.out.printf("After the sixth month , the account value is $%.2f", result);
  }
}
