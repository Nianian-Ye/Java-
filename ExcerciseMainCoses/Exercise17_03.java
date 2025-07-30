import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
public class Exercise17_03 {
  public static void main(String[] args) throws IOException{
    File file = new File("Exercise17_02.dat");
    if(!file.exists()){
      System.out.print("File doesn't  exist");
      System.exit(1);
    }
    try(
      FileInputStream input = new FileInputStream(file);
      ){
      int sum=0;
      int num;
      num=input.read();
      while(num!=-1) {
        sum+=num;
        num=input.read();
      }
      System.out.print("The sum is: " + sum);
    }
  }
}
