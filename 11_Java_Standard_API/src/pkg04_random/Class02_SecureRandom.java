package pkg04_random;

import java.security.SecureRandom;

public class Class02_SecureRandom {

  public static void main(String[] args) {
    
    // <보안처리가 필요한 랜덤 사용>
    
    // 1. 기본 시드(seed) 사용 : new SecureRandom()
    // 2. 시드 전달 가능       : new SecureRandom(byte[] seed)
    // : 전달하는 시드에 따라 발생되는 난수가 다르다.
   
    // String str = "asdf"
    // str.getBytes()
    
    SecureRandom secureRandom = new SecureRandom("민수지".getBytes());
    
    // nextDouble() : 0.0 <= 난수 < 1.0 (보안처리되어 있어 인증코드로 사용된다.)
    // 5% 확률로 "대박" 출력
    if(secureRandom.nextDouble() < 0.05) {
      System.out.println("대박");
    } else {
      System.out.println("대박은 무슨");
    }
    
    // nextInt()      : int 범위 중 하나
    // nextInt(5)     : 0 ~ 4 중 하나
    // nextInt(5) + 1 : 1 ~ 5 중 하나 
    
    int yut = secureRandom.nextInt(5) + 1;
    System.out.println(yut);
    
  }

}
