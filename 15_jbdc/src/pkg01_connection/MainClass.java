package pkg01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;

public class MainClass {

  /*
   * oracle.jbdc.OracleDriver 
   * 1. 오라클 데이터베이스에 접속하기 위해서 필요한 드라이버 클래스이다.
   * 2. 오라클에서 만들어서 배포한다.
   * 3. 18c XE 버전의 경우 C:\app\GD\product\18.0.0\dbhomeXE\jdbc\lib\ojdbc8.jar 파일을 프로젝트의 build path 에 등록해야 한다. -> 각종 jar 파일이 있는 폴더 
   */
  
  /*
   * java.sql.Connection
   * 1. 데이터베이스 접속 객체를 타입의 인터페이스이다.
   * 2. java.sql.DriverMnager 클래스가 데이터베이스 접속 객체를 생성한다. -> 생성은 DriverManager가 하고 저장은 Connection 이 한다.
   * 3. 형식
   *    Connection con = DriverManager.getConnection();
   */
  
  /*
   * 프로퍼티(Property, 속성)
   * 1. 운영체제의 정보나 자바 실행 정보 등을 가지고 있는 값이다.
   * 2. 사용자가 프로퍼티를 추가해서 사용할 수 있다.
   * 3. 프로퍼티 추가 방법 (클래스 바꿀 때 마다 다시 추가해주어야 한다.)
   *   1) [Run] - [Run Configurations] - [Arguments] - [VM arguments] // [VM arguments] : JVM 실행 할 때 전달되는 인자값
   *   2) 프로퍼티 앞에 prefix 값으로 -D를 사용한다. (등록할 때만 -D를 앞에 넣고, 불러올 때는 -D는 제외한다.)
   *   
   * 4. github.com 에 올릴 수 없는 민감 정보를 처리하는 용도로 사용한다.  
   * 5. 프로퍼티로 등록한 값은 System.getProperty() 메소드를 이용해서 가져온다.  
   */
  
  /*
   * getConnection
   * sql = "select * from table";
   * close
   * 
   * 쿼리마다 getConnection 하고 반드시 close 를 해야한다!
   */
  
  public static void method1() {
    // oracle.jdbc.OracleDriver 클래스 로드하기 (메모리에 올리기)
    try {
      Class.forName("oracle.jdbc.OracleDriver");                 // Class 라는 이름의 클래스 -> *** 핵심 코드 ***
                                                                 // forName(String className) : 데이터베이스 드라이버를 로드하는데 사용하는 메소드, JDBC 드라이버를 사용할 때 해당 드라이버의 클래스를 로드하기 위해서 메소드를 호출한다.
      System.out.println("oracle.jdbc.OracleDriver 클래스가 메모리에 로드되었습니다.");
    } catch (Exception e) {
      System.out.println("oracle.jdbc.OracleDriver 클래스를 찾을 수 없습니다.");
    }  
    
  }
  
  public static void method2() {
    
    // 접속을 위해서 필요한 정보(DB 서버 주소, 계정정보(계정이름, 계정비밀번호))
    // jdbc:oracle:thin:@DB 서버 주소:포트번호:서비스이름
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 진짜 주소는 골뱅이 (@) 뒤 부터 localhost 또는 127.0.0.1 (IP주소)
    String user ="GD";
    String password = "1111";
    
    // Connection 객체 선언
    Connection con = null;
    
    try {
      
      // Connection 객체 생성
      con = DriverManager.getConnection(url, user, password);
      System.out.println("데이터베이스에 접속되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Connection 객체 닫기
      try {
        if(con != null)
        con.close();      
      } catch (Exception e) {
        e.printStackTrace();
      }      
      
    }
    
  }
  
  public static void method3() {
    
    Properties props = System.getProperties(); // java.util 클래스 , getProperties() : 모든 프로퍼티 가져온다.
   
    Enumeration enumeration = props.propertyNames(); 
    
    while(enumeration.hasMoreElements()) { // hasMoreElements() : 저장된 값을 가지고 있으면
      String property = (String)enumeration.nextElement();
      System.out.println(property + "=" + props.getProperty(property));
    }
  }

  public static void method4() {
    
    // 사용자 프로퍼티 등록 (jdbc.url, jdbc.user, jdbc.password)
    // -Djdbc.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
    // -Djdbc.user=GD
    // -Djdbc.password=1111
    
    // 데이터베이스 접속 정보 (사용자 프로퍼티 가져오기)
    String url = System.getProperty("jdbc.url");
    String user = System.getProperty("jdbc.user");
    String password = System.getProperty("jdbc.password");
    
    Connection con = null;
    
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("데이터베이스에 접속되었습니다.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(con != null) con.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
  }
  
  public static void main(String[] args) {
    method4();
    
    
  }

}
