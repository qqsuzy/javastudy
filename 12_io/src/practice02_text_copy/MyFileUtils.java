package practice02_text_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileUtils {

  // File 로 받아온다
  public static void fileCopy(File src, File dest) {
   
    // BufferedReader : File src 읽는 역할
    // BufferedWriter : File dest 만드는 역할
    
   
    try(BufferedReader in = new BufferedReader(new FileReader(src));
        BufferedWriter out = new BufferedWriter(new FileWriter(dest))) {
          
      char[] cbuf = new char[256];
      int readChar = 0;
      
      // in.read(cbuf) -> out.write(cbuf)   (in으로 읽은 것을 지체없이 out으로 보낸다.)
      while( (readChar = in.read(cbuf)) != -1 ) {
        out.write(cbuf, 0, readChar); // cbuf 배열의 첫번째 글자부터 readChar (읽은 것)만 보내라!
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
      
  }
  
  public static void fileMove(File src, File dest) {
    
    fileCopy(src, dest);
    src.delete();
    
  }
  
  
}
