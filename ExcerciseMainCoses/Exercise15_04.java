import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise15_04 extends Application {
  private double num1, num2;
  private TextField tfNunber1 = new TextField();
  private TextField tfNunber2 = new TextField();
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    BorderPane bdPane = new BorderPane();
    GridPane pane = new GridPane();
    pane.setVgap(5);
    pane.setVgap(5);
    pane.add(new Label("Number 1:"), 0,0);
    pane.add(new Label("Number 2:"), 2,0);
    pane.add(new Label("Result:"), 4,0);

    TextField tfResult = new TextField();
    pane.add(tfNunber1, 1,0);
    pane.add(tfNunber2, 3,0);
    pane.add(tfResult, 5,0);

    HBox hBox = new HBox();
    Button btAdd = new Button("Add");
    Button btsubtract = new Button("Subtract");
    Button btMultiply = new Button("Multiply");
    Button btDivide = new Button("Divide");
    hBox.getChildren().addAll(btAdd, btsubtract, btMultiply, btDivide);
    btAdd.setOnAction(e->{
      getInput();
      tfResult.setText(String.format("%.1f",num1+num2));
    });
    btsubtract.setOnAction(e->{
      getInput();
      tfResult.setText(String.format("%.1f",num1-num2));
    });
    btMultiply.setOnAction(e->{
      getInput();
      tfResult.setText(String.format("%.1f",num1*num2));
    });
    btDivide.setOnAction(e->{
      getInput();
      if(num2==0) {
        tfNunber2.clear();
        return;
      }
        tfResult.setText(String.format("%.1f",num1/num2));
    });

    hBox.setAlignment(Pos.CENTER);
    bdPane.setPadding(new Insets(5,5,5,5));
    bdPane.setCenter(pane);
    bdPane.setBottom(hBox);
    Scene scene = new Scene(bdPane);
    primaryStage.setScene(scene);
    primaryStage.show();

  }
  private void getInput() {
    num1 = Double.parseDouble(tfNunber1.getText());
    num2 = Double.parseDouble(tfNunber2.getText());

  }
}
