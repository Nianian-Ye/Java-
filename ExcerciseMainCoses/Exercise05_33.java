//perfect number

import java.util.Scanner;

public class Exercise05_33 {
  public static int isPerfectNumber(int n) {
    int sum = 1;
    int sqrt_n = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt_n; i++) {
      if (n % i == 0) {
        sum += i;
        if (i != n / i)
          sum += n / i;
      }
    }

    if (sum == n && sum != 1) {
      return n;
    } else return 0;
  }

  public static void main(String[] args) {
    final int MAX = 10000;
    int result;
    for (int i = 2; i <= MAX; i++) {
      result = isPerfectNumber(i);
      if (result != 0) {
        System.out.println(result);
      }
    }
  }

}
