package pkg03_return;

public class Calculator {

  // 반환값 : 메소드 실행 결과값
  // void : 반환값이 없음
  
  // int 반환 메소드
  int method1() {
    return 10; //return 다음에 오는 값은 반환 타입이 동일해야 한다.
  }
  
  // 배열을 반환하는 메소드 (반환 값이 2개 이상일 때) -- 1)배열에 저장해서 반환하던가 2)객체에 저장해서 반환하던가
  // int[] 반환 메소드 
  int[] method2() {
    //int[] arr = {10, 20};
    //return arr;
    return new int[] {10, 20};
  }
  
  // Adder 타입 객체 반환 메소드
  Adder method3() {
    
     //Adder adder = new Adder(); return adder; 아래와 같은 코드
     return new Adder();
    } 
  
}
