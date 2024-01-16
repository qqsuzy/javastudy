package pkg08_custom_exception;

/*
 * 사용자 예외 클래스
 * 1. java.lang.Exception 클래스를 상속한다. (import 할 필요 없는 클래스)
 * 2. 클래스명은 Exception 으로 끝나는 것이 좋다.
 */

public class MyException extends Exception { // 해당 클래스의 목적 > 메세지 외에 예외코드를 관리할 수 있도록 예외 클래스를 생성한다.

  // field
  private int errorCode;
  
  // constructor  
  public MyException(String message, int errorCode) { // 예외 사유, 에러코드를 받는 생성자
    super(message); // public Exception(String message) { } 생성자 호출 : 부모의 생성자를 부르고 메시지를 전달한다.
    this.errorCode = errorCode;
 
    
  }

  // method
  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
  
}
