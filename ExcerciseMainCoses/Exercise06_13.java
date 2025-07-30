import java.util.Scanner;

public class Exercise06_13 {
  public static double  getSeries( int endNumber){
    double value = 0;
    for(double i = 1; i<=(double)endNumber; i++){
      value += i/(i+1);
    }
    return value;
  }
  public static void main(String[] args){
    double value;
    System.out.printf("%-15s%s%n","i", "m(i)");
    System.out.print("--------------------------\n");
    for(int i=1; i<=20; i++){
      value = getSeries(i);
      System.out.printf("%-15d%.4f%n", i, value);
    }
    return;
  }
}
