package pkg03_Supplier;

import java.util.function.Supplier;

public class MainClass {

  /*
   * java.util.function.Supplier
   * 1. 형식
   *    public interface Supplier<T> {    // 제네릭 타입 : Supplier 가 반환 타입을 전달. (반환 타입을 바꿀 수 있다.)
   *      T get();                        // 추상 메소드 : 항상 get() 메소드를 사용하면 값이 나온다.
   *    }
   * 2. 파라미터 X, 반환 O 형식의 get() 메소드를 지원하는 함수형 인터페이스이다.   
   */
  
  public static void method1() {
    
    Supplier<String> supplier = () -> "hello world";
    System.out.println(supplier.get());
    
  }
  
  // ***** 권장 *****
  public static void method2(Supplier<String> supplier) {  // Supplier 을 생성하지 않고 파라미터를 Supplier로 선언 ->  값을 반환하는 람다를 준다.
    
    System.out.println(supplier.get());
    
  }
  
  public static void method3(Supplier<Integer> supplier) {
    
    System.out.println(supplier.get());
    
  }
  
  public static void main(String[] args) {

    // method1();
    
    method2(() -> "hello world");
    /*
    Supplier<String> supplier = () -> "hello world";      // 위와 같은 코드
    method2(supplier);
    */
    
    // 호출할 때 마다 1 ~ 10 사이 난수를 출력하는 method3(); 
    method3(() -> (int)(Math.random() * 10 + 1));
    
  }

}
