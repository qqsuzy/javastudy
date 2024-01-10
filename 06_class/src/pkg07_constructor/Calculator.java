package pkg07_constructor;

public class Calculator {

  // 덧셈 기능 추가
  void add(int...params) {
   
    int total = 0;
    
    if(params.length == 0) {
      System.out.println("합:" + total);
      return;
    }
    if(params.length == 1) {
      total = params[0];
      System.out.println("합:" + total );
      return;
    }
    System.out.println(params[0]);
    total = params[0];
    for(int i = 1; i < params.length; i++) {
      total += params[i];
      System.out.print("+" + params[i]);
    }
    System.out.println("=" + total);
    
  }
  
  
}
