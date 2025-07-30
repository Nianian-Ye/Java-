//Find the sum of each digit of an integer

import java.util.Scanner;

public class Exercise02_06 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number between 0 and 1000: ");
    int integer = input.nextInt();
    int result = 0;
    while (integer > 0) {
      result += integer % 10;
      integer /= 10;
    }
    System.out.printf("The sum of the digits is %d", result);

  }
}
