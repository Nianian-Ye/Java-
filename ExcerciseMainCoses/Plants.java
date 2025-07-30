//计科2301叶炼
//植物大战僵尸中植物们的技能

public class Plants {
  public static void main(String[] args) {
    Plants peashooter = new Peashooter();
    Plants helianthus = new Helianthus();
    Plants.sunshineValue = 50;
    helianthus.plant(sunshineValue);
    while(sunshineValue < peashooter.sunshineCost) {
      helianthus.ability();
      if(peashooter.plant(sunshineValue)) break;
    }
    peashooter.ability();
  }

  protected String name = "";
  protected int sunshineCost = 0;
  protected double recoveryTime = 0;
  protected String unlockLevel = "";
  public static int sunshineValue;

  public Plants(String name, int sunshineCost, double recoveryTime, String unlockLevel) {
    this.name = name;
    this.sunshineCost = sunshineCost;
    this.recoveryTime = recoveryTime;
    this.unlockLevel = unlockLevel;
  }
  public Plants(){};

  public void ability(){
    System.out.println(name + ": I am too weak to attack.");
  }
  public boolean plant(int sunshine ) {
    System.out.println("I don`t have a body.");
    return false;
  }
};

class Helianthus extends Plants{//向日葵
  public Helianthus(String name, int sunshineCost, double recoveryTime, String unlockLevel) {
    super(name, sunshineCost, recoveryTime, unlockLevel);
  }
  public Helianthus() {
    super.name = "Helianthus";
    super.sunshineCost = 50;
    super.recoveryTime = 7.5;
    super.unlockLevel = "1-1";
  }
  @Override
  public boolean plant(int sunshine){
    if(sunshine < sunshineCost){
      System.out.println(name + ": Please give me " + sunshineCost+ " sunshine.");
      return false;
    }
    else {
      System.out.println("The " + name +" was successfully planted.");
      sunshineValue -= sunshineCost;
      return true;
    }
  }
  @Override
  public void ability(){
    System.out.println(name + ": I am producing sunshine.");
    sunshineValue += 50;
  }
};

class Peashooter extends Plants{//豌豆射手
  public Peashooter(String name, int sunshineCost, double recoveryTime, String unlockLevel) {
    super(name, sunshineCost, recoveryTime, unlockLevel);
  }
  public Peashooter () {
    name = "Peashdoter";
    sunshineCost = 100;
    recoveryTime = 7.5;
    unlockLevel = "0-0";
  }
  @Override
  public boolean plant(int sunshine){
    if(sunshine < sunshineCost){
      System.out.println(name + ": Please give me " + sunshineCost+ " sunshine.");
      return false;
    }
    else {
      System.out.println("The " + name +" was successfully planted.");
      sunshineValue -= sunshineCost;
      return true;
    }
  }
  @Override
  public void ability(){
    System.out.println(name + ": I am shooting peas to kill the zombies.");
  }
};