import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
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

import java.util.Random;

public class Exercise15_02_v2 extends Application {
  private RectanglePanev2 pane = new RectanglePanev2();
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    pane.addRectangle();
    BorderPane borderPane = new BorderPane();
    borderPane.setPadding(new Insets(15,15,15,15));

    //rotate button
    Button rotateBt = new Button("Rotate");
    HBox hBox = new HBox();
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().add(rotateBt);
    rotateBt.setOnAction(new RotateHandler());

    //change color button
    Button colorBt = new Button("Fill and Stroke");
    colorBt.setOnAction(new ColorHandler());
    hBox.getChildren().add(colorBt);

    //Mouse pressed then rorate
    pane.setOnMouseClicked(e->{
      if(e.getButton()== MouseButton.PRIMARY) {
        pane.rotateRight();
        pane.requestFocus();
      }
      else if(e.getButton()==MouseButton.SECONDARY) {
        pane.rotateLeft();
        pane.requestFocus();
      }
      });

    //Press key and rotate
    pane.setOnKeyPressed(e->{
      if(e.getCode() == KeyCode.RIGHT) {
        pane.rotateRight();
      }
      else if(e.getCode()==KeyCode.LEFT) {
        pane.rotateLeft();
      }
    });
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    Scene scene = new Scene(borderPane, 550, 550);
    primaryStage.setScene(scene);
    primaryStage.show();
    pane.requestFocus();
  }
  class RotateHandler implements EventHandler <ActionEvent>{
    @Override
    public void handle(ActionEvent e) {
      pane.rotateRight();
    }
  }
  class ColorHandler implements EventHandler <ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      pane.changeFillAndStroke();
    }
  }
}
class RectanglePanev2 extends StackPane {
  private Rectangle  rectangle = new Rectangle(400,300);
  private double rotateAngle=0;
  private Color generateColor() {
    Random random = new Random();
    double red = random.nextDouble();
    double green = random.nextDouble();
    double blue = random.nextDouble();
    return new Color(red, green, blue,1);
  }

  public void addRectangle() {
    rectangle.setFill(Color.WHITE);
    rectangle.setStroke(Color.BLACK);
    getChildren().add(rectangle);
  }
  public void rotateRight() {
    rotateAngle+=15;
    rectangle.setRotate(rotateAngle);
  }
  public void rotateLeft() {
    rotateAngle-=15;
    rectangle.setRotate(rotateAngle);
  }
  public void changeFillAndStroke() {
    rectangle.setStroke(generateColor());
    rectangle.setFill(generateColor());
  }
}