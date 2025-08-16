package E01;
// 钟面

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

// 直接继承基类重写时钟面板的好处是什么。
// 命名规范


public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  private double w = 500, h= 500;

  public ClockPane() {
    setCurrentTime();
  }

  public void setCurrentTime() {
    Calendar calendar = new GregorianCalendar();
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    paintClock();
  }

  public void setW(double w) {
    this.w = w;
    paintClock();
  }
  public double getW(){
    return w;
  }
  public void setH(double h) {
    this.h = h;
    paintClock();
  }
  public double getH() {
    return h;
  }
  public String getHour() {
    return String.valueOf(hour);
  }
  public String getMinute() {
    return String.valueOf(minute);
  }
  public String getSecond() {
    return String.valueOf(second);
  }

  protected void paintClock(){
    double centerX = w/2;
    double centerY = h/2;
    double clockRadius = Math.min(w, h)*0.5 * 0.8;
    double twoPi = Math.PI*2;
    getChildren().clear();

    Circle circle = new Circle(centerX, centerY,clockRadius);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    getChildren().add(circle);
    //这里需要在文字前先添加circle，不然按照children 的堆栈顺序重叠后，文字会被覆盖。

    // draw number
    for(int i=1; i<=12; i++) {
      Text t = new Text(String.valueOf(i));
      t.setX(centerX-10+(clockRadius*0.8)*Math.sin(i*twoPi/12));
      t.setY(centerY+10-(clockRadius*0.8)*Math.cos(i*twoPi/12));
      t.setFont(new Font(20));
      getChildren().add(t);
    }

    // draw second hand
    double sLength = clockRadius*0.8;
    double secondX = centerX + sLength * Math.sin(second*(twoPi/60));
    double secondY = centerY - sLength * Math.cos(second*(twoPi/60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStrokeWidth(3);
    sLine.setStroke(Color.BLUE);

    // draw minute hand
    double mLength = clockRadius*0.65;
    double minuteX = centerX + mLength * Math.sin(minute*(twoPi/60.0));
    double minuteY = centerY - mLength * Math.cos(minute*(twoPi/60.0));
    Line mLine = new Line(centerX, centerY, minuteX, minuteY);
    mLine.setStrokeWidth(5);
    mLine.setStroke(Color.RED);

    // draw hour hand
    double hLength = clockRadius*0.5;
    double hourX = centerX + hLength * Math.sin((hour%12 + minute/60.0 )*(twoPi/12));
    double hourY = centerY - hLength * Math.cos((hour%12 + minute/60.0)*(twoPi/12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStrokeWidth(8);
    hLine.setStroke(Color.PURPLE);


//    getChildren().addAll(circle,sLine);
    getChildren().addAll(sLine, mLine, hLine);
  }

}
