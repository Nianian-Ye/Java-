package E01;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class AnalogClock extends Application {

  private static final double WIDTH = 400;
  private static final double HEIGHT = 400;
  private static final double CENTER_X = WIDTH / 2;
  private static final double CENTER_Y = HEIGHT / 2;
  private static final double RADIUS = 180;

  @Override
  public void start(Stage primaryStage) {
    Canvas canvas = new Canvas(WIDTH, HEIGHT);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    new AnimationTimer() {
      @Override
      public void handle(long now) {
        drawClock(gc);
      }
    }.start();

    StackPane root = new StackPane(canvas);
    Scene scene = new Scene(root);
    primaryStage.setTitle("JavaFX 表盘时钟");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void drawClock(GraphicsContext gc) {
    gc.clearRect(0, 0, WIDTH, HEIGHT);

    // 画表盘
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(4);
    gc.strokeOval(CENTER_X - RADIUS, CENTER_Y - RADIUS, RADIUS * 2, RADIUS * 2);

    // 获取当前时间
    LocalDateTime now = LocalDateTime.now();
    int hour = now.getHour() % 12;
    int minute = now.getMinute();
    int second = now.getSecond();

    // 计算指针角度
    double secondAngle = Math.toRadians((second / 60.0) * 360-90);
    double minuteAngle = Math.toRadians((minute / 60.0) * 360 -90);
    double hourAngle = Math.toRadians(((hour + minute / 60.0) / 12.0) * 360 - 90);

    // 秒针
    drawHand(gc, secondAngle, RADIUS * 0.9, Color.RED, 1);

    // 分针
    drawHand(gc, minuteAngle, RADIUS * 0.75, Color.BLUE, 3);

    // 时针
    drawHand(gc, hourAngle, RADIUS * 0.5, Color.BLACK, 5);

    // 画中心点
    gc.setFill(Color.BLACK);
    gc.fillOval(CENTER_X - 5, CENTER_Y - 5, 10, 10);
  }

  private void drawHand(GraphicsContext gc, double angle, double length, Color color, double width) {
    double x = CENTER_X + Math.cos(angle) * length;
    double y = CENTER_Y + Math.sin(angle) * length;

    gc.setStroke(color);
    gc.setLineWidth(width);
    gc.strokeLine(CENTER_X, CENTER_Y, x, y);
  }

  public static void main(String[] args) {
    launch(args);
  }
}

// stage -> stackPane -> canvas(gc(drawClock, drawHand))