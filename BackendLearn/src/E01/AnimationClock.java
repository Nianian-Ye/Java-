package E01;

import Review.ClockPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationClock extends Application {
  private ClockPane clock = new ClockPane();
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(clock);
    Label label = new Label();
    BorderPane.setAlignment(label, Pos.TOP_CENTER);
    borderPane.setBottom(label);
    borderPane.widthProperty().addListener(ov->{
      clock.setW(borderPane.getWidth());
    });
    borderPane.heightProperty().addListener(ov->{
      clock.setH(borderPane.getHeight());
    });
    Timeline animation = new Timeline(new KeyFrame(
      Duration.millis(1000), e->{
        clock.setCurrentTime();
        String currentTime = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        label.setText(currentTime);
    }
    ));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();

    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
