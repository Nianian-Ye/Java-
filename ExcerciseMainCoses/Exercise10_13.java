import Exercise.MyRectangle2D;
public class Exercise10_13 {
  public static void main(String[] args) {
   MyRectangle2D r1 = new MyRectangle2D(2,2,5.5,4.9);
  double w = r1.getWidth();
  double h = r1.getWidth();
  System.out.printf("width: %f\nheight: %f\n", w, h );
  System.out.printf("contans(3,3)? %s\n", r1.contains(3,3) );
  System.out.printf("contains rectangle(4, 5,10.5, 3.2 )? %s\n",  r1.contains (new MyRectangle2D(4 ,5 ,10.5 ,3.2)) );
   System.out.printf("overlaps rectangle(3, 5, 2.3, 5.4)? %s\n", r1.overlaps (new
      MyRectangle2D(3,5, 2.3,5.4)) );
  }
}
