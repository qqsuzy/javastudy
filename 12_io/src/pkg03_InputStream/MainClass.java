package pkg03_InputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

  /*
   * java.io.FileInputStream
   * 1. 바이트 기반의 파일 입력 스트림이다.
   * 2. 입력 단위
   *    1) int
   *    2) byte[]
   */
  
  /*
   * java.io.BufferedInputStream
   * 1. 버퍼링을 지원하는 바이트 입력 스트림이다.
   * 2. 보조 스트림이므로 메인 스트림과 함께 사용해야 한다.
   * 3. 버퍼링을 지원하므로 입력 속도가 향상된다.
   */
  
  // int 단위로 하나씩 읽어 들이는 방법
  public static void method1() {
    
    File dir = new File("\\storage");
    
//    if(!dir.exists()) {               -- 읽어 들이는 것이기 때문에 없으면 만들라는 생성 코드가 필요가 없다.
//      dir.mkdirs();
//    }  
    
    File file = new File(dir, "sample1.dat");
    
    // 파일 입력 스트림 선언
    FileInputStream in = null;
    
    try {
      
      // 1. FileNotFoundException 예외 발생 (지정된 파일을 찾을 수 없는 경우)
      // 파일 입력 스트림 만들기
      in = new FileInputStream(file);
      
      // 읽은 데이터를 보관할 배열
      byte[] b = new byte[(int)file.length()];       // byte 배열 생성, 배열의 길이 = file의 크기 (file.length() -> long 타입으로 int로 캐스팅 해주어야 한다. byte 배열에는? long 타입 사용 불가능)
      int idx = 0;
      
      // 읽을 단위 (int 변수로 1바이트씩 읽는다.) 
      int c;
      
      // 읽기
      while(true) {       // 무한루프 (무조건 true : 만족)
        c = in.read();    // 하나 읽은 것을 int 타입으로 가져와라 
        if(c == -1) {     // read int가 -1이 나오면 종료
          break;
        }
        b[idx++] = (byte)c;   // read() 에서 발생된 예외는 FileNotFoundException 으로 처리가 불가능하다. // IOException 예외 처리가 필요하며, catch 블록을 하나 더 추가하여 처리한다. (어떤 예외처리가 필요한지 ctrl 키 누르고 해당 메소드 확인하기를 습관화 하자!)
                              // 1바이트 크기의 그릇에 담고? byte로 캐스팅이 필요하다.
      }
      
      // 확인
      // 문자열로 확인
      System.out.println(new String(b));  // byte 배열값을 String으로 변환해준다.

      // for(int i = 0; i < b.length; i++)
      // System.out.println(b[i]);
      //System.out.println(char(b[i]));     // 문자로 캐스팅
      
      
      // 파일 입력 스트림 닫기
      in.close();
      
    } catch (FileNotFoundException e) {
      System.out.println("파일의 경로를 확인하세요.");
    } catch (IOException e) {
      System.out.println("입출력 예외가 발생했습니다.");
    }
    
  }
  
  // byte[] 단위로 읽어 들이는 방법
  public static void method2() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample2.dat");
    
    // 파일 입력 스트림 선언
    FileInputStream in = null;
    
    try {
    
      // 파일 입력 스트림 생성
      in = new FileInputStream(file);
      
      // 읽은 데이터를 보관할 배열
      byte[] b = new byte[(int)file.length()];
      
      // 읽을 단위 (byte[] 배열로 읽는다.)
      byte[] bytes = new byte[5];          // 5개의 byte씩 읽는다.
      int idx = 0;
      
      // 읽기
      //System.out.println(in.read(bytes));   // read(byte[]) 로 읽기 -> int로 반환된다. -> 21
      
      while(true) {
        int readByte = in.read(bytes);    
       if(readByte == -1) {
         break;
       } 
         System.arraycopy(bytes, 0, b, idx, readByte);  // bytes 배열의 [0] 첫번째 요소부터 b 배열의 [0] 첫번째 배열에 readByte 만큼 복사하겠다.
         idx += bytes.length;   // idx += readByte; 와 동일한 결과를 얻을 수 있다.  // idx는 5씩 증가한다.
      }
      
      // 확인
      System.out.println(new String(b));
      
      // 파일 입력 스트림
      in.close();
      
    } catch (FileNotFoundException e) {
      System.out.println(file.getPath() + " 파일이 존재하지 않습니다.");
    } catch (IOException e) {             
      System.out.println("입출력 오류가 발생했습니다.");
    }
    
  }
  
  // byte[] 단위로 읽기, BufferedInputStream 사용, while 문 수정
  public static void method3() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample3.dat");
    
    // 버퍼 입력 스트림 선언
    BufferedInputStream in = null;
    
    try {
      
      // 버퍼 입력 스트림 생성
      in = new BufferedInputStream(new FileInputStream(file));
      
      // 읽은 데이터를 보관할 배열
      byte[] b = new byte[(int)file.length()];
      
      // 읽을 단위 (byte[] 배열로 읽는다.)
      byte[] bytes = new byte[5];          
      int idx = 0;
      
      // 읽기
      int readByte = 0;   // 선언문은 반복문이 반복될 때 마다 생성 -> 삭제 반복되므로 밖으로 빼라!
      while((readByte = in.read(bytes)) != -1 ) {   // 읽어 드리는 것 먼저하고 그 결과는 readByte에 있고 그 결과가 -1이 아니면 계속 반복문 실행해라
        System.arraycopy(bytes, 0, b, idx, readByte); // readByte : 몇바이트를 읽었다.
        idx += bytes.length;  
       } 
      
      // 확인
      System.out.println(new String(b));
      
      // 피일 입력 스트림 닫기
      in.close();
      

    } catch (IOException e) {  // IOException 은 FileNotFoundException의 부모 클래스로 업캐스팅하여 IOException 만 catch 블록에 예외처리하여도 된다.
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {

    method2();
    
  }

}
