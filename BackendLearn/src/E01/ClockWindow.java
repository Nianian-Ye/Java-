package E01;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockWindow extends Application {

  private static final DateTimeFormatter FORMATTER =
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public void start(Stage primaryStage) {
    Label clockLabel = new Label();
    clockLabel.setTextFill(Color.BLACK);
    clockLabel.setFont(Font.font("Consolas", 32));
//    clockLabel.setStyle("-fx-background-color: black; -fx-padding: ;");

    // 容器居中显示
    StackPane root = new StackPane(clockLabel);
    Scene scene = new Scene(root, 500, 150);

    // 定时更新 Label 显示内容
    Timeline timeline = new Timeline(
      new KeyFrame(Duration.millis(1000), event -> {
        LocalDateTime now = LocalDateTime.now();
        clockLabel.setText(FORMATTER.format(now));
      })
    );
    timeline.setCycleCount(Timeline.INDEFINITE);
    primaryStage.setTitle("JavaFX 实时时钟");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

