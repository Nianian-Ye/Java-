package Exercise;

public class MyRectangle2D {
  double x=0;
  double y=0;
  double width = 1;
  double height = 1;
  public MyRectangle2D(){}
  public MyRectangle2D(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }
  public void setX(double x) {
    this.x = x;
  }
  public void setY(double y) {
    this.y = y;
  }
  public void setWeight(double width) {
    this.width = width;
  }
  public void setHeight(double height) {
    this.height = height;
  }
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }
  public double getWidth() {
    return width;
  }
  public double getHeight() {
    return height;
  }
  public double getArea() {
    return width * height;
  }
  public double getPerimeter() {
    return 2 * width * height ;
  }

  public boolean contains(double x, double y) {
    if(x>this.x + width/2 || x < this.x - width /2) return false;
    if(y > this.y + height / 2 || y < this.y - height/2) return false;
    return true;
  }
  public boolean contains(MyRectangle2D r) {
    double up = r.getY()+r.getHeight()/2;
    double down = r.getY()-r.getHeight()/2;
    double left = r.getX() + r.getWidth()/2;
    double right = r.getY() - r.getWidth()/2;
    double upBound = y+height/2;
    double downBound = y - height / 2;
    double leftBound = x - width / 2;
    double rightBound = x + width / 2;
    if(left <  leftBound || right > rightBound || up > upBound || down < downBound) {
      return false;
    }
    return true;
  }
  public boolean overlaps(MyRectangle2D r) {
    double x1 = x - width/2;
    double y1 = y + height/2;
    double x2 = x + width /2;
    double y2 = y - height / 2;
    double up = r.getY()+r.getHeight()/2;
    double down = r.getY()-r.getHeight()/2;
    double left = r.getX() + r.getWidth()/2;
    double right = r.getY() - r.getWidth()/2;
    double rX1 = left;
    double rY1 = up;
    double rX2 = right;
    double rY2 = down;
    if(rX2 < x1 || rX1 > x2 || rY1 < y2 || rY2 > y1) {
      return false;
    }
    return true;
  }

}
