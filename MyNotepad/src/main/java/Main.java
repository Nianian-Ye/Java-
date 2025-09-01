import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    Scene scene = new Scene(root,800,600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Notepad");
    primaryStage.getIcons().add(new Image("notepad.png"));
    primaryStage.show();
  }
}
