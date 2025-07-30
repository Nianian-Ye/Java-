import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Exercise15_19 extends Application {
  private Circle circle = new Circle(10);
  private int count=0;
  private long startTime;
  public static void main(String[] args) {
    launch(args);
  }
  private Color generateColor() {
    Random random = new Random();
    return Color.color(random.nextFloat(),random.nextFloat(), random.nextFloat());
  }
  private void updatePos(StackPane pane) {
    double paneWidth = pane.getWidth();
    double paneHeight = pane.getHeight();
    Random random = new Random();
    circle.setTranslateX(paneWidth*random.nextDouble()-paneWidth/2);
    circle.setTranslateY(paneHeight*random.nextDouble()-paneHeight/2);

    circle.setFill(generateColor());
  }
  @Override
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    pane.setPadding(new Insets(5,5,5,5));
    pane.getChildren().add(circle);

    circle.setOnMouseClicked(e->{
      if(count==0){
        startTime=System.currentTimeMillis();
      }
      count++;
      updatePos(pane);
      if(count==5){
        long endTime = System.currentTimeMillis();
        pane.getChildren().clear();
        pane.getChildren().add(new Label("The spent is "+(endTime-startTime) + "miliseconds"));
      }
    });
    Scene scene = new Scene(pane, 800, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Exercise15_19");
    primaryStage.show();
  }

}
