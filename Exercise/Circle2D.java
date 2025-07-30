package Exercise;

public class Circle2D {
  double x=0;
  double y=0;
  double radius = 1;
  public Circle2D(){}
  public Circle2D(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getX(){
    return x;
  }
  public double getY() {
    return y;
  }
  public double getRadius() {
    return radius;
  }
  public double getArea() {
    return Math.PI*Math.pow(radius, 2);
  }

  public double getPerimeter() {
    return Math.PI*radius*2;
  }


  public double distance(double x, double y){
    MyPoint p = new MyPoint(x, y);
    return p.distance(this.x, this.y);
  }

  public double distance(Circle2D myCircle) {
    MyPoint p = new MyPoint(myCircle.getX(), myCircle.getY());
    return p.distance(this.x, this.y);
  }

  public boolean  contains(double x, double y) {
    double d = distance(x,y);
    if(d<radius) return true;
    return false;
  }

  public boolean contains(Circle2D circle) {
    double d = distance(circle);
    if(d < radius-circle.radius) return true;
    return false;
  }

  public boolean overlaps(Circle2D circle) {
    double d = distance(circle);
    if(d >= radius - circle.radius && d <= radius + circle.radius) return true;
    return false;
  }

};
