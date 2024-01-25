package pkg02_open_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {

  public static void main(String[] args) {

    StringBuilder builder = new StringBuilder();
    builder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
    builder.append("?serviceKey=").append("8E4t9bsYHNOU3pVnkEWhcPcU6X1djLiP68aLh5buKrsZRhU%2FYmp%2BnD%2FJ8sT7qCf6wvQ%2BSm1YsDDfj%2BuE0p3opw%3D%3D");
    builder.append("&searchYear=").append(2022);
    builder.append("&siDo=").append(1100);
    builder.append("&guGun=").append(1125);
    builder.append("&type=").append("json");
    builder.append("&numOfRows=").append(10);
    builder.append("&pageNo=").append(1);
    
    String spec = builder.toString();
    URL url = null;
    HttpURLConnection con = null;
    
    BufferedReader  in = null;
    
    try {
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException("API 요청 실패");
      }
      
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();    // API 요청 결과는 sb에 담는다.
      String line = null;
      while((line = in.readLine()) != null) {
        sb.append(line);
      }
      
      System.out.println(sb.toString());
      
      in.close();
      con.disconnect();
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
     
    
    // JSONObject Class : { }   자바 객체를 JASON 객체로
    // JSONArray class : [ ]    JASON 객체를 자바 객체로 
    // 프로젝트 단위로 제이슨 라이브러리를 추가할 수 있으며, 적용되지 않은 프로젝트는 사용이 안된다.
    // 적용하고자 하는 프로젝트 선택 후 우클릭 > Build Path > Configure Build path > Add External JARs
    
  }

}
