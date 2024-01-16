package pkg04_checked;

import java.net.MalformedURLException;
import java.net.URL; // 클래스를 사용하기 전에 한 번만 import문을 작성하면 클래스를 작성 할 때 매번 패키지를 작성하는 불편함이 없어진다.



public class MainClass {

  public static void main(String[] args) {

    // checked exception : try - catch 와 같은 예외 처리 코드가 없으면 동작하지 않는 예외이다.
    
    // 클래스 이름 앞에 패키지 이름을 생략하는 경우
    // 1) 동일한 패키지에 저장된 클래스의 경우
    // 2) java.lang 패키지에 저장된 클래스의 경우
   
    try {
    URL url = new URL ("http://wwww.google.com/"); // 클래스 이름은 자동완성기능(ctrl + space) 활용해서 import 될 수 있게하자!!
    } catch (MalformedURLException e) {
      System.out.println("잘못된 URL입니다.");
    }
    
  }

}
