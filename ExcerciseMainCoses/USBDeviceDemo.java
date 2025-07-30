public class USBDeviceDemo {
  public static void  main(String[] args) {
    Computer c = new Computer();
    c.connectUSB(new HDD(), 0);
    c.connectUSB(new SSD(), 1);
    c.connectUSB(new USBMouse(), 2);
    double totalStorrage = c.getTotalCapacity();
    System.out.println("Total storage is: " + totalStorrage);
  }
}

class Computer{
  USB[] usb = new USB[3];
  public Computer(){}
  public void connectUSB(USB u, int position){
    if(position<0 || position >= usb.length) {
      System.out.println("Position Error");
    }
    else {
      usb[position] = u;
      usb[position].work();
    }
  }

  public double getTotalCapacity() {
    double storage=0;
    for(USB u : usb){
      if( u != null &&  u instanceof StorageDevice) {
        storage += ((StorageDevice) u).getCapacity();
      }
    }
    return storage;
  }
}

class USBMouse implements USB{
  public void work() {
    System.out.println("USB鼠标设备开始运作");
  }
}
class HDD extends StorageDevice implements USB{
  public double getCapacity() {
    System.out.println("HDD`s capacity is " + capacity + "G.");
    return capacity;
  }
  public void work() {
    System.out.println("HDD设备开始运作");
  }
}

class SSD extends StorageDevice implements USB{
  public double getCapacity(){
    System.out.println("SSD`s capacity is " + capacity + "G.");
    return capacity;
  }
  public void work() {
    System.out.println("SSD设备开始运作");
  }
}

interface USB {
  public void work();
}

abstract class StorageDevice{
  protected double capacity;
  public StorageDevice(double capacity) {
    this.capacity = capacity;
  }
  public StorageDevice(){
    capacity = 256;
  }
  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }
  public abstract double getCapacity();
}
