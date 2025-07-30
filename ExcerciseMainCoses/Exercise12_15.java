import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class Exercise12_15 {
  public static void main(String[] args) throws IOException {
    File file = new File("Exercise12_13.txt");
    if(!file.exists()){
      try(
        PrintWriter output = new PrintWriter(file);
      ){
        for(int i=0; i<100; i++) {
          int randomInt=(int)(Math.random()*0xffffff);
          output.print(randomInt+" ");
        }
      }
    }
    int[] a = new int[100];
    try(Scanner input = new Scanner(file);){
      for(int i=0; i<100; i++) {
        a[i] = input.nextInt();
      }
      Arrays.sort(a);
    }
    try(PrintWriter output = new PrintWriter(file);){
      for(int i=0; i<a.length; i++) {
        output.print(a[i]+" ");
      }
    }
  }
}
