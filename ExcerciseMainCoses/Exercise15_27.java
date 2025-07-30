import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_27 extends Application {

  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    Text text = new Text("Programming is fun");
    double textWidth = text.getBoundsInLocal().getWidth();
    text.setY(100);
    pane.getChildren().add(text);
    TranslateTransition animation = new TranslateTransition(Duration.seconds(4), text);
    animation.setFromX(-textWidth);
    animation.setToX(400);
    animation.setCycleCount(TranslateTransition.INDEFINITE);
    animation.setAutoReverse(false);
    animation.play();
    pane.setOnMousePressed((MouseEvent e) -> animation.pause());
    pane.setOnMouseReleased((MouseEvent e) -> animation.play());
    Scene scene = new Scene(pane, 400, 200);
    primaryStage.setTitle("Exercise15_27");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
