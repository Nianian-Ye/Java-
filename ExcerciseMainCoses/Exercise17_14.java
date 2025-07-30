import java.io.*;
import java.util.ArrayList;

public class Exercise17_14 {
  public static void main(String[] args) throws IOException {
    ArrayList<Byte> myBytes = new ArrayList<>();
    byte myByte ;
    try(
      DataInputStream input = new DataInputStream(new FileInputStream("Lincoln3.txt"));
      ){
      myByte = input.readByte();
      while(true){
        myBytes.add((byte)(myByte+5));
        myByte = input.readByte();
      }
    }catch (EOFException e) {
      System.out.print("End of the file");
    }
    try(
      DataOutputStream output = new DataOutputStream(new FileOutputStream("encrypted_data.txt"));
      ){
      for(int i=0; i<myBytes.size(); i++) {
        output.write(myBytes.get(i));
      }
    }
  }
}
