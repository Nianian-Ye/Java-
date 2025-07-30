import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class Exercise14_04 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
    pane.setPadding(new Insets(10,10,10,10));
    pane.setHgap(20);
    pane.setVgap(20);

    Font f = new Font(22);
      f.font("TimesRomes",
      FontWeight.BOLD, FontPosture.ITALIC, 22
      );
    Text[] texts = new Text[5];
    double red, green, blue, opacity;
    for(Text t: texts) {
      t = new Text("JAVA");
      t.setFont(f);
      t.setRotate(270);
      red = Math.random();
      green = Math.random();
      blue= Math.random();
      opacity= Math.random();
      t.setFill(new Color(red, green, blue, opacity));
      pane.getChildren().addAll(t);
    }
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
