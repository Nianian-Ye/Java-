package Exercise;
public class Fan {
  public static final int SLOW = 1;
  public static final int MEDIUM = 2;
  public static final int FAST = 3;
  int speed = SLOW;
  boolean on = false;
  double radius = 5;
  String color = "blue";

  public Fan(){};
  public Fan(int _speed , double _radius, String _color ,boolean _on  ) {
    speed = _speed;
    radius = _radius;
    color = _color;
    on = _on;
  }

  public void setSpeed(int _speed) {
    speed = _speed;
  }
  public int getSpeed() {
    return speed;
  }
  public void setRadius(double _radius) {
    radius = _radius;
  }
  public double getRadius() {
    return radius;
  }
  public void setOn(boolean _on) {
    on = _on;
  }
  public  boolean getOn() {
    return on;
  }
  public void setColor(String _color) {
    color = _color;
  }
  public String getColor() {
    return color;
  }

  public String toString(){
    if(on) return String.format("Speed: %d Color: %s Radius: %f\n",speed, color, radius);
    return String.format("fan is off\nColor: %s Radius: %f\n", color, radius);
  }
};

