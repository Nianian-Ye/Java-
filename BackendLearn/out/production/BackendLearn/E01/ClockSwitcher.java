package E01;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockSwitcher extends Application {

  private static final double WIDTH = 500;
  private static final double HEIGHT = 500;
  private static final double CENTER_X = WIDTH / 2;
  private static final double CENTER_Y = HEIGHT / 2;
  private static final double RADIUS = 200;

  private boolean showingAnalog = true; // 是否正在显示表盘
  private final Canvas analogCanvas = new Canvas(WIDTH, HEIGHT);
  private final Label digitalLabel = new Label();

  private final DateTimeFormatter digitalFormatter =
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

  @Override
  public void start(Stage primaryStage) {
    GraphicsContext gc = analogCanvas.getGraphicsContext2D();

    // 初始化按钮
    Button toggleButton = new Button("切换显示模式");
    toggleButton.setOnAction(e -> toggleView());

    // 布局：数字钟 + 表盘钟分别放在一个 StackPane 中，切换隐藏显示
    StackPane analogPane = new StackPane(analogCanvas);
    analogPane.setVisible(true);

    digitalLabel.setFont(Font.font(32));
    digitalLabel.setTextFill(Color.DARKGREEN);
    VBox digitalPane = new VBox(digitalLabel);
    digitalPane.setAlignment(Pos.CENTER);
    digitalPane.setVisible(false); // 默认隐藏

    // 总布局
    BorderPane root = new BorderPane();
    StackPane centerStack = new StackPane(analogPane, digitalPane);
    root.setCenter(centerStack);
    root.setTop(toggleButton);
    BorderPane.setAlignment(toggleButton, Pos.CENTER);

    // 启动画面刷新定时器
    new AnimationTimer() {
      @Override
      public void handle(long now) {
        LocalDateTime time = LocalDateTime.now();
        if (showingAnalog) {
          drawClock(gc, time);
        } else {
          digitalLabel.setText(digitalFormatter.format(time));
        }
      }
    }.start();

    Scene scene = new Scene(root);
    primaryStage.setTitle("时钟视图切换器");
    primaryStage.setScene(scene);
    primaryStage.show();

    // 记得保留引用
    analogCanvas.setUserData(analogPane);
    digitalLabel.setUserData(digitalPane);
  }

  private void toggleView() {
    showingAnalog = !showingAnalog;
    ((StackPane) analogCanvas.getUserData()).setVisible(showingAnalog);
    ((VBox) digitalLabel.getUserData()).setVisible(!showingAnalog);
  }

  private void drawClock(GraphicsContext gc, LocalDateTime now) {
    gc.clearRect(0, 0, WIDTH, HEIGHT);

    // 画圆盘
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(4);
    gc.strokeOval(CENTER_X - RADIUS, CENTER_Y - RADIUS, RADIUS * 2, RADIUS * 2);

    // 画数字刻度
    gc.setFill(Color.BLACK);
    gc.setFont(Font.font(20));
    for (int i = 1; i <= 12; i++) {
      double angle = Math.toRadians(i * 30 - 90);
      double x = CENTER_X + Math.cos(angle) * (RADIUS - 30);
      double y = CENTER_Y + Math.sin(angle) * (RADIUS - 30);
      gc.fillText(String.valueOf(i), x - 7, y + 7);
    }

    // 获取时间
    int hour = now.getHour() % 12;
    int minute = now.getMinute();
    int second = now.getSecond();

    double secondAngle = Math.toRadians(second * 6 - 90);
    double minuteAngle = Math.toRadians(minute * 6 - 90);
    double hourAngle = Math.toRadians(((hour + minute / 60.0) * 30) - 90);

    drawHand(gc, secondAngle, RADIUS * 0.9, Color.RED, 1);
    drawHand(gc, minuteAngle, RADIUS * 0.75, Color.BLUE, 3);
    drawHand(gc, hourAngle, RADIUS * 0.5, Color.BLACK, 5);

    gc.setFill(Color.BLACK);
    gc.fillOval(CENTER_X - 5, CENTER_Y - 5, 10, 10);

    // 电子时间在圆盘下方显示
    gc.setFont(Font.font(18));
    gc.setFill(Color.DARKBLUE);
    String digital = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now);
    gc.fillText(digital, CENTER_X - 85, CENTER_Y + RADIUS + 30);
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
