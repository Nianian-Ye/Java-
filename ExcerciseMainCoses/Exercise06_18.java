import java.util.Scanner;

public class Exercise06_18 {
  public static boolean check(String str) {
   int  length = str.length();
   int numberCount = 0;
   int charCount = 0;
    if(length < 8) return false;
    for(int i=0; i<length; i++){
      char ch = str.charAt(i);
      if(! Character.isLetterOrDigit(ch)) return false;
      if(Character.isDigit(ch)) numberCount++;
      if(Character.isLetter(ch)) charCount++;

    }
    return (numberCount >= 2) && (charCount>=1);
  }
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
  System.out.print("Please enter your password: ");
    String inputStr = input.nextLine();
    if(check(inputStr)) System.out.print("Valid Password");
    else System.out.print("Invalid Password");
  }
}
