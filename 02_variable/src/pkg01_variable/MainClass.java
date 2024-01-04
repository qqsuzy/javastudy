package pkg01_variable;

public class MainClass {

  public static void main(String[] args) {
    
    /*
     * 메모리 
     * 
     * 1. 램(RAM) 
     * 2. 자바 프로그램이 동작하기 위한 모든 것이 저장되는 장소이다.
     * 3. 변수도 메모리에 생성된다.
     * 4. 1Byte 마다 16진수로 된 고유의 번호를 부여해서 관리한다.
     *    1) 주소값
     *        (=)
     *    2) 참조값 
     *    3) 16진수 작성 예시 : 0x123abc456 (알파벳 a ~ f 까지)
     */
     
    /*
     * 식별자의 이름 규칙
     * 1. Pascal Case : 각 단어의 첫 글자는 대문자, 나머지는 소문자 (클래스)
     * 2. Camel Case  : Pascal Case와 동일하지만, 첫 글자는 소문자  (메소드, 변수)
     * 3. Snake Case  : 각 단어의 연결을 밑줄(_)로 하는 방식        (상수) -> 대소문자 섞어서 사용하지 않는다.
     */
    
    /*
     * 사용 가능한 식별자
     * 1. 영문
     * 2. 한글
     * 3. 숫자 (숫자로 시작은 불가능)
     * 4. 특수문자 ( _ , $ )
     */
    
    /*
     * 변수
     * 1. 어떤 값을 저장하기 위해 메모리에 할당된 저장소를 의미한다.
     * 2. 변수를 선언한 뒤 사용할 수 있다.
     * 3. 저장하려는 데이터의 종류에 따라 2가지로 구분한다.
     *    1) 기본 자료형(타입)
     *       (1) 값 자체를 저장하는 RAW DATA 타입
     *       (2) 8가지 타입이 제공
     *          byte, short, int, long, float, double  : 숫자
     *          char, boolean                          : 문자
     *    2) 참조 자료형(타입)
     *       (1) 값이 저장된 참조값을 저장하는 REFERENCE DATA 타입이다.
     *       (2) 기본 자료형을 제외한 모든 데이터는 참조 자료형이다.
     *       ex) 문자열, 날짜 등 - 클래스(class) 로 저장된다. 
     *           문자열은 java에서 특별관리 대상이라 기본 자료형으로 사용할 수 있게 제공한다. (String)
     */
    
    // 변수 선언
    
    // byte : 1바이트 정수
    byte myFirstVariable = 127; // -128 ~ 127 까지 가용된다.
    System.out.println(myFirstVariable); // 단축키 : sysout + ctrl + space
    
    // short : 2바이트 정수
    short a = 32765;
    System.out.println(a);
    
    // int : 4바이트 정수 --> java 에서 권장하는 일반적인 변수값
    int b = 100; // -21억 ~ 21억
    System.out.println(b);
    
    // long : 8바이트 정수 --> int로 저장되지 않는 변수는 long으로 저장한다. (현존하는 값들은 대부분 다 저장 가능하다.)
    long c = 10000000000L; // long 타입의 변수는 L(대문자)을 붙일 수 있다.
    System.out.println(c);
    
    // float : 4바이트 실수 --> 소수점(.)이 붙으면 8바이트 (잘 사용되지 않음)
    float d = 1.1F;
    System.out.println(d);
    
    // double : 8바이트 실수
    double f = 1.1;
    System.out.println(f);
    
    // char : 2바이트 문자 (1글자만 저장 가능)
    char ch = '\\';
    System.out.println(ch);
    
    /*
     * 이스케이프 시퀀스
     * 1. 역슬래시로 시작하는 특수 문자를 의미한다.
     * 2. 종류
     *    1) 줄 바꿈 : \n 
     *    2) 탭(Tab) : \t
     *    3) 따옴표
     *      (1) \'
     *      (2) \"
     *    4) 역슬래시 : \\      
     */
    // boolean : 논리값 (true, false)
    boolean isAlive = false;
    System.out.println(isAlive);
    
    /*
     * 변수의 스코프(scope)
     * 1. 변수의 가용 범위를 의미한다.
     * 2. 변수가 선언된 코드 블록(중괄호,{}) 내에서만 사용할 수 있다.
     */
    
    // 소스코드 이동 단축키 : alt + 방향키
    {
      int x = 10;
      System.out.println(x);
    }
    // System.out.println(x); 접근 불가능하다.
    
    /*
     * 상수
     * 1. Constant Variable
     * 2. 값을 바꿀 수 없는 변수이다.
     * 3. 상수 선언 규칭
     *    1) final 키워드를 추가한다.
     *    2) 반드시 초기값을 지정한다.
     *    3) 관례상 대문자로 작성한다.
     */
    final double PI = 3.141538;
    // PI = 3.14; 값을 수정할 수 없다.
    System.out.println(PI);
    
    /*
     * String 클래스
     * 1. 문자열을 관리하는 클래스이다.
     * 2. 문자열을 저장하는 타입으로 사용한다.
     * 3. 참조 자료형이지만 마치 기본 자료형처럼 쉬운 사용을 제공한다. (기본 자료형 + 참조 자료형의 특징을 가지고 있다.)
     *    참조자료형은 변수에 바로 저장되는 것이 아닌 참조값에 저장되어 그 값을 불러온다.
     */
    String s ="hello world";
    System.out.println(s);
  }

}
