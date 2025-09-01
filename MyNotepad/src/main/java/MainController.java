import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
  @FXML
  private FileStatus file;
  @FXML
  private VBox vBox;
  @FXML
  private MenuItem newFileButton;
  @FXML
  private MenuItem openFIle;
  @FXML
  private MenuItem saveFile;
  @FXML
  private MenuItem exit;
  @FXML
  private TextArea text;

  @FXML
  private MenuItem cutText;

  @FXML
  private MenuItem copyText;

  @FXML
  private MenuItem pasteText;

  @FXML
  private TextField fontSize;

  @FXML
  private MenuItem about;
  private  boolean S = false, Ctrl = false;

  @FXML
  void newClick(ActionEvent e) throws IOException {
    saveClick(e);
    text.clear();
//    IndexRange selection = text.getSelection();
//    text.deleteText(selection.getStart(), selection.getEnd());
  }

  @FXML
  void openClick(ActionEvent e) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open file");
    File file = fileChooser.showOpenDialog(new Stage());
    if(file!=null) {
      text.setText(FileStatus.getContent(file));
    }
  }

  @FXML
  void exitClick(ActionEvent e) throws IOException{
    Platform.exit();
  }

  @FXML
  void saveClick(ActionEvent e) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("保存文件");
    fileChooser.setInitialFileName("Untitled");
    fileChooser.getExtensionFilters().addAll(
      new FileChooser.ExtensionFilter("Text Files", "*.txt"));
    File file = fileChooser.showSaveDialog(new Stage());
    if(file!=null && !text.getText().isEmpty()){
      FileStatus.setContent(file, text.getText());
    }
  }

  @FXML
  void onKeyPressed(KeyEvent e)throws IOException {
    if(e.getCode().getName().equals("S")) S=true;
    if(e.getCode().getName().equals("Ctrl")) Ctrl=true;
    if(S&&Ctrl) {
      saveClick(new ActionEvent());
      Ctrl=false;
      S=false;
    }
  }
// 这两个的逻辑是：只有当同时按下ctrl和S键时，才保存。一放开就不算。
  //两个同时按下记为true, 只要有放开的动作，就记为false.
  @FXML
  void onKeyReleased(KeyEvent e) {
    if(e.getCode().getName().equals("Ctrl")){
      Ctrl=false;
    }
    else if(e.getCode().getName().equals("S")) {
      S=false;
    }
  }

  @FXML
  void cutClick(ActionEvent e) {
    text.cut();
  }

  @FXML
  void copyClick(ActionEvent e) {
    text.copy();
  }

  @FXML
  void pasteClick(ActionEvent e) {
    text.paste();
  }

  @FXML
  void setFont(KeyEvent e) {
    String str = fontSize.getText();
    if(e.getCode().getName().equals("Enter")&&checkStrIsNum(str)){
      text.setStyle("-fx-font-size:"+str);
    }
  }

  @FXML
  void aboutClick(ActionEvent e)throws IOException {
    Parent aboutRoot = FXMLLoader.load(getClass().getResource("About.fxml"));

    Stage aboutStage = new Stage();
    aboutStage.setScene(new Scene(aboutRoot, 500, 400));
    aboutStage.setResizable(false);
    aboutStage.setTitle("关于");
    aboutStage.getIcons().add(new Image("about.png"));
    aboutStage.show();
  }

  public static boolean checkStrIsNum(String str) {
    Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    String bigStr;
    try {
      bigStr = new BigDecimal(str).toString();
    } catch (Exception e) {
      return false;
    }
    Matcher isNum = NUMBER_PATTERN.matcher(str);
    if (!isNum.matches()) {
      return false;
    }
    return true;
  }
}


