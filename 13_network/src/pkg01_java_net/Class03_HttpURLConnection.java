package pkg01_java_net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// URLConnection     부모 클래스
// HttpURLConnection 자식 클래스

public class Class03_HttpURLConnection {

  public static void main(String[] args) {

    String spec = "https://www.naver.com/";
    URL url = null;
    HttpURLConnection con = null;      // 스코프 조정을 넓게하기 위해서 선언을 먼저한다. (try, finally 에서도 사용하기 위해서)
    
    try {
      
      url = new URL(spec); // 문자열 주소(spec) 전달
      con = (HttpURLConnection) url.openConnection(); // 부모 -> 자식 다운캐스팅 필요 : 강제 캐스팅해야 한다.
      
      /*
       * 접속 상태 확인 (HTTP Response Code : 응답 코드)        서버 -> 클라이언트 : 응답 (서버가 클라이언트로 보내는 것)
       *                                                        클라이언트 <- 서버 : 요청 (클라이언트가 서버에게 보내는 것)
       * 접속 코드 
       * 1. 200 : 정상
       * 2. 4xx : 요청 문제 (클라이언트 문제)
       * 3. 5xx : 서버 문제 (개발 문제)
       */
      
      int responseCode = con.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) {  // 접속코드를 숫자로 표기하거나 왼쪽과 같이 표기도 가능하다. (접속 코드 모르면 확인하여 숫자로 기입)
        System.out.println("정상 접속");
      } else {
        System.out.println("접속 불가");
      }
      
      /******** 중요 ********
       * Content-Type (자료형) 
       * 1. 컨텐트 타입 : 컨텐트 타입을 보면 어떠한 형식의 파일인지 확인할 수 있다. (확장자로 확인하지 않아도 된다.)
       * 2. 종류
       *    1) 문서 타입 : text/xxx
       *    2) 이미지 타입 : image/xxx
       *    3) 데이터 타입 : application/xxx
       */
      
      String contentType = con.getContentType();
      System.out.println(contentType);
      
      /******** 중요 ******** 
       * 클라이언트 -> 서버
       * 
       * 요청 메소드 (Request Method, 요청 방법)
       * 1. GET  : 주소창(URL)을 이용한 데이터 요청. *기본 요청 방식*     -> 주소창으로 데이터를 보내는 방식
       * 2. POST : 본문(Body)을 이용한 요청                               -> ID, Password 등 보안이 필요한 데이터를 보내는 방식 
       */
      
      String requestMethod = con.getRequestMethod();
      System.out.println(requestMethod);
      
      /* 요청 헤더
       * 1. 요청 정보가 저장된다.
       * 2. 주요 종류
       *    1) User-Agent     : 무엇으로 접속하였는지에 관한 정보   ex) 크롬으로 접속하면 크롬, 자바로 접속하면 자바 ...
       *    2) Referer        : 이전 접속 주소 정보                 ex) 웹툰 페이지에서 관심웹툰으로 추가하려고 한다 -> 로그인 페이지 이동 -> 로그인 -> 다시 웹툰 페이지로 이동 (Referer)
       *    3) Content-Type   : 컨텐트 타입
       *    4) Content-Length : 컨텐트 크기
       */
      
      // Map<String,List<String>> requestHeader = con.getRequestProperties();
      // for(Entry<String, List<String>> entry : requestHeader.entrySet()) {
      // System.out.println(entry.getKey() + " : " + entry.getValue());
      // }
      String userAgent = con.getRequestProperty("User-Agent");
      System.out.println(userAgent);
      String referer = con.getRequestProperty("Refere");
      System.out.println(referer);    
      
    } catch (MalformedURLException e ) {  // MalformedURLException 자식 : 다중 예외처리는 자식을 먼저 그다음 부모를 작성한다.
      e.printStackTrace();                // 상속관계의 예외 클래스는 catch 블록을 따로 작성해야 한다. 하나의 catch 블록에 작성하면 자식 예외가 처리가 안된다.
    } catch (IOException e) {
      e.printStackTrace();                // IOException 부모 
                                          // HttpURLConnection 생성시 IOException 발생
    } finally {
      
      if(con != null)    // NullPointException 발생할 수 있으므로 null이 아닐 때 고려해서 if문 추가
      con.disconnect();  // 접속 해제
      
    }
    
    
  }

}
