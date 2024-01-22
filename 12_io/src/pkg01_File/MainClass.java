package pkg01_File;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class MainClass {

  /*
   * java.io.File
   * 1. 디렉터리(폴더), 파일을 관리하는 클래스이다.
   * 2. 디렉터리, 파일을 만들고 삭제할 수 있다.
   * 3. 디릭터리, 파일의 정보(이름, 경로, 크기, 최종수정일 등)를 확인할 수 있다.
   */
  
  /*
   * 경로 작성 방법 
   * 1. 경로 구분자 (separator)
   *    1) 윈도우      : 역슬래시 (\\) -> java에서는 역슬래시 2개 
   *    2) 리눅스, Mac : 슬래시 (/)
   *    3) File.separator 필드를 사용하면 플랫폼에 따른 경로 구분자가 자동 삽입된다.
   *    
   *    애초에 나중에 배포를 생각하여 슬래시(/) 로 만든다. (모든 환경을 고려)
   * 
   * 2. 디렉터리 (윈도우,리눅스,Mac 공통)
   *    1) 루트 : 경로 구분자로 시작하는 경로는 루트에서 시작하는 경로 (소스코드과 관리되고 있는 경로가 루트이다.)
   *    2) 상위 : ..
   *    3) 현재 : .   
   */
  
  public static void method1() {
    
    // ****** 코드 통으로 다 외우기 (필수적임!!!!) *******
    // 디렉터리 만들기/삭제하기
    
    // File 객체 선언
    File dir;
    
    // File 객체 생성
    dir = new File("\\storage"); // parent : dir , child: file 
                                 // 루트는 생략가능하며 C드라이브 아래 디렉터리 생성된다.
    
    // 디렉터리 유무에 따른 생성/삭제 (있으면 안만들고 없으면 만든다.)
    if(dir.exists() == false) { // 디렉터리가 없으면 (exists는 있으면이므로 부정형으로 바꾸어준다.) // 1. not : ! , 2. == false (1번은 가독성이 떨어져서 간혹 지양하는 프로젝트가 있다.)
      dir.mkdirs();             // 항상 mkdirs() 쓰기 (여러개 파일 생성)   
    } else {                    // 디렉터리가 있으면
      // dir.deleteOnExit();    // 1. JVM 실행이 종료된 이후에 삭제한다.
      dir.delete();             // 2. JVM 실행 중에 삭제한다. 코드를 만나면 바로 지운다. (일반적으로 사용된다!) 
    }
  } 
  
  public static void method2() {
    
    // 파일 만들기/ 삭제하기  : 폴더를 만들고 파일 생성이 가능하다.
    
    // 파일이 저장될 디렉터리 작업 (File 객체로 생성)
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 생성 (디렉터리와 동일하게 File 객체로 생성)
    File file = new File(dir, "sample.txt");
    
    // 파일 유무에 따른 생성/삭제
    if(file.exists()) { // 파일이 있으면 지우겠다. (*** 지우는 것 잘 연습해두기!) 
      file.delete();
    } else {            // 파일이 없으면
      try {
         file.createNewFile(); // IOException 처리가 반드시 필요하다. (checked exception 이라 try-catch가 없으면 실행되지 않는다.)        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }  
  }
  
  public static void method3() {
    
    /*
     * File 클래스 주요 메소드
     * 1. listFiles()    : 디렉터리 내의 모든 File 객체를 File[] 배열로 반환
     * 2. getName        : 이름 반환
     * 3. getParent()    : 저장된 디렉터리 반환
     * 4. getPath()      : getParent() + getNmae()
     * 5. lastModified() : 최종수정일을 long 타입으로 반환 (TimeStamp 값 반환 -> 가공필요)
     * 6. length()       : 파일 크기를 long 타입으로 반환 (byte 단위 -> 가공필요) 
     * 7. isDirectory()  : 디렉터리이면 true 반환
     * 8. isFile()       : 파일이면 true 반환
     */
    
    // JAVA_HOME 을 File 객체로 생성
    File javaHome = new File("\\Program Files\\Java\\jdk-17");
    
    // JAVA_HOME 에 있는 모든 디렉터리와 파일을 File 객체로 가져오기
    File[] files = javaHome.listFiles();
    
    // 하나씩 확인
    for(File file : files)  {
      StringBuilder builder = new StringBuilder();
      
      // 이름
      builder.append(String.format("%-20s", file.getName().substring(0, Math.min(file.getName().length(), 20)))); // 20자리까지 출력하고, 20자리가 넘으면 자르겠다.
                                                                                                                  // Math.min() 둘 중에 작은 것을 출력하겠다.
      // 최종수정일
      String lastModified = new SimpleDateFormat("yyyy-MM-dd a h:mm").format(file.lastModified());
      builder.append(String.format("%-20s", lastModified));
      
      // 유형
      builder.append(String.format("%-10s", file.isDirectory() ? "파일 폴더" : "파일")); // 디렉터리면 "파일폴더"(true) 반환, 아니면 "파일"(false) 반환
      
      // 크기
      long byteSize = file.isDirectory() ? 0 : file.length();
      long kbSize = (byteSize / 1024) + (byteSize % 1024 != 0 ? 1 : 0);
      if(byteSize != 0)
      builder.append(String.format("%10s", new DecimalFormat("#,##0").format(kbSize) + "KB")); // 오른쪽 정렬 (%10s)
      
      // 출력
      System.out.println(builder.toString());      
    }
  
  }
  
  public static void main(String[] args) {  
    practice2(new File("\\2024\\01\\22"));
    
  }

  public static void practice1() {
    
   // C :\2024\01\22 디렉터리 만들기 (현재 날짜의 디렉터리 만들기 : Java Standard API 활용)
    LocalDateTime today = LocalDateTime.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();
    
    StringBuilder builder = new StringBuilder();
    builder.append("\\");
    builder.append(year);
    builder.append("\\");
    builder.append(String.format("%02d", month));  // "%02d" 2자리로 맞추고 1자리면 앞에 0을 붙여라
    builder.append("\\");
    builder.append(String.format("%02d", day));
    
    File dir = new File(builder.toString());
    if(!dir.exists()) {
      dir.mkdirs();
    }
 
    System.out.println(dir.getPath() + " 디렉터리 생성이 완료되었습니다.");
    
  }
  
  public static void practice2(File dir) {
    
    // C:\2024 디렉터리 삭제하기 (비어 있는 디렉터리만 삭제할 수 있다.)
    
    // 순서대로 하나씩 삭제하기
    // \2024\01\22 삭제 -> \2024\01 삭제 -> \2024 삭제
    
    // 재귀 호출로 해결하기 (자기가 자기를 호출하는 방식)
    // practice2(new File(\2024\01\22)) 호출 후
    // practice2(new File(\2024\01)) 호출 후
    // practice2(new File(\2024)) 호출    
    // practice2(new File(\)) 호출로 마무리
    
    // 파라미터 File dir 객체의 상위 디렉터리가 없으면 종료
    File parent = dir.getParentFile(); // dir의 부모파일(상위 디렉토리)을 가져온다.
    if(parent == null) {               // 상위 디렉토리가 있는지 확인한다.
      return;                         // 상위 디렉터리가 없으면 return
    }
    
    // 현재 디렉터리 삭제
    System.out.println(dir.getPath() + " 삭제하였습니다.");
    dir.delete();
    
    // 상위 디렉터리를 practice2 메소드에 전달 (자기를 호출)
    practice2(parent);
    
  }
  
  
}
