
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise12_19 {
  public static void main(String[] args) throws IOException{
    File file = new File("Lincoln3.txt");
    if(!file.exists()){
      System.out.print("File not found");
      System.exit(1);
    }
    Scanner input = new Scanner(file);
    int count=0;
    while(input.hasNext()){
      input.next();
      count++;
    }
    System.out.print("The speech has " + count + " words.");
  }

}
