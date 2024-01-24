package practice01_byte_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class MyFileUtils {

  // 파일 복사 메소드
  public static void fileCopy(String src, String dest) { // src에 있는 파일을 dest로 이동 | static 은 객체 생성 없이 클래스명으로 생성 가능하다. 
  
  // src로 부터 읽은 데이터를 바이트 배열에 저장하고,
  // 바이트 배열에 있는 데이터를 파일 출력 스트림으로 보내는 방식 
  // 5바이트씩 읽어서 배열에 쌓지 말고 바로 출력 (bytes)

  // 원본 File 객체  
  File srcFile = new File(src);  
  
  // 복사본 File 객체
  File destFile = new File(dest);  
  
  // 원본을 읽는 버퍼 입력 스트림 선언 
  BufferedInputStream in = null;
  
  // 복사본을 만드는 버퍼 출력 스트림 선언
  BufferedOutputStream out = null;
  
  try {
    
    // 원본을 읽는 버퍼 입력 스트림 생성
    in = new BufferedInputStream(new FileInputStream(srcFile));
    out = new BufferedOutputStream(new FileOutputStream(destFile));
    
    // 원본을 5바이트씩 읽어온다.
    byte[] bytes = new byte[5];
   
    // 원본을 끝까지 읽는다. 읽은 내용을 복사본으로 보낸다.
    // **** 핵심 **** 
    int readByte = 0;                         //  readByte : 몇바이트를 읽었다.
    while((readByte = in.read(bytes)) != -1) {
      out.write(bytes, 0, readByte);          // byte 5개를 읽었으면 5개를 보내고, 1개를 읽었으면 1개만 보내라! readByte (읽은 만큼) 만큼!
    }
    
    // 출력
    out.write(bytes);
    
    // 닫는 순서는 생성 순서와 반대로 진행한다. (out -> in)
    // 버퍼 출력 스트림 닫기
    out.close();
    
    // 버퍼 입력 스트림 닫기
    in.close();
   
    
  } catch (IOException e) {
    e.printStackTrace();
  }
  
  }
  // 파일 이동 메소드
  public static void fileMove(String src, String dest) {
    
    fileCopy(src, dest);
    new File(src).delete();
    
    
  }
  
  
  
}
