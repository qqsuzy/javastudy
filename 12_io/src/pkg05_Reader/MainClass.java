package pkg05_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

  /*
   * java.io.FileReader
   * 1. 문자 기반의 파일 입력 스트림이다.
   * 2. 입력 단위
   *    1) int 
   *    2) char[]
   *    3) String               -- 입력 단위는 출력과 동일하다
   */
  
  /*
   * java.io.BufferedReader
   * 1. 버퍼링을 지원하는 문자 입력 스트림이다.
   * 2. 보조 스트림으로 메인스트림과 함께 사용해야 한다. (단독 사용 불가능)
   * 3. 버퍼링을 지원하므로 입력 속도가 향상된다.
   * 4. 한 줄씩 읽는 readLine() 메소드가 있다.  (BufferedReader 스트림을 사용해야만 사용가능한 메소드!)
   */
  
  /*
   * java.io.InputStreamReader
   * 1. 바이트 입력 스트림을 문자 입력 스트림으로 변환한다.
   * 2. 바이트 입력 스트림으로 문자 데이터가 전달되는 경우 사용한다.
   */
  
  /*
   * InputStream에 포함된 문자를 안 깨지고 잘 받기
   * 1. InputStreamReader를 사용한다.
   * 2. DataInputStream을 사용한다.
   */
  
  // 서버가 지원하는 출력 스트림은 바이트 기반 스트림 뿐이다. (바이트 기반으로 동작)
  // 상호간의 변환이 필요하며, InputStream -> FileReader
  // 바이트 기반으로 읽어서 문자로 변환해주는 작업이 필요하다.
  
  public static void method1() {
    
    File dir = new File("\\storage");
    File file = new File(dir,"smaple1.txt");
    
    // 파일 입력 스트림 선언
    FileReader in = null;
    
    try {
      
      // 파일 입력 스트림 생성
      in = new FileReader(file);
      
      // 읽는 단위
      char[] cbuf = new char[2];  // 2글자씩 읽어온다.
      
      // 읽은 데이터 저장소
      StringBuilder builder = new StringBuilder();  // StringBuilder를 사용해서 2글자씩 append 해준다.
           
      // 읽은 글자수
      int readChar = 0;
      
      // 읽기
      while(true) {
        readChar = in.read(cbuf);           // 2글자씩 읽어서 readChar에 저장한다.
        if(readChar == -1) {
          break;
        }
        builder.append(cbuf, 0, readChar);  // chuf[0] 부터 readChar만큼 builder에 추가
      }
      
      // 확인
      System.out.println(builder.toString());   // StringBuilder 사용했으면 출력할 때 toString() 메소드로 문자열로 변환한다.
      //System.out.println(in.read(cbuf));
      
      // 파일 입력 스트림 닫기
      in.close();     
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void method2() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample2.txt");
    
    // 버퍼 입력 스트림 선언
    BufferedReader in = null;
    
    try {
      
      // 버퍼 입력 스트림 생성
      in = new BufferedReader(new FileReader(file));
      
      // 읽는 단위 (한 줄씩) 
      String line = null;          // 모든 클래스 타입의 객체는 없으면 null값을 가진다.
      
      // 읽은 데이터 모으기
      StringBuilder builder = new StringBuilder();
      
      // readLine() 메소드는 파일에 끝에 도달하면 null 반환
      /*
      while(true) {
        line = in.readLine();
        if(line == null) {
          break;
        }
        builder.append(line).append("\n");    // 읽은 데이터를 builder에 모아라, 줄바꿈을 원할 땐 "\n" 를 append 한다.
      }
      */
      while( (line = in.readLine()) != null ) { // null이 아니면 반복문을 돌려라
        builder.append(line).append("\n");
      }
      
      // 한줄씩 읽을 때, 한줄 전체에 줄바꿈(\n)이 포함이 되는지 여부
      // 확인
      System.out.println(builder.toString());
      
      // 버퍼 입력 스트림 닫기
      in.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void method3() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample3.html");
    
    // BufferedReader 선언
    BufferedReader in = null;
        
    try {
      
      // BufferedReader 생성
      // 바이트 입력 스트림(FileInputStream) -> 문자 입력 스트림(InputStreamReader) -> 버퍼 입력 스트림(BufferedReader)
      // 최종적으로 사용하는 스트림은 BufferedReader 이다.
      in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
      
      // 읽는 단위
      String line = null;
      
      // 읽은 데이터 모으기
      StringBuilder builder = new StringBuilder();
      
      // 읽기
      while( (line = in.readLine()) != null ) {
        builder.append(line).append("\n");
      }
          
      // 확인
      System.out.println(builder.toString());
      
      //BufferedReader 닫기
      in.close();
      
    } catch (IOException e) {      
      e.printStackTrace();
    }   
    
  }
  
  public static void main(String[] args) {
    
    method3();
    
  }

}
