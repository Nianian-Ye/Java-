///*
//父类中定义的被override的方法，例如getArea方法，并不是真的能获得任意几何体面积，
//只是定义了一个模板，具体的实现还是子类中完成，
//父类中也无法完成，因为压根不知道需要求什么几何体的面积，
//但这种处理方式，就比方法重载之类要更灵活，也不需要修改主体框架代码。
//*/
//public class TestPoly {
//  public void getArea() {
//    System.out.println("得到几何体的面积");
//  }
//  public static void main(String[] args) {
//    GeometricObject g = new Circle(2);
//    g.getArea();
//    printArea(g);//或者封装为方法
//    printArea(new myDemo.Rectangle(2,3));
//  }
//  public static void printArea(GeometricObject g) {
//    g.getArea();
//  }
//
//}
//abstract class  GeometricObject {
//  protected GeometricObject(){};
//  public abstract void getArea();
//}
//
//class Circle extends GeometricObject {
//  private double radius=0;
//  public Circle(double radius) {
//    this.radius = radius;
//  }
//  public void getArea() {
//    System.out.println("得到圆的面积为："+ 3.1415*radius*radius);
//  }
//}
//
//class Rectangle extends GeometricObject {
//  private double width = 0;
//  private double height = 0;
//  public Rectangle(double width, double height) {
//    this.width = width;
//    this.height = height;
//  }
//  public void getArea() {
//    System.out.println("得到矩形的面积为："+width*height);
//  }
//}