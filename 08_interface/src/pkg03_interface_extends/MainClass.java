package pkg03_interface_extends;

public class MainClass {

  public static void main(String[] args) {

    Elec elec = new SmartPhone();
    elec.powerOn();
    ((SmartPhone) elec).game();
    ((SmartPhone) elec).call();
    System.out.println();
    
    
    Computer computer = new SmartPhone();
    computer.powerOn();
    computer.game();
    ((SmartPhone) computer).call();
    System.out.println();
    
    Phone phone = new SmartPhone();
    phone.call();
    ((SmartPhone) phone).powerOn();
    ((SmartPhone) phone).game();
    System.out.println();
    
    // 업캐스팅을 사용하지 않으면 모든 메소드를 호출할 수 있다.
    SmartPhone smartPhone = new SmartPhone();
    smartPhone.powerOn();
    smartPhone.game();
    smartPhone.call();
     
  }

}
