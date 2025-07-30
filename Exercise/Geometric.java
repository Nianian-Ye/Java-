package Exercise;

public class Geometric {
  Triangle t;
  String color;
  boolean filled;
  public Geometric(double side1, double side2, double side3,String color, boolean filled ) {
    t = new Triangle(side1, side2, side3);
    this.color = color;
    this.filled = filled;
  }
  public void  display() {
    double area = t.getArea();
    double perimeter = t.getPerimeter();
    String sideDescribe = t.toString();
    System.out.println(sideDescribe);
    System.out.printf("area = %f perimeter = %f \n", area, perimeter);
    System.out.printf("color : %s filled : %s", color, filled);
  }

}
