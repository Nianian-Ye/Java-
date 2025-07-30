import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Exercise06_22 {
  public static double sqrt(long n) {
    double nextGuess = 2;
    double lastGuess = 1;
    double difference = 1;
    while (Math.abs(difference) >= 1e-4) {
      nextGuess = (lastGuess + (double)n / lastGuess) / 2;
      difference = Math.abs(nextGuess - lastGuess);
      lastGuess = nextGuess;

    }
    return nextGuess;
  }

  public static void main(String[] args) {
    long testNumber;
    double testResult;
    Scanner input = new Scanner(System.in);
    System.out.print("Please input a positive integer :");
    testNumber = input.nextLong();
    testResult = sqrt(testNumber);
    System.out.printf("The result for  sqrt(%d)  is : %f", testNumber, testResult);

  }
}
