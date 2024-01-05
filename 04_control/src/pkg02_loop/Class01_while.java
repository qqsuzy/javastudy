package pkg02_loop;

public class Class01_while {

  public static void main(String[] args) {
   
    /*
     * while
     * 1. 조건식을 만족하면 반복해서 실행한다.
     * 2. 형식
     *    while(조건식) {
     *      실행문
     *    }
     * 3. 특정값이 정해지지 않을 때 while문을 사용한다. (특정값이 정해져있으면 for문!)     
     */
    
    // 1, 2, 3, 4, 5 출력하기
    
    int n = 1; // 초기값
    
    while(n <= 5) { //반복 조건
      System.out.println(n);
      n++;          // 상태 변화
    }
    
    // 1 ~ 5 모두 더하기
    
    n = 1; 
    int total = 0; // 초기값을 주지 않으면 쓰레기값이 있기에 초기화 작업을 위해 초기값을 주어야 한다.
    
    while(n <= 5) {
      total += n;
      n++;
    }
    System.out.println(total);
    
    
  }

}
