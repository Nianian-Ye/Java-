import java.io.*;
import java.util.ArrayList;

public class Exercise17_15  {
  public static void main(String[] args)  throws IOException {
    ArrayList<Byte> myBytes= new ArrayList<>();
    byte myByte;
    try(
      DataInputStream input = new DataInputStream(new FileInputStream("encrypted_data.txt"));
      ){
      while(true) {
        myByte = input.readByte();
        myBytes.add((byte)(myByte-5));
      }
    }
    catch(EOFException e) {
      System.out.println("End of the file");
    }

    try(
      DataOutputStream output = new DataOutputStream(new FileOutputStream("decrypted_data.txt"));
      ){
      for(int i=0; i<myBytes.size(); i++) {
        output.write(myBytes.get(i));
      }
    }
  }
}
