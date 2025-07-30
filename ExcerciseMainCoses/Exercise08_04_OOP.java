import java.util.Arrays;
import java.util.Comparator;
public class Exercise08_04_OOP {


public static  class Employee{
  private int id;
  private int[] weeklyTime = new int[7];
  private int totalHour =0;
  public Employee(int id, int[] weeklyTime){
    this.id = id;
    for(int i=0; i<weeklyTime.length; i++){
      this.weeklyTime[i] = weeklyTime[i];
      totalHour += weeklyTime[i];
    }
  }
  public int  getTotalHour(){
    return totalHour;
  }
  public void disp(){
    System.out.printf("Employee%d | %d\n", id, totalHour);
  }
};
public static void main(String[] args) {
  Employee[] employees  = new Employee[8];
  int[][] info = {
    {2, 4, 3, 5, 8, 5, 8},
    {7, 3, 4, 3, 5, 3, 4},
    {3, 3, 4, 3, 3, 2, 2},
    {9, 3, 4, 7, 3, 7, 1},
    {5, 4, 3, 6, 4, 3, 8},
    {4, 4, 4, 5, 4, 4, 4},
    {7, 4, 8, 3, 8, 3, 4},
    {6, 3, 5, 9, 2, 7, 9}
  };
  for(int j=0; j<info.length; j++){
    employees[j] = new Employee(j,info[j]);
  }
  Comparator<Employee> byTotalTime = Comparator.comparing(Employee::getTotalHour).reversed();
  Arrays.sort(employees, byTotalTime);
  for(int cnt =0; cnt < employees.length; cnt ++) {
    employees[cnt].disp();
  }
}
};