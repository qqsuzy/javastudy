package pkg06_throws;

public class MainClass {

  public static void main(String[] args) {

    int a = 5;
    int b = 0;
    
    try {
      
      Calculator calculator = new Calculator(); // 항상 클래스는 자동완성을 이용하자!
      calculator.addition(a, b);
      calculator.subtraction(a, b);
      calculator.multiplication(a, b);
      calculator.division(a, b); // 메소드를 호출한 영역 (throws 를 적용하면 예외를 호출 영역으로 던져서 받는다 -> 이후 catch 블록으로 던져서 예외처리를 한다.)
            
    } catch (ArithmeticException e) {
      System.out.println("산술 연산 예외가 발생했습니다.");
    }
    
    
  }

}
