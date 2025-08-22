package E02;
//我觉得我的计算器写到这里就差不多了。复杂的部分留着之后再写。
//学到的重要的部分有：1、搜集项目和资料，分析需求。参考Github上2018年基于Swing写的项目，但我现在去找项目地址居然检索不到了。
//2、拆解需求，由简单到复杂地实现需求
// 3、应用了Application 在实际功能上
// 4、熟练运用debug检查代码
/*
已实现的功能：
1、基本四则运算
2、可视化以及点击输入表达式
未实现有：
1、高级运算如：指数运算、对数运算、阶乘运算、幂运算。
2、正则表达式检查输入表达式的合法性
3、处理负数
4、面板宽高自由拉伸
5、计算器的历史记录
*/


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {
  public static void main(String[] args) {
   launch(args);
  }
  @Override
  public void start(Stage primaryStage) {
    MainPane mainPane = new MainPane();
    Scene scene = new Scene(mainPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

class MainPane extends Pane {
  private TextField tf = new TextField();
  private String expression = "";
  private ExpressionResult expressionResult = new ExpressionResult("ERROE", "", 0);
  private final int buttonCounts = 20;
  private final Button[] buttons = new Button[buttonCounts];
  public static boolean done = false;

  MainPane() {
    // 按钮面板
    GridPane buttonPane = new GridPane();
    for (int i = 0; i < 20; i++) {
      String[] buttonStrings = {
        "C", "(", ")", "/",
        "7", "8", "9", "*",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "AC", "0", ".", "="
      };
      buttons[i] = new Button(buttonStrings[i]);
      buttons[i].setMinSize(80, 40);
      buttons[i].setFont(Font.font("微软雅黑", 20));
      buttons[i].setOnAction(new ButtonHandler());
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 4; j++) {
        int order = i * 4 + j;
        buttonPane.add(buttons[order], j, i);
        buttonPane.widthProperty().addListener(ov -> {
          buttons[order].setMinSize(buttonPane.getWidth() / 6, buttonPane.getHeight() / 9);
        });
      }
    }
    buttonPane.setVgap(5);
    buttonPane.setHgap(5);
    buttonPane.setAlignment(Pos.CENTER);
    //计算过程和结果面板
    Pane resultPane = new Pane();
    tf.setFont(Font.font(25));

    resultPane.getChildren().add(tf);
    resultPane.setMinSize(400, 150);
    VBox vBox = new VBox();
    vBox.getChildren().addAll(resultPane, buttonPane);
    vBox.setAlignment(Pos.CENTER);
    getChildren().addAll(vBox);
  }

  class ButtonHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
      // 这里是处理按钮的按动的逻辑，当按表达式时，字符串直接添加，
      // 当按AC，清除所有表达式，
      //当按C时，清除上一个字符串
      //当按=时，计算表达式
      Button bt = (Button) (e.getSource());
      String text = bt.getText();
      if (text == "C") {
        if (expression.length() == 0 || expression.length()==1) {
          expression="";
        } else {
          expression = expression.substring(0, expression.length()-1);
        }
      } else if(text == "AC") {
        expression = "";
      }
      else if(text == "=") {
        done = true;
        if(checkLegality(expression) ){
          expressionResult = new ArithmeticLogic().calculateExpression(expression);
//          tf.setText(expressionResult.to_String());
          System.out.print(expressionResult.to_String());
          if(expressionResult.tag=="OK"){
            tf.setText(String.valueOf(expressionResult.result));
            expression=String.valueOf(expressionResult.result);
          }
          else{
            expression = "";
          }
        }
          done = false;
        return;
      }
      else {
        expression += text;
      }
      tf.setText(expression);
    }
  }

  public boolean checkLegality(String expression) {
    // 判断表达式的合法性需要用到正则表达式，这里我不想写了。
    return true;
  }

}
