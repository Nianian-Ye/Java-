import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15__27 extends Application {

  private TranslateTransition animation;
  private Text text;

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    text = new Text("Programming is fun");

    text.setY(100);
    pane.getChildren().add(text);

    setupAnimation(pane);

    pane.setOnMousePressed(this::pauseAnimation);
    pane.setOnMouseReleased(this::resumeAnimation);

    Scene scene = new Scene(pane, 400, 200);
    scene.widthProperty().addListener(observable -> resetAnimation(scene.getWidth()));

    primaryStage.setTitle("Exercise15_27");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void setupAnimation(Pane pane) {
    double textWidth = text.getBoundsInLocal().getWidth();
    animation = new TranslateTransition(Duration.seconds(4), text);
    animation.setFromX(-textWidth); // 从左侧开始
    animation.setToX(pane.getWidth()); // 动态设置到达右侧
    animation.setCycleCount(TranslateTransition.INDEFINITE);
    animation.play();
  }

  private void resetAnimation(double sceneWidth) {
    animation.stop();
    animation.setToX(sceneWidth); // 根据新宽度更新动画的结束点
    animation.play();
  }

  private void pauseAnimation(MouseEvent event) {
    animation.pause();
  }

  private void resumeAnimation(MouseEvent event) {
    animation.play();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
