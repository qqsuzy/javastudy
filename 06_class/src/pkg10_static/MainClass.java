package pkg10_static;

public class MainClass {

  public static void main(String[] args) {

    // 클래스 멤버 호출 : 클래스.멤버
    // 클래스 이름으로 호출된 멤버(필드, 메소드)는 글자가 기울어져 있다.
    System.out.println(Calculator.maker);
    
    Calculator.add(1, 3);
    
  }
 
}
