package pkg07_constructor;

public class MainClass {

  /*
   * 생성자(constructor)
   * 1. 객체를 생성할 때 동작하는 메소드이다.
   * 2. new 키워드와 함께 사용된다.
   * 3. 특징
   *    1) 생성자는 클래스와 이름이 같다.
   *    2) 객체(또는 클래스)를 이용해서 호출하지 않는다.
   *    3) 반환 개념 자체가 없다.
   *    4) 매개변수(parameter) 처리는 일반 메소드와 동일하다. -> 생성자 오버로딩이 가능하다. (여러개 만들 수 있음)
   */
  
  /*
   * 디폴트 생성자
   * 1. 생성자가 없는 클래스는 자동으로 디폴트 생성자가 사용된다.
   * 2. 매개변수가 없고 본문에 실행 코드가 없는 형식이다.
   *  
   *  ex)  
   *    Computer(); {
   * 
   *  }
   */
  
  
  public static void main(String[] args) {

    // Computer1 객체 선언 및 생성 (+ 디폴트 생성자)
    Computer computer1 = new Computer(); // Computer() : 생성자, new와 반드시 세트로 같이 다녀야한다.
    computer1.develop();                 // 객체 생성
    computer1.danggeun();
    
    // Computer2 객체 선언 및 생성
    Computer computer2 = new Computer("gram", 200); //호출 : 인자를 주는 곳
    computer2.develop();
    computer2.danggeun();
    
    //computer3 객체 선언 및 생성 (model, price, calculator)
    // develop(), danggeun(), calculator의 add() 호출
    Computer computer3 = new Computer("macbook pro", 300, new Calculator()); // Calculator _calculator = new Calculator() 
    computer3.develop();
    computer3.danggeun();
    computer3.calculator.add();
    computer3.calculator.add(1);    
    computer3.calculator.add(1, 2);
    computer3.calculator.add(1, 2, 3);
   // 객체   . 필드     . 메소드
  }

}
