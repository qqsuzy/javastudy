package practice03_Bus;

public class MainClass {

  public static void main(String[] args) {

    Seat seat1 = new Seat();
    seat1.fill(new Person());
    
    Seat seat2 = new Seat();
    seat2.fill(new Person());
    
    Bus bus = new Bus(25);
    bus.addseat(seat1);
    bus.addseat(seat2);
    bus.whoami();
    
  }

}
