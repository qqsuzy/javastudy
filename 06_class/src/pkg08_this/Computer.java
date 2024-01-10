package pkg08_this;

// 해당 computer (내부) 클래스 내에서 멤버를 호출 할 때  this(객체)를 사용한다. 
// this = computer

public class Computer {
  
  String model;
  int price;
  
  // this 의 활용방법
  // this() : 생성자를 호출하는 것
  // this.멤버 : 멤버(필드, 메소드)를 호출하는 것 ★★★★ 
  Computer() {    // 생성자1
    this(null, 0); // 생성자를 호출함 | parameter 2개, 인자값 2개
  }
  
  Computer(String model) { // 생성자2
    this(model, 0);
  }
  
  // 모든 객체의 호출은 생성자3가 담당한다. 인자 값이 1개가 들어와도 2개가 들어와도 생성자3로 가서 호출된다. 생성자1로 들어와서 생성자3로 전달 됨 (소스코드의 유지보수를 위해서)
  Computer(String model, int price) { // 생성자3 
    this.model = model;
    this.price = price; // 매개변수와 필드명은 같아도된다. this로 구분하고 this로 호출한다.
  }
  
  
  public void showThis() {
    System.out.println(this); // this : 현재 객체 (showTis() 메소드를 호출한 객체) 를 의미함
  }
  
  public void showModel() {
    System.out.println(this.model); 
  }

}
