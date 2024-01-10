package pkg09_access_modifier;

public class MainClass {

  public static void main(String[] args) {

  // computer 객체 선언 및 생성
  Computer computer = new Computer("galaxybook", 400, new Calculator());
  
  //model 필드값의 접근제어가 private로 직접 접근이 불가능하나 간접 접근이 가능하다.
  System.out.println(computer.getModel()); 
  
  // 1) 필드로 값을 전달하는 메소드
  //   : 다른 클래스에서 필드 값을 전달   set필드명
  computer.setModel("gram");
  computer.setPrice(200);
  computer.setCalculator(new Calculator());
  
  
  // 필드값을 가져오는 메소드  get필드명
  System.out.println(computer.getModel());
  System.out.println(computer.getPrice());
  //calculator의 add() 호출하기
  computer.getCalculator().add();
  computer.getCalculator().add(1);
  computer.getCalculator().add(2, 3);
  computer.getCalculator().add(4, 5, 6);
 
  }
  
  // 2) 외부에서 필드 값을 확인 (입출력이 필요함)
}
