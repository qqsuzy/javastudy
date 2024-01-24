package pkg04_Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {

  /*
   * java.io.fileWriter
   * 1. 문자 기반의 파일 출력 스트림 (문자가 아니면 보낼 수 없다.)    출력 = 전송
   * 2. 출력 단위
   *    1) int      - 한 글자를 보낸다. EOF (-1) 처리를 위해서 int 타입을 사용하는 것
   *    2) char[]   - 여러 글자를 보낸다.
   *    3) String   - 여러 글자를 보낸다.
   */

  /*
   * java.io.BufferedWriter
   * 1. 버퍼링을 지원하는 문자 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용한다.
   * 3. 특장점
   *    1) 버퍼링을 지원하므로 출력 속도가 향상된다. 
   *    2) 줄 바꿈을 위한 newLine() 메소드가 있다. 
   */
  
  /*
   * java.io.PrintWriter
   * 1. print 메소드(print, println, printf)를 지원하는 문자 출력 스트림이다.
   * 2. 메인 스트림 또는 보조 스트림으로 사용할 수 있다.  (혼자 쓸 수도 있고, 다른 스트림과 함께 사용이 가능하다.)
   * 3. 바이트 기반 스트림인데 한글을 입출력 받고 싶을 때 사용이 가능하다. (OutputStream, InputStream)
   */
  
  public static void method1() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "smaple1.txt");
    
    // 파일 출력 스트림 선언
    FileWriter out = null;    
    
    try {
      
      // 파일 출력 스트림 생성, 생성 모드 (파일을 항상 새로 만든다.) - 기본 생성 모드
      out = new FileWriter(file);
      
      // 출력(전송)할 데이터
      int ch = '대';
      char[] chArr = {'한', '민'};
      String str = "국";
      
      // 출력
      out.write(ch);
      out.write(chArr);
      out.write(str);
      
      // 파일 출력 스트림 닫기
      out.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  } 
  
  public static void method2() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "smaple2.txt");
    
    // 버퍼 출력 스트림 선언
    BufferedWriter out = null;
    
    try {
      
      // 버퍼 출력 스트림 생성, 추가 모드(파일이 없으면 새로 만들고 파일이 있으면 내용만 추가한다.)
      out = new BufferedWriter(new FileWriter(file, true));
    
      // 출력할 데이터
      out.write("안녕하세요");
      out.newLine();            // 줄바꿈 메소드
      out.write("반갑습니다");
      out.newLine();
      out.write("나는 민수지라고 합니다");
      out.newLine();
      out.write("너는?");
      out.newLine();
      
      // 버퍼 출력 스트림 닫기 
      // 보조 스트림 사용할 때는 보조스트림만 닫는다. -> 메인 스트림은 자동으로 닫아준다.
      out.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }   
    
  }
  
  public static void method3() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample3.html");
    
    // PrintWriter 선언
    PrintWriter out = null;
    
    try {
      
      // PrintWriter 생성
      out = new PrintWriter(file);
      
      // 출력
      out.println("<script>"); // 자동으로 줄바꿈이 되는 출력 메소드
      out.println("alert('안녕');");
      out.println("</script>");
      
      // PrintWriter 닫기
      out.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }  
    
  }
  
  public static void main(String[] args) {

    method3();
    
  }

}
