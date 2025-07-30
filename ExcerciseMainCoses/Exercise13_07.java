import Exercise.GeometricObject;
import Exercise.Circle;
import Exercise.Rectangle;
import Exercise.Colorable;

public class Exercise13_07 {
  public static void main(String[] args) {
    GeometricObject[] a = {new Circle(2), new Rectangle(2,3), new Rectangle(5, 8), new Square(), new Square(7)};

    for(GeometricObject g : a) {
      if(g instanceof Colorable) ((Colorable) g).howToColor();
    }
  }
};
class Square extends GeometricObject implements Colorable {
  double side=0;
  public Square(double side) {
    this.side = side;
  }
  public Square() {}

  public double getArea(){
    return side*side;
  }
  public void howToColor() {
    System.out.println("Color all four sides");
  }

};