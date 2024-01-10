package pkg10_static;

//instance(object)
//instance member : 인스턴스 마다 값이 다른 애들 
//class member    : 
//static : class member 만들 때 사용 , class 로 멤버를 호출 한다. ex) class.method()
  
  /*
   * 메모리 공간 할당 과정
   * 
   * - 실행 했을 때 메모리의 동작 순서(f11)
   * 클래스 영역(메소드 영역) -> 스택 영역 -> 힙 영역
   * 클래스 로드                 변수         배열, 인스턴스(객체)
   */
    
  /*
   * 클래스 멤버
   * 1. 클래스 영역에 저장되는 멤버이다.
   * 2. 인스턴스의 생성이 없어도 접근이 가능하다.
   * 3. 클래스 메소드에서는 클래스 멤버만 호출할 수 있다. (인스턴스 멤버는 호출할 수 없다.)
   * 4. 호출 방법
   *    1) 클래스.멤버 - 추천!
   *    2) 인스턴스.멤버 - 가능하지만 비추천
   */

  // Singleton (static 사용)
  // 클래스 하나 당 객체를 하나만 만들어야 하는 경우 : DB 접근
  // 데이터의 신뢰도에 문제가 생기기 때문이다.

public class Calculator {

  // 상수 (final 과 static 이 세트로 다니며, 앞에 일반적으로 public(접근 제어자) 처리를 한다.
  public final static String maker = "samsung";
  
  // 클래스 메소드
  public static void add(int a, int b) {
    System.out.println(a + "+" + b + "=" + (a + b));
    
  }
  
      
}
