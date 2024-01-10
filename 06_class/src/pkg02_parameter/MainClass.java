package pkg02_parameter;

public class MainClass {

  public static void main(String[] args) {
    
    // 객체 선언 및 생성 
    Calculator calculator = new Calculator();
    
    // 메소드 호출 (인수, 인자(argument), parameter를 가지고 있으며, 주는 곳이다.)
    // 호출하는 방법에 따라 구성이 달라짐?
    
    calculator.method1();
    
    int a = 10;
    calculator.method2(a);
    
    calculator.method3("hello world");
    
    calculator.method4(1.5, 1.2);
    
    calculator.method5(a);
    
    // 가변 인자 -> 가변 매개변수로 처리한다.
    // 인자의 갯수는 다르나 타입은 같다.
    calculator.method6(1);
    calculator.method6(1, 2);
    calculator.method6(1, 2, 3);
    
    // 배열 인자
    // int[] arr = {10, 20, 30};
    // calculator.method7(arr); // 1) {}중괄호 : 배열 초기화 (배열을 선언할 때 가능하다.)
    calculator.method7(new int[] {10, 20, 30}); //2) 선언하지 않고 바로 넘기고 싶을 때  -- 배열 초기화 방법 2가지
  
    // 객체 인자
    // 1.Adder 타입의 adder 객체를 전달
    //   Adder adder = new Adder(); - 객체가 만들어져 있지 않을 때 new로 객체를 만들어 전달해야 한다.
    //   calculator.method8(adder);
    // 2. Adder 타입의 객체를 전달
    calculator.method8(new Adder());
  }

}
