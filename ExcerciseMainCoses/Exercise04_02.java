//Calculate the maximum circle distance

import java.util.Scanner;


public class Exercise04_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    final double EARTH_RADIUS = 6371.01;

    System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
    double latitude1 = Math.toRadians(input.nextDouble());
    double longitude1 = Math.toRadians(input.nextDouble());
    System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
    double latitude2 = Math.toRadians(input.nextDouble());
    double longitude2 = Math.toRadians(input.nextDouble());
    double distance = EARTH_RADIUS * Math.acos(Math.sin(latitude1) * Math.sin(latitude2) +
      Math.cos(longitude1) * Math.cos(longitude2) * Math.cos(longitude1 - longitude2)
    );
    System.out.printf("The distance between the two points is %f km", distance);

  }
}
