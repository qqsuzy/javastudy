package pkg07_Throwable_method;

// 기본 예외 메시지말고 직접 사용자 예외 메시지를 만들어서 사용하기를 권장한다!!

public class MainClass {
  

  public static void method1() {
    
    // 예외 메시지 확인하기 (기본 예외 메시지) : 예외마다 다른 기본 예외 메시지가 준비되어 있다.
    
    try {
                                //  <출력 메시지>
      // int a = 5 / 0;            -> / by zero
      Integer.parseInt("12.5"); // -> For input string: "12.5"
      
      
    } catch (Exception e) {
      
      System.out.println(e.getMessage()); // 객체에 포함된 메소드
      
    }
    
  }
  
  public static void method2() {
    
    // 예외 메시지 확인하기 (사용자 예외 메시지)
    
    try {
      
      int a = 5;
      int b = 0;
      
      if( b == 0) {
        throw new RuntimeException("0으로 나눌 수 없습니다.");
      }
      
      System.out.println(a / b);
      
    } catch (RuntimeException e) {
      
      System.out.println(e.getMessage());
      
    }
      
    }
    
  public static void method3() {
    
    // printStackTrace();
    // 예외 추적하기 : 개발할 때 사용
    
    try {
      
      int[] numbers = new int[] {1, 2, 3, 4, 5};
      int total = 0;
      
      for(int i = 1; i <= 5; i++) {
        total += numbers[i];
        
      }
      System.out.println(total);
            
    } catch(Exception e) {
      
      e.printStackTrace();
      
    }
    
  }
  
  public static void main(String[] args) {
    method3();
  }

}
