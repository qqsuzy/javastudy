package pkg01_lambda_expr;

/*
 * Lambda Expression (람다 표현식)
 * 1. Anonymous Inner Type 객체를 생성할 때 사용할 수 있는 새로운 표현식이다.
 * 2. 추상 메소드가 1개인 인터페이스(함수형 인터페이스)에서 사용할 수 있다.
 * 3. interface A { void method(int number); }
 * 
 *    1) Anonymous Inner Type
 *      A a = new A() {
 *      @Override
 *      void method(int number) { }
 *     }; 
 *     
 *    2) Lambda Expression              // 추상 메소드가 1개이기 때문에 () { } 부분만 살리고 나머지는 생략한다.
 *      A a = (number) -> { }
 */

/*
 * 메소드 형식에 따른 Lambda Expression
 * 
 * 1. 파라미터 X, 반환 X 
 *    interface A {  void method();  }
 *    1) A a = () -> { 
 *               본문 
 *               }
 *    2) A a = () -> 본문       // 본문 내용이 1개인 경우 중괄호 {}를 생략할 수 있다.
 *    
 * 2. 파라미터 X, 반환 O
 *    interface A { String method(); }
 *    1) A a = () -> {
 *               본문
 *               return 문자열
 *              }
 *    2) A a = ()  -> 문자열     // 본문 내용이 return 만 있는 경우 중괄호 {}와 return 키워드를 생략할 수 있다.
 *     
 * 3. 파라미터 O, 반환 X
 *    interface A { void method(String name); }
 *    1) A a = (name) -> {
 *               본문
 *              } 
 *    2) A a = (name) -> 본문    // 본문 내용이 1개인 경우 중괄호 {}를 생략할 수 있다.   
 *     
 * 4. 파라미터 O, 반환 O
 *    interface A { String method(String name); }
 *    1) A a = (name) -> {
 *               본문
 *               return 문자열
 *            }
 *    2) A a = (name) -> 문자열  // 본문 내용이 return 만 있는 경우 중괄호 {}와 return 키워드를 생략할 수 있다.
 *        
 */

public class GasStation {

  // field
  private int totalOil;         // 가지고 있는 기름
  private int chargePerLiter;   // 리터 당 요금
  private int earning;          // 주유소 매출
  
  // method
  public void sellOil(String model, int oil) { // 기름을 팔 때 마다 모델명, 오일
    // Car car 객체 생성 (Anonymous Inner Type)
    /*
    Car car = new Car() {
      
      @Override
      public void addOil() {
        totalOil -= oil;
        earning += oil * chargePerLiter;
        System.out.println(model + " 차량 " + oil + "L 주유 완료");
        
      }
    };
    */
    
    // Car car 객체 생성 (Lambda Expression)
    // 파라미터 X, 반환 X 
    Car car = () -> {
      totalOil -= oil;
      earning += oil * chargePerLiter;
      System.out.println(model + " 차량 " + oil + "L 주유 완료");
      
    };
    
    // addOil() 메소드 호출
    car.addOil();
  }
  
  public int getTotalOil() {
    return totalOil;
  }
  public void setTotalOil(int totalOil) {
    this.totalOil = totalOil;
  }
  public int getChargePerLiter() {
    return chargePerLiter;
  }
  public void setChargePerLiter(int chargePerLiter) {
    this.chargePerLiter = chargePerLiter;
  }
  public int getEarning() {
    return earning;
  }
  public void setEarning(int earning) {
    this.earning = earning;
  }
  
 
  
  
}
