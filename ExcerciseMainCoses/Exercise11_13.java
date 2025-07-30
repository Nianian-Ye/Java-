import java.util.ArrayList;
import java.util.Scanner;
public class Exercise11_13 {
  public static void removeDuplicate(ArrayList<Integer> list){
    ArrayList<Integer> listDepulicated = new ArrayList<>();
    for(int i: list) {
      if(!listDepulicated.contains(i)) listDepulicated.add(i);
    }
    list.clear();
    for(int i:listDepulicated){
      list.add(i);
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    System.out.print("Enter ten integers: ");

    for(int i=0; i<10;i++){
      list.add(input.nextInt());
    }
    removeDuplicate(list);
    System.out.print("\nThe distinct integers are ");
    for(int i : list){
      System.out.print(i + " ");
    }
  }
}
