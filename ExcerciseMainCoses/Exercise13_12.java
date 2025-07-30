import Exercise.Geometric;
import Exercise.GeometricObject;
import Exercise.Circle;
import Exercise.Rectangle;

public class Exercise13_12 {
  public static double sumArea(GeometricObject[] a){
    double areaSum = 0;
    double diameterSum = 0;
    for(GeometricObject g : a){
      areaSum += g.getArea();
      if (g instanceof Circle) {
        diameterSum += ((Circle) g).getRadius()*2;
      }
    }
    System.out.println("Area sum: "+areaSum);
    System.out.println("Diameter sum: " + diameterSum);
    return areaSum;
  }
  public static void main(String[] args){
    GeometricObject[] a = {new Rectangle(2,3),new Rectangle(4, 6), new Circle(3), new Circle(1)};
    sumArea(a);
  }
}
