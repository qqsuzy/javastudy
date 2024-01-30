package practice02_dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pkg02_dml.TalkDto;
import pkg03_dql.SampleDto;

public class MainClass {

  /*
   * TALK_T 테이블의 데이터를 TALK_NO의 내림차순으로 정렬한 뒤 11~20번째 행을 조회하여 List 에 저장하시오
   * TALK_T 구조
   *    TALK_NO       NUMBER (PK)
   *    TALK_CONTENT  VARCHAR2(1000 BYTE)
   *    TALK_USER     VARCHAR2(1000 BYTE)
   *    WRITTEN_AT    TIMESTAMP (* 현재 날짜/시간 : CURRENT_TIMESTAMP)
   *    
   * DB 서버 환경
   *    192.168.0.214
   *    GD/1111   
   *
   */

  // TalkDto

  public static void method1() {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "SELECT TALK_NO, TALK_CONTENT, TALK_USER, WRITTEN_AT"
          + "  FROM (SELECT ROW_NUMBER() OVER(ORDER BY TALK_NO DESC) AS RN, TALK_NO, TALK_CONTENT, TALK_USER, WRITTEN_AT"
          + "          FROM TALK_T)"
          + " WHERE RN BETWEEN ? AND ?";
      
      ps = con.prepareStatement(sql);
      
      int begin = 21;
      int end = 30;
      ps.setInt(1, begin);
      ps.setInt(2, end);
      
      rs = ps.executeQuery();
      
      while(rs.next()) {
        
        List<TalkDto> talk = new ArrayList<TalkDto>();
        
        TalkDto talkdto = new TalkDto();
        talkdto.setTalk_no( rs.getInt("TALK_NO"));
        talkdto.setTalk_content( rs.getString("TALK_CONTENT"));
        talkdto.setTalk_user( rs.getNString("TALK_USER"));
        talkdto.setWritten_at( rs.getTimestamp("WRITTEN_AT")); 
        
        talk.add(talkdto);
        
        for(int i = 0, size = talk.size(); i < size; i++) {
          System.out.println(talk.get(i));
        }
      }

    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      
      try {
        
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
      
    }
    
  }
   
  
  public static void main(String[] args) {
    method1();
    
    
  }

}
