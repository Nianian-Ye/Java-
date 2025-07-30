/*
计科2301 叶炼
20220401759
question:偶数号的槽总是0
*/


import java.util.Scanner;
public class Exercise07_21 {
  public static void printBalls(int[] slotCount) {
    int slotsNum = slotCount.length;
    int ballMax = 0;
    for (int i = 0; i < slotsNum; i++) {
      ballMax = slotCount[i] > ballMax ? slotCount[i] : ballMax;
    }
    for (int j = ballMax; j > 0; j--) {
      for (int k = 0; k < slotsNum; k++) {
        if (slotCount[k] < j) System.out.print("  ");
        else System.out.print("O ");
      }
      System.out.println();
    }
    for (int i = 0; i < slotsNum; i++) {
      System.out.print("- "); // 底部线条
    }
    System.out.println();
    for(int i=0;i<slotsNum; i++) {
      System.out.printf("%d ", slotCount[i]);
    }
  }
  public static void main(String[] args) {
    int beans;
    int slotsNum;

    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of balls to drop: ");
    beans = input.nextInt();
    System.out.print("Enter the number of slots in the bean machine: ");
    slotsNum = input.nextInt();
    int[] slotsCount = new int[slotsNum];
    for(int i=0; i<beans; i++){
      int position = (slotsNum-1)/2;
      String road="";
      for(int j=0; j<slotsNum-1; j++){
        if (position > 0 && position < slotsNum-1){
          if (Math.random() > 0.5) {
            road = road.concat("R");
            position  += 1;
          }
          else {
            road = road.concat("L");
            position -=1;
          }
        }
        else if(position==0){
          position ++;
          road = road.concat("R");
        }
        else if(position==slotsNum-1){
            position --;
            road = road.concat("L");
          }
      }
      slotsCount[position] +=1;
      System.out.println(road);
    }

    printBalls(slotsCount);

  }

}

