public class temp {

  // 从左到右计算数列和
  public static double sumLeftToRight(int n) {
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    return sum;
  }

  // 从右到左计算数列和
  public static double sumRightToLeft(int n) {
    double sum = 0.0;
    for (int i = n; i >= 1; i--) {
      sum += 1.0 / i;
    }
    return sum;
  }

  public static void main(String[] args) {
    int n = 50000; // 取 n = 50000

    double sumLeftToRight = sumLeftToRight(n);
    double sumRightToLeft = sumRightToLeft(n);

    System.out.printf("从左到右计算的结果: %.15f%n", sumLeftToRight);
    System.out.printf("从右到左计算的结果: %.15f%n", sumRightToLeft);
    System.out.printf("两者的差异: %.15f%n", Math.abs(sumLeftToRight - sumRightToLeft));
  }
}
