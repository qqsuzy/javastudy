 package pkg05_void_return;

public class Calculator {

  // ★ 중요 ★
  // 반환타입이 void 인 경우에는 retrun; 코드로 메소드 실행을 중지할 수 있다.
  // 예외 처리 시 매우 많이 쓰인다. (if else 보다 void + return 조합 권장함!!!!)
  
  void root(int number) { // 반환 타입(retrun)이 없는 메소드 , number : root 안에 들어가는 숫자
    
    if(number <= 0) {
      System.out.println(number + "는 제곱근을 계산할 수 없습니다.");
      return;
    } 
    
    System.out.println(number + "의 제곱근은" + Math.sqrt(number) + "입니다.");
    
    
    }
  
}
