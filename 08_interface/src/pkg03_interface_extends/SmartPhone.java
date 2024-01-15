package pkg03_interface_extends;

/*
 * 인터페이스 다중 구현
 * 1. 다중 상속은 불가능하지만, 다중 구현은 가능하다. (다중 구현을 통해서 다중 상속
 * 2. implements 키워드 뒤에 구현할 인터페이스를 모두 명시한다.
 * 
 * 클래스가 발전된 형태가 인터페이스이다.
 * 인터페이스의 구현 클래스는 인터페이스의 타입으로 선언하는 것을 추천한다.
 */

// Computer 가 Elec의 
public class SmartPhone implements Computer, Phone {

  @Override
  public void powerOn() {
    // TODO Auto-generated method stub
    System.out.println("powerOn()");
    
  }

  @Override
  public void call() {
    // TODO Auto-generated method stub
    System.out.println("call()");
  }

  @Override
  public void game() {
    // TODO Auto-generated method stub
    System.out.println("game()");
  }

  
  
}
