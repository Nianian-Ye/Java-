import java.util.Scanner;

public class Exercise05_23 {
  public static double rightToLeft(){
    double n = 50000.0;
    double ssum = 0;
    while(n>0){
      ssum+=1.0/n;
      n = n-1;
    }
    return ssum;
  }

  public static double leftToRight(){
    double n = 1;
    double ssum = 0;
    while(n<=50000.0) {
      ssum += 1.0 / n;
      n++;
    }
    return ssum;
  }

  public static void main(String[] args){
    double resultRToL = rightToLeft();
    double resultLToR = leftToRight();
    System.out.printf("The result of adding from right to left is: %.15f\n",resultRToL);
    System.out.printf("The result of adding from left to right is: %.15f\n" , resultLToR);
    return ;
  }

}
