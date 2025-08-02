package E01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// 终端输出样式
public class E01 {
    public static void main(String[] args) throws InterruptedException {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      while (true) {
        LocalDateTime now = LocalDateTime.now();
        String formatted = now.format(formatter);

        System.out.print("\r" + formatted); // 用 \r 回车符覆盖上一行
        Thread.sleep(100); // 每100毫秒刷新一次
      }
    }
}


