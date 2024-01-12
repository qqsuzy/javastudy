package pkg06_downcasting;

public class MainClass {

  public static void main(String[] args) {

    /*
     * 다운캐스팅
     * 1. (업캐스팅 된) 부모 타입의 객체를 자식 타입으로 바꿀 수 있다.
     * 2. 강제로 변환해야 한다.
     * 3. 잘못된 캐스팅의 우려가 있는데 이를 방지하기 위해서 instanceof 연산자를 사용할 수 있다.
     * 4. 업캐스팅의 문제점을 보완해준다. 업캐스팅으로 문제점이 발생되면 다시 다운캐스팅을 한다.
     */
    
    // 업캐스팅 된 부모 타입의 자식 객체
    Computer computer = new Tablet();
    
    // 잘못된 캐스팅을 방지하기 위한 instanceof 연산자
    // Tablet 타입으로 변환 (부모 타입을 자식 타입으로 강제변환)
    if(computer instanceof Tablet) { // computer 가 Tablet이 맞는지 확인
      ((Tablet) computer).screenTouch(); 
    }
    
    // 잘못된 다운캐스팅 (Wearable 타입으로 변환) - ClassCastException 예외 발생
    ((SmartWatch) computer).wearable();   
      
  }

}
