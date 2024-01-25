package pkg01_java_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Class01_InetAddress {

  public static void main(String[] args) {

    try {
      
      InetAddress address1 = InetAddress.getByName("gdu.co.kr");   // getByName() : 문자 주소를 전달 , 예외처리가 반드시 필요하다.
      System.out.println("IP주소 : " + address1.getHostAddress());
      System.out.println("도메인 : " + address1.getHostName());
      
      InetAddress address2 = InetAddress.getByAddress(new byte[] {112, (byte)175, (byte)247, (byte)163});   // byte 배열 만들어서 초기화 -> byte 배열은 -127 ~ 127까지 표현이 가능하여 범위 초과의 숫자는 byte로 캐스팅 한다. 
      System.out.println("IP주소 : " + address2.getHostAddress());
      System.out.println("도메인 : " + address2.getHostName());    // 도메인은 내부에서 사용되는 도메인이 다를 수 있어 IP주소와 다르게 나올 수 있다.    
      
    } catch (UnknownHostException e) {   // java.net 패키지의 UnknownHostException 
      e.printStackTrace();                
    }
    
    
  }

}
