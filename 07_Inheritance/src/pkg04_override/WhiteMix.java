package pkg04_override;

// 메소드 오버라이드
// 1. 자식 클래스가 부모 클래스의 메소드를 다시 만드는 것이다. (부모의 메소드를 자식이 쓸 수 없는 경우)
// 2. 메소드 앞에 @Override annotation(@) 을 추가한다.  
// 3. 똑같이 (반환타입, 메소드명, 매개변수) 만들어야 한다. 
//   ex) void color()

// 4. 오버라이드를 추가하지 않아도 상관은 없긴 하나 (동작을 안하지는 않는다.) 문법 체크를 해주어 틀린 부분을 찾아내준다.
// 5. 직접 입력하지 않고 이클립스 기능을 활용해서 Source -> Override 로 원하는 메소드에 추가할 수 있다.

// 기술면접 단골 문제 : overloading vs Override

public class WhiteMix extends Karn {

  @Override // 오버라이드한 메소드라고 JVM에게 알려준다. (부가적으로 다른 개발자에게도 알려준다. 권장!!)
  public void color() {
    System.out.println("커피색");
  }
  
}
