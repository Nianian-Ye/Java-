public class ThreadExercise {
  public static void main(String[] args) {
    Thread thread = new Thread(new Task());
    thread.start();
  }
}
class Task implements Runnable{
  public void run() {
    for(int i=0; i<100; i++) {
      System.out.print("a");
    }
  }
}