package pkg01_object;

public class MainClass {
  
  public static void main(String[] args) {

    // 객체 선언 (객체이름은 클래스 이름과 동일하게 지정해주고, 첫 번째 글자는 소문자로 표기해주기)
    Calculator calculator;
    
    // 객체 생성
    calculator = new Calculator();
    
    // 객체를 이용해서 클래스의 멤버(필드, 메소드)를 사용할 수 있다.
    // 필드 + 메소드 = 멤버 
    // 멤버를 사용하기 위해서는 객체부터 생성한다. (만들지 않으면 사용하지 못한다.)
    // 객체.멤버
    
    calculator.number = 100;
    System.out.println(calculator.number);
    
    calculator.method();
    
  }

}
