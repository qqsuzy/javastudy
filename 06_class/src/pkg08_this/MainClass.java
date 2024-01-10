package pkg08_this;

// MainClass(외부) 에서의 객체명을 붙여서 사용한다. 
// 객체명 : computer  

public class MainClass {

  public static void main(String[] args) {

    Computer computer = new Computer(); // computer 객체의 참조 값을 가지고 있다.
    
    System.out.println(computer);
   // 결과 값
   // pkg09_this.Computer@6f2b958e
   //   this             @  참조값
    computer.showThis(); // ShowThis 를 호출한 객체는 computer 이므로 computer 는 this 이다.
    
    System.out.println(computer.model);
    computer.showModel();
  }

}
