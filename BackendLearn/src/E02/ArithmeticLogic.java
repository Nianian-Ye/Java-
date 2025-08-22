package E02;

import java.util.Stack;

public class ArithmeticLogic {
  Stack<Character> operatorStack = new Stack<>();
  Stack<Double> numberStack = new Stack<>();

  public static void main(String[] args) {
    ArithmeticLogic pane = new ArithmeticLogic();
//    ExpressionResult expressionResult = pane.calculateExpression("8*(8/9-6*(7+45))");
//    System.out.print(expressionResult.to_String());
    ArithmeticLogic.test();
  }

  public void pushNumber(double number) {
    numberStack.push(number);
  }
  public double popNumber() {
    return numberStack.pop();
  }

  public void pushOperator(char operator) {
    operatorStack.push(operator);
  }
  public char popOperator() {
    return operatorStack.pop();
  }

  private boolean checkPriority(char top, char cursor) { //top表示栈顶
    return ((top == '+' || top == '-') && (cursor == '*' || cursor == '/')) || (top == '('); //true表示top优先级更低, cursor优先级更高
  }

  public ExpressionResult calculate() {
    char top = ' ';
    double number1, number2, result = 0;
    if (operatorStack.empty() || numberStack.empty()) {//判断第一次栈是否为空
      return new ExpressionResult("ERROR", "number stack empty", 0);
    } else {
      number1 = numberStack.pop();
      top = operatorStack.pop();
      if (numberStack.empty()) { // 判断第二个操作数是否空
        return new ExpressionResult("ERROR", "number stack empty", 0);
      } else {
        number2 = numberStack.pop();
        if (top == '-') {
          result = number2-number1;
        } else
          if (top == '+') {
            result = number1 + number2;
          } else
            if (top == '*') {
              result = number1 * number2;
            } else
              if (top == '/') {
                if (number2 == 0) {
                  return new ExpressionResult("ERROR", "Divided by 0", 0);
                } else {
                  result = number2/number1;
                }
              }
      }
    }
    numberStack.push(result);
    return new ExpressionResult("OK", "", result);
  }

  public ExpressionResult calculateExpression(String expression) {
    numberStack.clear();
    operatorStack.clear();
    //先完成加减乘除的运算
    char cursor;
    ExpressionResult expressionResult = new ExpressionResult(" Initial", "Initial", 0);
    for (int i = 0; i < expression.length(); i++) {
      cursor = expression.charAt(i);
      if (cursor >= '0' && cursor <= '9') {//数字入栈
        int j=i;
        while((j+1 < expression.length()) && ((expression.charAt(j+1)>='0' && expression.charAt(j+1) <= '9') || expression.charAt(j+1)=='.' )) { j++;}
        String number = expression.substring(i, j+1);
        numberStack.add(Double.parseDouble(number));
        i=j;
      } else //处理运算符
        if (!operatorStack.empty()) {
          char top = operatorStack.peek();
          if(cursor == '(') {
            operatorStack.push(cursor);
          } else if(cursor==')') {
            //此处的逻辑是，每遇到一个“)”，都与要直接运算直到遇到上一个"("
            while (operatorStack.peek()!='(' && !operatorStack.empty()) {
              expressionResult = calculate();
            }
            operatorStack.pop();
          } else if (!checkPriority(operatorStack.peek(), cursor) && (operatorStack.peek()!='(')) { //栈非空,且top并非"("(判断优先级时忽略了(),且top的优先级更高,计算top,
            // 之后再将cursor入栈
            //要始终checkPriority, 例如9
            // .9-78/14*2这个表达式，当cursor是*时，第一次计算/后，如果没有判断优先级，就会直接计算减法。但是正确的逻辑是跳出循环，将*入栈
            // 一定要判断operator.peek()!='('， 例子：8*(8/9-6),当cursor是-时
            while(!operatorStack.empty() && (!checkPriority(operatorStack.peek(), cursor)) && operatorStack.peek()!='(') {
              expressionResult = calculate();
            }
            operatorStack.push(cursor);
          }else{//当前cursor运算符优先级更高,入栈
            operatorStack.push(cursor);
          }
        } else {// 栈空,入栈
          operatorStack.push(cursor);
        }
    }
    while (!operatorStack.empty() && operatorStack.peek()!='(') {
      expressionResult = calculate();
    }
    return expressionResult;
  }
  public static void test() {
    ArithmeticLogic pane = new ArithmeticLogic();

    // 测试用例1: 基本加法
    ExpressionResult result1 = pane.calculateExpression("2+3");
    System.out.println("2+3 = " + result1.result + " (Expected: 5.0)");

    // 测试用例2: 基本减法
    ExpressionResult result2 = pane.calculateExpression("7-4");
    System.out.println("7-4 = " + result2.result + " (Expected: 3.0)");

    // 测试用例3: 基本乘法
    ExpressionResult result3 = pane.calculateExpression("5*6");
    System.out.println("5*6 = " + result3.result + " (Expected: 30.0)");

    // 测试用例4: 基本除法
    ExpressionResult result4 = pane.calculateExpression("15/3");
    System.out.println("15/3 = " + result4.result + " (Expected: 5.0)");

    // 测试用例5: 混合运算 - 优先级测试
    ExpressionResult result5 = pane.calculateExpression("2+3*4");
    System.out.println("2+3*4 = " + result5.result + " (Expected: 14.0)");

    // 测试用例6: 括号改变优先级
    ExpressionResult result6 = pane.calculateExpression("(2+3)*4");
    System.out.println("(2+3)*4 = " + result6.result + " (Expected: 20.0)");

    // 测试用例7: 嵌套括号
    ExpressionResult result7 = pane.calculateExpression("((2+3)*4)/2");
    System.out.println("((2+3)*4)/2 = " + result7.result + " (Expected: 10.0)");

    // 测试用例8: 复杂表达式
    ExpressionResult result8 = pane.calculateExpression("3+4*2/(1-5)");
    System.out.println("3+4*2/(1-5) = " + result8.result + " (Expected: 1.0)");

    // 测试用例9: 小数运算
    ExpressionResult result9 = pane.calculateExpression("2.5*3.2");
    System.out.println("2.5*3.2 = " + result9.result + " (Expected: 8.0)");

    // 测试用例10: 多位数运算
    ExpressionResult result10 = pane.calculateExpression("123+456");
    System.out.println("123+456 = " + result10.result + " (Expected: 579.0)");

    // 测试用例11: 原代码中的测试用例
    ExpressionResult result11 = pane.calculateExpression("8*(8/9-6*(7+45))");
    System.out.println("8*(8/9-6*(7+45)) = " + result11.result);

    // 测试用例12: 除法精度测试
    ExpressionResult result12 = pane.calculateExpression("10/3");
    System.out.println("10/3 = " + result12.result + " (Expected: ≈3.333)");
  }
}

class ExpressionResult {
  String tag;
  String message;
  double result;

  public ExpressionResult(String tag, String message, double result) {
    this.tag = tag;
    this.message = message;
    this.result = result;
  }

  public String to_String() {
    return this.tag + " " + this.message + " " + this.result;
  }
}