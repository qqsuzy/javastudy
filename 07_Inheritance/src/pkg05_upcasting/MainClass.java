package pkg05_upcasting;

public class MainClass {

  public static void main(String[] args) {

    /*
     * 업캐스팅                                           (캐스팅 = 강제 형변환)
     * 1. 자식 타입의 객체를 부모 타입으로 바꿀 수 있다.
     * 2. 자동으로 변환된다.
     * 3. 부모가 가진 멤버만 호출할 수 있다.
     * 
     *  부모에게 자식을 저장하기 위한 타입을 만드는 것이다.
     *  타입은 부모인데 자식인 객체
     */
    
    // 부모 타입 선언
    Computer computer;
    
    // 자식 타입 생성
    computer = new Tablet(); // Tablet을 computer에 저장 -> 자동 변환
    
    // 부모 타입으로 변환되면 부모의 메소드만 호출할 수 있다. (screenTouch , partable 호출 불가능)
    computer.internet();
    computer.game();
    

    
    
  }

}
