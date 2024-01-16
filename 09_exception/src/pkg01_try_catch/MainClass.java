package pkg01_try_catch;

public class MainClass {
  
  public static void method1() {
    
    // 예외 처리가 발생하는 상황 (예외 처리를 안한 상황)
    
    String userInput = "123" ; 
    
    int number = Integer.parseInt(userInput);
    System.out.println(number);
    
  }

  public static void method2() {
    
    // 예외 처리 : try - catch
    
    try {  // try 블록 생성 (실행되는 영역)
      
      String userInput = "12.3";
      
      int number = Integer.parseInt(userInput); //NumberFormatException 발생되는 부분
      System.out.println(number);
      
    } catch(NumberFormatException ex) {  // catch 블록 생성 (파라미터가 존재함) : jvm이 자동으로 예외를 던지면 catch 블록이 받는다. (예외 처리반)
                                         // 예외처리 객체명은 대부분 e 또는 ex로 표기한다.
      System.out.println("정수만 입력하세요.");
      
    }
    
  }
  
  public static void mehtod3() {
    
    // 예외처리를 하지 않으면 프로그램이 끝까지 돌지 못한다.
    String[] userInputs = {"10", "20", "1.5", "2.5", "30" };
    
    for(int i = 0; i < userInputs.length; i++) {
      
      try {                                           // 실행하고 싶은 코드는 try 블록에 배치한다.
        
        int number = Integer.parseInt(userInputs[i]); // 배열에서 하나씩 꺼내서 넣는다.
        System.out.println(number);
        
      } catch(NumberFormatException e) {              // 예외 처리 코드는 catch 블록에 배치한다.
        
        System.out.println(userInputs[i] + "는 정수가 아닙니다.");
        
      }
      
    }
    
  }
  
  public static void method4() {
    
    // 다중 catch 블록 
    
    String[] userInputs = {"10", "20", "15", "25", "30" };
    
    try {
      
      for(int i = 0; i < 6; i++) {
        
        int number = Integer.parseInt(userInputs[i]); // userInputs[i] 부분에서 예외 발생 (userInpust[5] 실행되면서 발생된다.)
        System.out.println(number);
        
      } 
      
      // 다중 catch 블록을 잡아야할 때 상속관계에 따라서 달라질 수 있다. (상속 관계를 잘 확인하여야 한다!!)
      // 자식 -> 부모 타입순으로 catch 블록을 배치하여야 오류가 발생되지 않는다. 
    } catch(ArrayIndexOutOfBoundsException e) {   // catch 객체명은 다른 스코프에는 영향을 미치지 않기 때문에 다른 catch 블록과 동일하게 객체명을 지정하여도 된다.

      System.out.println("사용할 수 없는 인덱스가 사용되었습니다.");
    
    } catch (RuntimeException e) {
        
        System.out.println("정수만 처리할 수 있습니다.");
            
        
      }
      
    
  }
  
  public static void main(String[] args) {
    method4();
    
  }

}
