import java.util.Scanner;

public class Exercise03_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int dayOfWeek, century, yearOfCentury;
    System.out.print("Enter year: (e.g., 2012): ");
    int year = input.nextInt();
    System.out.print("Enter month: 1-12: ");
    int month = input.nextInt();
    System.out.print("Enter the day of the month: 1-31: ");
    int day = input.nextInt();
    century = Math.abs(year / 100);
    yearOfCentury = year % 100;

    //Adjust the month and day
    if (month <= 2) {
      month += 12;
      year -= 1;
    }

    dayOfWeek = (day + 26 * (1 + month) / 10 + yearOfCentury + yearOfCentury / 4 + century / 4 + 5 * century) % 7;

    String[] strDayOfWeek = {"Saturday", "Sunday", "Monday",
      "Tuesday", "Wednesday", "Thursday", "Friday"};
  System.out.printf("Day of the week is %s\n",strDayOfWeek[dayOfWeek]);
  }
}
