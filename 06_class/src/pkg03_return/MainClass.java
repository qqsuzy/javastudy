package pkg03_return;

public class MainClass {

  public static void main(String[] args) {
    
    // Calculator 타입의 calculator 객체 선언 및 생성
    Calculator calculator = new Calculator();
    
    // # 반환 값을 사용할 수 있는 알파코드가 필요하다.
    
    // 잘못된 호출이라고 볼 수 있음 (값을 받았으나 아무것도 하지 않았다.)
    calculator.method1(); // 호출 후에는 호출코드가 반환 값으로 바뀐다.
    
    // 반환값의 호출 예시
    System.out.println(calculator.method1()); // 반환 값을 출력/ 반환 값을 확인하는 코드
    System.out.println(calculator.method1() == 10 ? "십이다." : "십이아니다.");
    int a = calculator.method1(); // 반환 값 10을 받아서 a에 저장한다.
    System.out.println(a);
    
    // int[] 반환 받기 (호출할 때 반환 받는다.)
    int[] arr = calculator.method2();
    for(int n : arr) { // 동일한 스코프에서 동일한 변수 이름 선언 불가능
      System.out.println(n);
    }
    for(int n : calculator.method2()) {
      System.out.println(n);
    }
   
    // Adder 객체 반환 받기 (Adder 객체가 가지고 있는 add 변수 받기)
    System.out.println(calculator.method3().add(1, 2, 3));
    //                          new Adder().add(1, 2, 3) 
    // 메소드 호출 + 호출 = 메소드 체이닝
  }

}
