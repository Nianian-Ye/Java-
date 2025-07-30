import Exercise.Geometric;
import Exercise.Triangle;
import java.util.Scanner;
public class Exercise11_01 {
  public static void main(String[] args) {
    Geometric triangle ;
    double side1, side2, side3;
    String color;
    boolean filled;
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the first side: ");
    side1 = input.nextDouble();
    System.out.println("Please enter the second side: ");
    side2 = input.nextDouble();
    System.out.println("Please enter the third side: ");
    side3 = input.nextDouble();
    System.out.println("Please enter color: ");
    color = input.next();
    System.out.println("is it filled? (enter false or true) ");
    filled = input.hasNext();
    triangle = new Geometric(side1, side2, side3, color, filled);
    triangle.display();
  }
}
