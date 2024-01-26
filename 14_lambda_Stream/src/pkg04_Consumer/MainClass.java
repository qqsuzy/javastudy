package pkg04_Consumer;

import java.util.function.Consumer;

public class MainClass {

  /*
   * java.util.function.Consumer
   * 
   * 1. 형식
   *   public interface Consumer<T> {  // 제네릭 타입 : Consumer 값을 받기만 한다.  , Supplier 는 공급자
   *     void accept(T t);
   *     
   * 2. 파라미터 O, 반환 X 형식의 accept() 메소드를 지원하는 함수형 인터페이스이다.      
   */
  
  public static void method1() {
    
    Consumer<String> consumer = (hobby) -> System.out.println(hobby); 
    consumer.accept("수영");   // "수영" -> hobby -> System.out.println(hobby) 로 간다. hooby는 변수명
    
  }
  
  public static void method2(Consumer<String> consumer) {  // 람다를 전달하면 함수형 인터페이스가 받는다.
    consumer.accept("수영");
  }
  
  public static void main(String[] args) {
    method1();
    method2((hobby) -> System.out.println(hobby));
    
  }

}
