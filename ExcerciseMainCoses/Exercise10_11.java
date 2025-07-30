import Exercise.Account;
import  Exercise.Circle2D;
public class Exercise10_11 {
  public  static  void main(String[] args) {
    Circle2D c1 = new Circle2D(2,2,5.5);
    double perimeter = c1.getPerimeter();
    double area = c1.getArea();
    System.out.printf("Perimeter: %f\nArea: %f\n\n", perimeter, area);
    boolean b1;
    b1 = c1.contains(3,3);
    System.out.printf("c1 contains (3,3)?\n%b\n",b1);
    boolean b2 = c1.contains(new Circle2D(4,5,10.5));
    System.out.printf("c1 contains Cirecle2D(4, 5, 10.5)? \n%s\n", b2);
    boolean b3 = c1.overlaps(new Circle2D(3, 5, 2.3));
    System.out.printf("c1 overlaps Circle2D(3, 5, 2.3)? \n%b\n", b3);

  }
};
