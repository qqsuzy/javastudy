package pkg01_java_net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Class05_URLEncoder {

  public static void main(String[] args) {

    try {
      
      // 인코딩
      String str = "http://www.google.com/";
      String encoded = URLEncoder.encode(str, "UTF-8");  // str 을 UTF-8 방식으로 바꿔준다.
      System.out.println(encoded);
      
      // 디코딩
      String decoded = URLDecoder.decode(encoded, "UTF-8");
      System.out.println(decoded);
      
    } catch (UnsupportedEncodingException e) {  // 잘못된 인코딩을 적었을 때 (오타)
      e.printStackTrace();
    }
    
    
  }

}
