package Exercise;

public class Circle extends GeometricObject {
  double radius;
  public Circle(int radius) {
    this.radius = radius;
  }
  public void setRadius(double radius){
    this.radius = radius;
  }
  public double getArea(){
    return Math.PI*radius*radius;
  }
  public double getRadius() {
    return radius;
  }

}
