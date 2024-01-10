package pkg07_constructor;

public class Computer {

  // field
  String model;
  int price;
  Calculator calculator;
  
  // constructor (생성자가 없으면 디폴트 생성자를 쓰며, 있으면 디폴트 생성자를 쓰지 않는다.)
  // 생성자가 필요한 이유? : field 초기화
  Computer() {
    System.out.println("Computer()");
  }
  
  // 생성자 추가 : 객체 생성 방법을 추가하는 것
  // 객체 생성하는 방법은 여러 개 이다.
  Computer(String _model, int _price) { // "gram" 인자값을 준다 -> _model 인자 값을 받는다 -> model 필드에 저장한다 
    model = _model;
    price = _price;
  }
  Computer(String _model, int _price, Calculator _calculator) {
    model = _model;
    price = _price;
    calculator = _calculator;
  }
  
  // method
  void develop() {
    System.out.println(model + "이용해서 개발중");
  }
  
  void danggeun() {
    System.out.println(price / 100 * 60 + "원에 쿨거래");
  }
  
}
