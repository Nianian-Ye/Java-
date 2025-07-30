/*
计科2301 叶炼 20220401759
 */
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Exercise07_12 {
 static int TESTNUM = 10;

  public static int[] reverse(int[] array) {
    int[] arrayCopy = new int[TESTNUM];

    for(int i=0,j=array.length-1; i<array.length; i++, j--) {
      arrayCopy[j] = array[i];
    }
    return arrayCopy;
  }

  public static void main(String[] args) {
    int[] array = new int[TESTNUM];
    Scanner input = new Scanner(System.in);
    System.out.println("Plesea enter ten integers: ");
    for(int i=0; i<TESTNUM ; i++ ){
      array[i] = input.nextInt();
    }
    array = reverse(array);
    for(int j=0; j<array.length; j++){
      System.out.printf("%d  ", array[j]);
    }
    return;
  }
}
