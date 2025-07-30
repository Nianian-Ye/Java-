import java.util.*;
import java.util.Collection;

public class Exercise13_03 {
  public static void sort(ArrayList<Number> list) {
    Collections.sort(list, new Comparator<Number>(){
      public int compare(Number o1, Number o2) {
        return Double.compare(o1.doubleValue(), o2.doubleValue());
      }
    });
  }
  public static void main(String[] args) {
    ArrayList<Number> list = new ArrayList<>();
    list.add(3.4);
    list.add(9000);
    list.add(-390.2);
    sort(list);
    for(int i=0; i<list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
