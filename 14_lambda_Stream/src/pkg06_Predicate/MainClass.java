package pkg06_Predicate;

import java.util.function.Predicate;

public class MainClass {

  /*
   * java.util.function.Predicate
   * 
   * < 조건 체크에 사용>
   * 1. 형식
   *   public interface Predicate<T> {  // 제네릭 타입 : 반환은 있지만 boolean 타입
   *     boolean test(T t);
   *     
   * 2. 파라미터 O, 반환 boolean 형식의 test() 메소드를 지원하는 함수형 인터페이스이다.
   *    -> 반환 값은 꼭 true , false 이어야 한다.      
   */
 
  public static void method1() {
    
    Predicate<Integer> isEvenNumber = (number) -> number % 2 == 0;
    if(isEvenNumber.test(6)) {
      System.out.println("짝수");
    } else {
      System.out.println("홀수");
    }
    
  }
  
  public static void method2(Predicate<Integer> predicate, int number) {
    if(predicate.test(number)) {
      System.out.println("짝수");
    } else {
      System.out.println("홀수");
    }
    
  }
  
  public static void main(String[] args) {

    method1();
    method2((number) -> number % 2 == 0, 5);
  }

}
