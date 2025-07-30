

import java.util.Scanner;
import java.util.Random;
public class Exercise08_14 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.print("Enter the size for the matrix: ");
    int size = scanner.nextInt();

    int[][] matrix = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = random.nextInt(2); // random 0 or 1
      }
    }

    System.out.println("The matrix is:");
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }

    for (int i = 0; i < size; i++) {
      boolean allZeros = true;
      boolean allOnes = true;
      for (int j = 0; j < size; j++) {
        if (matrix[i][j] != 0) allZeros = false;
        if (matrix[i][j] != 1) allOnes = false;
      }
      if (allZeros) System.out.println("All 0s on row " + i);
      if (allOnes) System.out.println("All 1s on row " + i);
    }

    for (int j = 0; j < size; j++) {
      boolean allZeros = true;
      boolean allOnes = true;
      for (int i = 0; i < size; i++) {
        if (matrix[i][j] != 0) allZeros = false;
        if (matrix[i][j] != 1) allOnes = false;
      }
      if (allZeros) System.out.println("All 0s on column " + j);
      if (allOnes) System.out.println("All 1s on column " + j);
    }

    boolean allZeros = true;
    boolean allOnes = true;
    for (int i = 0; i < size; i++) {
      if (matrix[i][i] != 0) allZeros = false;
      if (matrix[i][i] != 1) allOnes = false;
    }
    if (allZeros) System.out.println("All 0s on the major diagonal");
    if (allOnes) System.out.println("All 1s on the major diagonal");

    allZeros = true;
    allOnes = true;
    for (int i = 0; i < size; i++) {
      if (matrix[i][size - 1 - i] != 0) allZeros = false;
      if (matrix[i][size - 1 - i] != 1) allOnes = false;
    }
    if (allZeros) System.out.println("All 0s on the sub-diagonal");
    if (allOnes) System.out.println("All 1s on the sub-diagonal");
  }
}
