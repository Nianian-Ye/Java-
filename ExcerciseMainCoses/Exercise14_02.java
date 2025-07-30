import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class Exercise14_02 extends Application {

  private static final String X_IMAGE_PATH = "D:\\课件\\java\\image\\x.gif";
  private static final String O_IMAGE_PATH = "D:\\课件\\java\\image\\o.gif";

  @Override
  public void start(Stage primaryStage) {
    // 创建一个GridPane作为棋盘
    GridPane gridPane = new GridPane();

    // 加载X和O的图片
    Image xImage = new Image(new File(X_IMAGE_PATH).toURI().toString());
    Image oImage = new Image(new File(O_IMAGE_PATH).toURI().toString());

    // 随机填充棋盘
    Random random = new Random();
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        int randomValue = random.nextInt(3); // 0, 1, or 2
        if (randomValue == 1) {
          // 放置X
          gridPane.add(new ImageView(xImage), col, row);
        } else if (randomValue == 2) {
          // 放置O
          gridPane.add(new ImageView(oImage), col, row);
        }
        // 如果是0则留空
      }
    }

    // 设置场景和窗口标题
    Scene scene = new Scene(gridPane, 100, 150);
    primaryStage.setTitle("Exercise 14_02");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
