package pkg01_extends;

/*
 *  자식 클래스 만드는 법
 *  calss 자식 extends 부모 { }
 *  class 서브 extends 슈퍼 { }
 *  
 *  1. 부모는 하나이며 다중 상속이 안된다.
 *  2. 상속으로 인해서 부모 클래스인 Car 의 메소드 3개를 자식 클래스인 Ev가 모두 사용할 수 있다.
 *  3. 접근제어자 중 private는 자식 클래스가 접근이 불가능하지만 protected 는 가능하다.
 */

public class Ev extends Car {

  public void charge() {
   //  System.out.println(model); // 부모의 private 에서 접근 불가
    System.out.println(maker);    // 부모의 protected 에는 접근 가능
    System.out.println("충전");
  }
  
}
