package pkg07_terminal_method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {

  public static void method1() {
    
    // 여러 개의 데이터가 존재할 때 하나씩 꺼내서 사용하는 인터페이스 
    // java.util.stream.Stream 생성
    Stream<String> seasons = Stream.of("spring", "summer", "autumn", "winter"); 
    
    // forEach() 메소드 호출   
    // Stream 에 저장된 요소를 하나씩 Consumer 의 파라미터에 전달하는 메소드 (for문을 돌리지 않아도 된다.)
    seasons.forEach( (season) -> System.out.println(season) );  // seasons 의 매개변수가 하나씩 season 으로 넘어가서 출력된다. (forEach() 메소드를 사용)
                                                                // 중괄호 { } 생략 version    
  }
  
  // 배열을 stream 으로 만들기
  public static void method2() {
    
    String[] seasons = {"spring", "summer", "autumn", "winter"};
    Stream<String> stream = Arrays.stream(seasons);  // Arrays : 배열의 헬퍼클래스
    
    // forEach() 메소드
    stream.forEach( (season) -> {
      System.out.println(season);
    });
    
  }
  
  //Collection(List, Set) 을 stream 으로 만들기
  public static void method3() {
  
    // List 를 stream 으로 만들기 (1)
    List<String> seasons = Arrays.asList("spring", "summer", "autumn", "winter");  // asList() : Array 리스트 초기화 방식
    Stream<String> stream = seasons.stream();   // seasons.stream().forEach()
    stream.forEach((season) -> System.out.println(season));
    
    // List 를 stream 으로 만들기 (2) - 메소드 체이닝 방식
    Arrays.asList("spring", "summer", "autumn", "winter").stream().forEach((season) -> System.out.println(season));
    
    // Set 를 stream 으로 만들기
    new HashSet<String>(seasons).stream()
          .forEach( (season) -> System.out.println(season));
        
  }
  
  public static void method4() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample2.txt");
    
    BufferedReader in = null;
    
    try {
      
      in = new BufferedReader(new FileReader(file));
      
      // 읽은 데이터 저장소
      StringBuilder builder = new StringBuilder();
      
      // 읽은 데이터 모으기
      in.lines().forEach((line) -> builder.append(line).append("\n") );   // lines() : 반환 타입 stream -> 한 줄씩 빼서 stream 으로 만들어 주는 메소드 (readline()과 같은 역할을 하는 메소드 이지만 while문을 돌릴 필요가 없다.)
      
      /* 위와 같은 코드
      while( (line = in.readLine()) != null ) { 
        builder.append(line).append("\n");
      */
           
      in.close();
      
      System.out.println(builder.toString());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

  public static void method5() {
    
    // JAVA_HOME 파일명 출력하기 
    // 방법 1)
    File javaHome = new File("\\Program Files\\Java\\jdk-17");
    
    File[] files = javaHome.listFiles();
    
    Stream<File> stream = Arrays.stream(files);    
    stream.forEach((file) -> System.out.println(file.getName()));
   
    
    // Path 인터페이스 (java.nio.file) -> 파일의 친구
    // 방법 2)
    try {
      Path path = Paths.get("\\Program Files\\Java\\jdk-17");   // Paths : Path 의 헬퍼 클래스 
      Stream<Path> stream2 = Files.list(path);
      stream2.forEach((p) -> System.out.println(p.getFileName()));
      
      stream2.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
        
  }
  
  public static void main(String[] args) {
    
    method5();
    
  }

}
