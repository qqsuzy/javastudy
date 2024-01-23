package pkg02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class MainClass {

  /*
   * java.io.FileOutputStream
   * 1. ** 바이트 기반 ** 의 파일 출력 스트림이다. (byte 타입의 파일을 보낸다.) 출력 = 전송
   * 2. 출력 단위
   *     1) int    : 하나(1byte)만 보낼 때 int 를 사용
   *     2) byte[] : 여러 개를 내보낼 때 사용
   *   
   *  - 파일 출력 스트림 : 파일을 보내는 통로 
   *  - 파일 출력 스트림을 쓴다는 것은 파일을 만든다는 것이다.
   */
  
  /* *** 중요 ***
   * java.io.BufferedOutputStream
   * 1. 버퍼링을 지원하는 바이트 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다. (단독 사용이 불가능하다.)
   * 3. 버퍼링을 지원하므로 출력 속도가 향상된다. (쓰지 않을 이유가 없다.)
   */
  
  /*
   * java.io.DataOutputStream
   * 1. 자바 변수 값을 출력하는 바이트 출력 스트림이다. (변수를 그대로 보낼 수 있다.)
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 타입 별로 전용 메소드가 존재한다. 
   */
  
  /*
   * java.io.ObjectOutputStream
   * 1. 객체를 출력하는 바이트 출력 스트림
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 객체를 출력 스트림으로 전송하기 위해서는 직렬화 과정이 필요하다. (직렬화 : 객체를 byte 로 바꾸는 것, 우리가 만든 객체는 직접 직렬화를 해주어야 한다.)
   * 4. 직렬화 방법
   *    1) 직렬화할 클래스는 java.io.Serializable 인터페이스를 구현한다. (필수!)
   *    2) long serialVersionUID 필드 값을 임의로 생성한다.  
   */
  
  public static void method1() {
    
    // 무조건 생성 모드 : 기존에 파일이 있으면 지우고 다시 만든다.
    
    // 디렉터리
    File dir = new File("\\storage");
    if(!dir.exists()) {               // 없으면 만든다.
      dir.mkdirs();
    }
    
    // 파일
    File file = new File(dir, "sample1.dat");
    
    // 파일 출력 스트림 선언 (선언과 생성 분리)
    FileOutputStream out = null;
    
    // 파일 출력 생성은 예외처리가 반드시 필요하다.
    try {
      
      // 파일 출력 스트림 생성 (무조건 생성 모드 / 그냥 만들면 기존 파일을 덮어쓰고 생성한다.)
      // 1. IOException 발생 가능
      out = new FileOutputStream(file);    // sample1.dat 해당 파일로 보내는 스트림을 만들겠다.
      
      // 출력할 데이터
      int c = 'A';  // 알파벳 1개 = 1byte
      String str = "pple";
      byte[] b = str.getBytes();
      
      // 출력 (전송) 
      // 2. IOException 발생 가능
      out.write(c);    // 해당 부분에서 IOException이 발생될 수 있는데 그러면 밑에 코드들이 실행되지 않는다. 특히 출력 스트림 닫기(종료)
      out.write(b);
      
      // 플러싱 (선택 작업) : 미처 나가지 못한 파일을 내보내 주는 작업 (통로에 막혀있는 파일을 후~ 불어주는 것과 같다.)
      out.flush();
    
      // 확인 (파일 객체와 파일스트림 객체를 함께 생성하기를 권장한다!)
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
      
    } catch (Exception e) {  // catch 블록은 항상 채워주기 (비우면 품질 테스트 때 다 걸린다!)
      e.printStackTrace();
    } finally {
      
      // try 블록은 예외처리 가능, finally 블록은 예외처리 불가능 (예외처리란 try 블록을 말하는데 try 블록 안에 있어야 예외처리가 가능하기 때문이다.)
      // 이에 따라 out.close() 는 예외처리가 반드시 필요하기 때문에 finally 블록 안에도 try - catch 를 해줘야한다.
      try {
        
        // 파일 출력 스트림 닫기 (종료) : 항상 마지막에 선언
        if(out != null)   // (42열) 생성시 예외 발생이 될 수 있는데 그러면 out = null 값이 반환되어 finally 블록에 out.close() 도 null 값을 받는다 -> NullException이 발생되므로 추가로 if문 사용하여 out이 null이 아닐 때의 상황 고려하여 넣어줘야한다. (out != null) 
          out.close();
 
      } catch (Exception e2) {
        e2.printStackTrace();
      }
     
    }
    
  }

  public static void method2() {
    
    // 안녕하세요 반갑습니다 -> sample2.dat 파일로 보내기
    
    // 추가모드 : 기존에 파일이 없으면 새로 만들고 있으면 내용만 추가한다.
    
    File dir = new File("\\storage");
    if(!dir.exists())
      dir.mkdirs();
    
    File file = new File(dir, "\\sample2.dat");
    
    FileOutputStream out = null;
    
    try {
      
      out = new FileOutputStream(file, true);  // 파일 추가 생성을 위해서 true 값을 준다.
      
      String str = "안녕하세요 반갑습니다\n";
      byte[] b = str.getBytes();
      
      out.write(b);
      
      out.flush();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      
      try {
        
        if(out != null)
        out.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
      
    }
    
  }
  
  // ***** 안보고 작성할 수 있도록 연습하기 *****
  public static void method3() {
   
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir,"sample3.dat");
    
    // 버퍼 출력 스트림 선언
    BufferedOutputStream out = null;
    
    try {
      
      // 버퍼 출력 스트림 생성
      out = new BufferedOutputStream(new FileOutputStream(file)); // 기존 파일 출력 스트림에 버퍼만 끼운 것이며 속도가 향상되므로 함께 사용하자!
      
      // 출력할 데이터
      String str1 = "how do you do? nice to meet you\n";
      String str2 = "i'm fine thank you";
      
      // 출력
      out.write(str1.getBytes()); // byte[] 로 변환
      out.write(str2.getBytes());

      
      // 버퍼 출력 스트림 닫기
      out.close();
      
      // 확인
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  public static void method4() {
    
    File dir = new File("\\storage");
    
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "\\sample4.dat");
    
    // 데이터 출력 스트림 선언
    DataOutputStream out = null;
    
    try {
      
      out = (new DataOutputStream(new FileOutputStream(file)));
      
      // 출력할 데이터
      String name = "홍길동";
      int age = 10;
      double height = 140.5;
      boolean isAudult = (age >= 20);
      char gender = '남';
      
      // 출력
      out.writeUTF(name);  // String을 출력하는 방법은 총 3가지 이다. 1) writeUTF 2) writeBytes 3) writechars
      out.writeInt(age);
      out.writeDouble(height);
      out.writeBoolean(isAudult);
      out.writeChar(gender);
      
      // 데이터 출력 스트림 닫기
      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  
  public static void method5() {
    
    File dir = new File("\\storage");
    
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample5.dat");
    
    // 객체 출력 스트림 선언
    ObjectOutputStream out = null;
    
    try {
      
      // 객체 출력 스트림 생성
      out = new ObjectOutputStream(new FileOutputStream(file));
      
      // 출력할 객체
      Employee employee = new Employee(1, "홍길동");
      List<Employee> employees = Arrays.asList(new Employee(2, "홍길순"), new Employee(3, "홍순자")); // List<E> 초기화는 Arrays.asList()가 도와준다. 
      
      // 객체 출력
      out.writeObject(employee);
      out.writeObject(employees);
      
      // 데이터 출력 스트림 닫기
      out.close();
       
      // 출력 
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    method5();
    
  }
  
  public static void practice1() {
    
    // FileOutputStream 으로 애국가 1절 파일로 보내기 : 시간 재기 (System.nanoTime()) -> 작업 시작할 때, 끝난 후
    
    
    File dir = new File("\\storage");
    if(!dir.exists()) 
      dir.mkdirs();
   
    
    File file = new File(dir, "\\애국가1.dat");
    
    FileOutputStream out = null;
    
    try {
      
      out = new FileOutputStream(file);
      String str = "동해물과 백두산이 마르고 닳도록";
      
      long start = System.nanoTime();
      out.write(str.getBytes());
      long end = System.nanoTime();
      
      out.flush();
      
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.\n" + (end - start) + "ns " + "소요됨");
      
    } catch (Exception e) {
      e.printStackTrace();
    } 

  }
  
  public static void practice2() {
    
    // BufferedOutputStrema 으로 애국가 1절 파일로 보내기 : 시간 재기
    
    
    File dir = new File("\\storage");
    
    if(!dir.exists()) 
      dir.mkdirs();
    
    
    File file = new File(dir, "\\애국가2.dat");
    
    BufferedOutputStream out = null;
    
    try {
      
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      String str = "동해물과 백두산이 마르고 닳도록";
      
      long start = System.nanoTime();
      out.write(str.getBytes());
      long end = System.nanoTime();
      
      out.flush();

      out.close();
      
      System.out.println(file.length() + "바이트 크기의" + file.getPath() + "파일이 생성되었습니다.\n" + (end - start) + "ns " + "소요됨");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
 
    
  }
    



