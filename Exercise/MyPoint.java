package Exercise;

public class MyPoint{
  double x;
  double y;
  public MyPoint(){}
  public MyPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }

  public double distance(MyPoint point) {
    double distance = Math.pow(Math.pow(point.getX()-x,2) + Math.pow(point.getY()-y, 2), 0.5);
    return distance;
  }

  public double distance(double x, double y) {
    double distance = Math.pow(Math.pow(this.x-x,2) + Math.pow(this.y-y, 2),0.5);
    return distance;
  }

  public static double distance(MyPoint point1, MyPoint point2) {
    double distance =Math.pow( Math.pow(point1.getX()-point2.getX(), 2) + Math.pow(point1.getY() -point2.getY(), 2),0.5);
    return distance;
  }

};