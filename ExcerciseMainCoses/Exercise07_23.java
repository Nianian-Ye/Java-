public class Exercise07_23 {

  public static void main(String[] args) {
    boolean[] isOpen = new boolean[100];
    for (int i=1; i<100; i++) {
      for(int j=i; j<100; j+=i+1) {
        isOpen[j] = isOpen[j] == false ? true : false ;
      }
    }
    System.out.println("Opening of the cabinet: ");
    for(int i=0; i<100; i++){
      System.out.printf("Cabinet num: %-5d Opening: %b\n", i+1, !isOpen[i]);
    }
  }
}
