import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Exercise15_02 extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  private RectanglePane pane = new RectanglePane();
  @Override
  public void start(Stage primaryStage) {
    pane.addRectangle();
    BorderPane borderPane = new BorderPane();
    borderPane.setPadding(new Insets(15,15,15,15));
    Button rotateBt = new Button("Rotate");
    HBox hBox = new HBox();
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().add(rotateBt);
    rotateBt.setOnAction(new RotateHandler());
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    Scene scene = new Scene(borderPane, 550, 550);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  class RotateHandler implements EventHandler <ActionEvent>{
    @Override
    public void handle(ActionEvent e) {
      pane.rotate();
    }
  }
}

class RectanglePane extends StackPane {
  private Rectangle  rectangle = new Rectangle(400,300);
  private double rotateAngle=15;
  public void addRectangle() {
    rectangle.setFill(Color.WHITE);
    rectangle.setStroke(Color.BLACK);
    getChildren().add(rectangle);
  }
  public void rotate() {
    rectangle.setRotate(rotateAngle);
    rotateAngle+=15;
  }
}