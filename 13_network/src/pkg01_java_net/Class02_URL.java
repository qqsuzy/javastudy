package pkg01_java_net;

import java.net.MalformedURLException;
import java.net.URL;

public class Class02_URL {

  public static void main(String[] args) {

    try {
      
      URL url = new URL("https://www.example.com:9090/webtoon/list?page=1&id=100#memo"); // URL(String spec) , query를 추가로 작성하고자 할 때는 앰퍼센트(&) 사용
      
      System.out.println(url.getProtocol());
      System.out.println(url.getHost());
      System.out.println(url.getPort());
      System.out.println(url.getPath());
      System.out.println(url.getQuery());
      System.out.println(url.getFile());    // File = Path + Query
      System.out.println(url.getRef());
      
      
    } catch (MalformedURLException e) { // 잘못된 형식의 URL인 경우 발생되는 예외
      e.printStackTrace();
    }
    
    
  }

}
