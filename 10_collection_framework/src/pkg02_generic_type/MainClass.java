package pkg02_generic_type;

public class MainClass {

  public static void main(String[] args) {

    // Integer 저장용 Container
    Container<Integer> container1 = new Container<Integer>();
    container1.setItem(10); // setter 호출 시 자동완성 기능에 객체 타입 확인하기!
    System.out.println(container1.getItem());
    
    // String 저장용 Container
    Container<String> container2 = new Container<>(); // 생성자 부분의 <> 타입은 생략가능하다. (앞부분 타입 선언은 생략 불가능!)
    container2.setItem("hello");
    System.out.println(container2.getItem());
    
  }

}
