import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_02 {
  public static void main(String[] args) throws IOException {
    File file = new File("Exercise17_02.dat");
    try (
      FileOutputStream output = new FileOutputStream(file, true);
      ) {
      int randomInt ;
      for(int i=0; i<100; i++){
        randomInt = (int)(Math.random()*100);
        output.write(randomInt);
      }
    }
  }
}
