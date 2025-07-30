import java.util.Arrays;
import java.util.Comparator;

public class Exercise08_04 {

  public static void main(String[] args) {
      // Step 1: Store the hours in a 2D array
      int[][] hours = {
        {2, 4, 3, 4, 5, 8, 8},  // Employee 0
        {7, 3, 4, 3, 3, 4, 4},  // Employee 1
        {3, 4, 3, 3, 3, 3, 2},  // Employee 2
        {9, 3, 4, 7, 3, 4, 1},  // Employee 3
        {3, 5, 4, 3, 6, 3, 8},  // Employee 4
        {3, 4, 4, 6, 3, 4, 4},  // Employee 5
        {3, 7, 4, 8, 3, 8, 4},  // Employee 6
        {6, 3, 5, 9, 2, 7, 9}   // Employee 7
      };

      // Step 2: Calculate total hours for each employee
      int[][] totalHours = new int[8][2]; // [employee index, total hours]

      for (int i = 0; i < hours.length; i++) {
        int sum = 0;
        for (int j = 0; j < hours[i].length; j++) {
          sum += hours[i][j];
        }
        totalHours[i][0] = i;  // Store employee index
        totalHours[i][1] = sum; // Store total hours
      }

      // Step 3: Sort employees by total hours in descending order
      Arrays.sort(totalHours, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
          return b[1] - a[1]; // Compare by total hours, descending
        }
      });

      // Step 4: Display sorted employees and their total hours
      System.out.println("Employee | Total Hours");
      System.out.println("----------------------");
      for (int i = 0; i < totalHours.length; i++) {
        System.out.println("Employee " + totalHours[i][0] + " | " + totalHours[i][1]);
      }
  }

}
