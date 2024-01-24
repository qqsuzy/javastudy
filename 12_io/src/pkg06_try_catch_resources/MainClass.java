package pkg06_try_catch_resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

  public static void main(String[] args) {

    /*
     * try - catch - resources
     * 1. 생성한 자원(resource, 대표적으로 입출력 스트림)을 자동으로 close 하는 try 문이다. (try문이 끝나면 close 한다.)
     * 2. 형식 
     *    try(자원 생성) {
     *    
     *    } catch( ) {
     *    
     *    }    
     */
    
    // 일반적으로는 사용이 가능하나 예외적으로 delete 메소드를 사용해야 할 경우와 같을 때는 앞에 배운 스트림 생성 및 선언 방식으로 사용해야 한다.
    // try 블록 안에 delete()를 넣으면 close() 되기 전에 파일 생성 후 지워버리기 때문이다.
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample4.txt");
    
    // 
    try(BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      
      // try 블록에 깔끔하게 출력 코드만 남는다.
      out.write("안녕하세요");
      out.newLine();
      out.write("반갑습니다");
      out.newLine();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }

}
