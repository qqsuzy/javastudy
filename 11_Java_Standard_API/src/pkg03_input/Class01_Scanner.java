package pkg03_input;

import java.util.Scanner;

public class Class01_Scanner {

  /*
   * java.util.Scanner
   * 1. 데이터를 읽을 때 사용한다.
   * 2. 주로 표준 입력 스트림(System.in - 키보드를 의미함)으로부터 데이터를 입력 받는다.
   * 3. 데이터 타입에 따라 사용하는 메소드가 다르다.
   *    1) next()           : 공백 없는 문자열 입력
   *    2) nextLine()       : 공백 포함된 문자열 입력
   *    3) nextInt()        : int 입력
   *    4) nextLong()       : long 입력
   *    5) nextDouble()     : double 입력
   *    6) nextBoolean()    : boolean 입력
   *    7) next().chatAt(0) : char 입력   -> 전용 문자가 없어서 커스텀해서 사용한다.
   * 
   * 스트림(stream) : 데이터를 입력받는 통로로 생각하면 된다.  
   *                  사용 후 닫아주는 작업이 필요하다.       -> close()
   *                  AutoCloseable 로 닫지 않아도 Java 에서 알아서 닫아준다. (클래스가 많아지면 언제 닫아야할 지 확인하기 어려운 상황이 발생되는데 그 때는 쿨하게 닫지 말기)
   *                  
   *                  
   *                  try - catch 가 없으면 close()가 되지 않는 경우도 있다. (다음 장에서 선생님이 다시 설명 예정)
   * 
   */
  
  public static void main(String[] args) {

    // Scanner 객체 선언 및 생성
    Scanner sc = new Scanner(System.in); // inputstream source : 입력받을 때 사용하는 객체 / system.out은 출력할 때 사용, system.in은 입력할 때 사용
    
    // String 입력
    System.out.println("이름을 입력하세요 >>>");
    String name = sc.next();                    // 입력된 결과를 String으로 반환해주고 name 변수에 저장
    
    // int 입력
    System.out.println("나이를 입력하세요 >>>");
    int age = sc.nextInt(); // 사용자가 int를 입력하지 않으면 예외가 발생된다. (InputMismatchException)
    
    // double 입력
    System.out.println("키를 입력하세요 >>>");
    double height = sc.nextDouble();
    
    // char 입력
    System.out.println("성별을 입력하세요(남/여) >>>");
    char gender = sc.next().charAt(0);  // 길게 입력해도 첫번째 글자만 받아서 쓴다. (남자, 여자 / 남성, 여성 ...)
    
    // 확인
    System.out.println(name);
    System.out.println(age);
    System.out.println(height);
    System.out.println(gender);
    
    // 닫기 (생략 가능)
    sc.close();
    
  }

}
