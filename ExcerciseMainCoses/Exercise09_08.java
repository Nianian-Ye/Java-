import Exercise.Fan;

public class Exercise09_08 {
  public static void main(String args[]) {

    Fan myFan1 = new Fan(Fan.FAST, 10, "yellow", true);
    String faniInfo = myFan1.toString();
    System.out.println(faniInfo);

    Fan myFan2 = new Fan(Fan.MEDIUM, 5, "blue", false);
    String fan2Info = myFan2.toString();
    System.out.println(fan2Info);
  }
};
