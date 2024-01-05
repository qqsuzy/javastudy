package pkg02_loop;

public class Class02_for {

  public static void main(String[] args) {
    
    /*
     * for
     * 1. 조건식을 만족하면 반복해서 실행한다.
     * 2. 형식
     *    for ( 초기상태(값) ; 반복조건 ; 상태변화 ) {
     *      실행문
     *    }
     * 3. 실행 순서
     *    초기상태 -> 반복조건 -> 실행문 -> 상태변화 -> 반복조건 -> 실행문 -> 상태변화 -> ... // 초기상태는 최초 1번만 실행된다.    
     */
    
    // 1) 1, 2, 3, 4, 5 출력하기 (경우의 수 무한대)
    for(int n = 1; n <= 5; n++) {
      System.out.println(n);
    }
    
    // 2) n 번 반복하기 (위에 1번 예제 보다는 2번 예제의 경우 처럼 값의 범위를 정해서 사용하기를 매우 권장함!!)
    int n = 5;
    for(int i = 0; i < n; i++) { // i = 0 ~ 4 반복
      System.out.println("실행문");
    }
    
    // for 중첩
    for (int day = 1; day <= 5; day++) {
      System.out.println(day + "일차");
      for(int hour = 1; hour <= 8; hour++) {
        System.out.println(hour + "교시");
      }
        
    }
    
    
  }

}
