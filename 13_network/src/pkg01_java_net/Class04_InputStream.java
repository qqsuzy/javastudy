package pkg01_java_net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Class04_InputStream {

  // 웹사이트 코드 복사하기
  public static void method1() {
    
    String spec = "https://www.google.com/";
    URL url = null;
    HttpURLConnection con = null;        // 구글 웹사이트의 초기화면을 읽어 들인다.
    
    BufferedReader in = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(spec + " 접속 불가");
      }
      
      in = new BufferedReader(new InputStreamReader(con.getInputStream())); // 버퍼 -> 바이트 스트림을 문자로 변환 -> 바이트 기반 스트림
      
      String line = null;
      StringBuilder builder = new StringBuilder();
      while((line = in.readLine()) != null) {
        builder.append(line).append("\n");
      }
      
      System.out.println(builder.toString());
      
      in.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(con != null)
        con.disconnect();
    }
 
    
  }
  
  // 배너 이미지 복사하기
  public static void method2() {
    
    String spec = "https://ssl.pstatic.net/melona/libs/1482/1482864/45baf999592662f7b3b5_20240124160703273.jpg";
    
    // \\storage\\banner.jpg
    
    URL url = null;
    HttpURLConnection con = null;
 
    BufferedInputStream in = null;
    BufferedOutputStream out = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      if(con.getResponseCode() != 200) {
        System.out.println(spec + "접속 불가");
      }
      
      in = new BufferedInputStream(con.getInputStream());
      
      File dir = new File("\\storage");
      if(!dir.exists()) {
        dir.mkdirs();
      }
      
      File file = new File(dir, "banner.jpg");
      
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] bytes = new byte[25]; 
      int readByte = 0;
      while((readByte = in.read(bytes)) != -1) {
        out.write(bytes, 0, readByte);
      }
      
      out.close();
      in.close();
      
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      con.disconnect();
    }
    
    
  }
  
  public static void main(String[] args) {
   
    method2();
    
  }
  
}
