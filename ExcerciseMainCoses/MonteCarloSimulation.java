import java.util.concurrent.atomic.AtomicLong;
import java.util.Scanner;
public class MonteCarloSimulation {
  public static boolean inArea() {
    double x = 2 * Math.random() - 1;
    double y = 2 * Math.random() - 1;
    if ((x <= 0) || ((x + y <= 1) && x > 0 && y > 0)) {
      return true;
    } else return false;
  }

  public static void main(String[] args) {
    long COUNT = 1000000;
    long sum = 0;
    for (AtomicLong i = new AtomicLong(); COUNT > i.get(); i.getAndIncrement()) {
      if (inArea()) sum++;
    }
    System.out.print("Assume the side length of the square is 2.\n");
    System.out.print("The Monte Carlo estimated area is :");
    System.out.print((double) sum * 4 / (double) COUNT);
    System.out.printf("\nThe true area is: %f", (double) (5.0 / 8.0) * 4.0);
  }

}
