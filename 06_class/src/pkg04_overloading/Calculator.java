package pkg04_overloading;

public class Calculator {
  
  /*
   * 메소드 오버로딩
   * 1. 동일한 클래스에 같은 이름의 메소드가 2개 이상 존재하는 것을 의미한다.
   * 2. 메소드 오버로딩 규칙
   *    1) 같은 이름의 메소드 ex) add
   *    2) 다른 parameter (개수 또는 타입)
   *       
   *    
   *    ex)
   *    int add() {return 1;}
   *    double add() {return 1.5}
   *    - 메소드 오버로딩이 아니다.
   *    - 이유는 반환 타입은 다르지만 parameter 타입이 같기 때문이다. 
   *      (반환 타입은 같거나 달라도 된다.)
   *    
   */

  void add(Adder adder, int...params) { // Adder로 매개변수 전달
    System.out.println(adder.add(params));
  }
  
  void add(Adder adder, double...params) {
    System.out.println(adder.add(params));
  }
  
}
