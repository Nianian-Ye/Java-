package Exercise;
import java.util.Scanner;

public class Rectangle extends GeometricObject {
  double height = 1;
  double width = 1;
  public Rectangle(){}
  public Rectangle(double weight, double height) {
    this.width = weight;
    this.height = height;
  }
  public double getArea(){
    return width * height ;
  }
  public double getPerimeter(){
    return (width + height) * 2;
  }
  public void display(){
    System.out.println("Rectangle information");
    System.out.printf("width: %f, height: %f\n", width, height);
    System.out.printf("Area: %f\nPerimeter: %f\n\n", getArea(), getPerimeter());
  }
};
