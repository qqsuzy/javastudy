package pkg02_loop;

public class Class03_break {

  public static void main(String[] args) {
    
    // break : loop문을 종료한다.
    
    // 1 ~ 5 출력하기
    int n;
    
    // while 을 이용한 무한 루프 (추천!!)
    n = 1;
    while(true) {
      
      if(n > 5)
        break;
      
      System.out.println(n++);
      
    }
    
    // for 를 이용한 무한 루프 (초기상태 ; 반복조건 ; 상태변화 모든 것을 생략해준다.)
    n = 1;
    for(;;) {
      
      if(n == 6)
        break;
      
      System.out.println(n++);
      
    }    
    
  }

}
