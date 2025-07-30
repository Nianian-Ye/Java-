import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise12_02 {
  public static int getInteger() {
    Scanner input = new Scanner(System.in);
    int a=0;
    boolean flag=true;
    do{
      try{
        System.out.print("Please enter an integer\n");
        a = input.nextInt();
        flag = false;
      }
      catch(InputMismatchException ex){
        System.out.println("InputMismatchERROR");
        input.nextLine();
      }
    }while(flag);
    return a;
  }
  public static void main(String[] args){
    int a = getInteger();
    int b = getInteger();
    System.out.println(a + "+" + b +"=" + (a+b));
  }


}
