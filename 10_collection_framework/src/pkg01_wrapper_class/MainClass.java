package pkg01_wrapper_class;

public class MainClass {

  public static void main(String[] args) {

    // Auto Boxing (기본 타입 값 -> Wrapper 타입 저장)
    
    Integer num = 10; // 타입이 Integer 이며, 참조타입이다.
    
    // Auto Unboxing (Wrapper 타입 값 -> 기본 타입)
    int iNum = num;
    
    System.out.println(iNum);
    
  }

}
