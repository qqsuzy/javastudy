package db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.dto.UserDto;

/*
 * DAO (Database Access Object)
 * 1. 데이터베이스에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받는 객체이다.
 * 2. 하나의 객체만 만들어서 사용하는 Singleton Pattern 으로 DAO 객체를 생성한다.
 * 
 * 데이터베이스 접속할 때 사용하는 객체
 * 클래스명은 DAO로 연결하고자 하는 테이블명을 앞에 표기하여 정한다. ex) UserDao
 * 
 */

/*
 * Singleton Pattern
 * 1. 오직 하나의 객체만 만들어서 사용하는 패턴이다.
 * 2. 클래스 내부에서 객체를 미리 만든 뒤 해당 객체를 가져다 사용할 수 있도록 메소드를 제공한다.
 * 3. 클래스 외부에서는 객체를 생성할 수 없도록 생성자를 private 처리한다.
 */

public class UserDao {

  // Singleton Pattern
  private UserDao() {}
  private static UserDao userDao = new UserDao();
  public static UserDao getInstance() {
    return userDao;   // 만들어 준 객체를 반환
    
  }
  
  // field
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  // private 메소드 (UserDao 내부에서 호출하는 메소드라 private 처리)
  private void connection() { 
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
    } catch (ClassNotFoundException e) {
      System.out.println("OracleDriver 클래스 로드 실패");
    } catch (SQLException e) {
      System.out.println("데이터베이스 접속 실패");
    }
 
  }

  // close() 메소드를 호출하면 rs, ps, con 을 닫아준다. (내부에서 호출하는 메소드라 private 처리)
  private void close() {
    
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  // public 메소드 (실제 기능을 담당하는 메소드)
  // 모든 사용자 조회하기 : selectUsers, selectUserList, getUsers, getUserList 등
  public List<UserDto> getUsers() {

    List<UserDto> users = new ArrayList<UserDto>();

    try {
      
      connection();
      
      String sql = "SELECT USER_NO, USER_NAME, USER_TEL, JOIN_DT FROM USER_T ORDER BY USER_NO DESC";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        UserDto userDto = new UserDto();
        userDto.setUser_no(rs.getInt(1));
        userDto.setUser_name(rs.getString(2));
        userDto.setUser_tel(rs.getString(3));
        userDto.setJoin_dt(rs.getString(4));
        users.add(userDto);
      }
      
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return users;
    
  }
    
  // 특정 사용자 조회하기 : getUser, getUserByNo 등
  public UserDto getUser(int user_no) {  // 사용자 번호를 받아와서 해당 사용자를 반환해준다.
    
    UserDto userDto = null;
    
    try {
      
      connection();
      
      String sql = "SELECT USER_NO, USER_NAME, USER_TEL, JOIN_DT FROM USER_T WHERE USER_NO = ?"; // 변수를 직접 쿼리문에 넣으면 SQL injection 을 당할 우려가 있다. (지양하기)
      ps = con.prepareStatement(sql);
      ps.setInt(1, user_no);
      rs = ps.executeQuery();
      
      if(rs.next()) {
        userDto = new UserDto();
        userDto.setUser_no( rs.getInt(1));
        userDto.setUser_name( rs.getString(2));
        userDto.setUser_tel( rs.getString(3));
        userDto.setJoin_dt( rs.getString(4));
      }
 
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return userDto;
    
  }

  // 사용자 등록  : insertUser, saveUser, regiterUser 등
  public int saveUser(UserDto userDto) {
    
    int result = 0; // 등록 실패시 0 반환 (초기화) 
    
     try {
      
      connection();
      String sql = "INSERT INTO USER_T (USER_NO, USER_NAME, USER_TEL, JOIN_DT) VALUES(USER_SEQ.NEXTVAL, ?, ?, TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD'))";
      ps = con.prepareStatement(sql);
      ps.setString(1, userDto.getUser_name());  // user_name , user_tel은 userDto가 가지고 있다?
      ps.setString(2, userDto.getUser_tel());
      result = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return result;
    
  }
  
  // 사용자 수정  : updateUser, modifiyUser 등
  public int modifyUser(UserDto userDto) {
    
    int result = 0;
    
    try {
      
      connection();
      String sql = "UPDATE USER_T"
                 + "   SET USER_NAME = ?, USER_TEL = ?"
                 + " WHERE USER_NO = ?";
      
      ps = con.prepareStatement(sql);
      ps.setString(1, userDto.getUser_name());
      ps.setString(2, userDto.getUser_tel());
      ps.setInt(3, userDto.getUser_no());
      result = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return result;

  }
  
  // 사용자 삭제  : deleteUser, removeUser 등
  public int removeUser(int user_no) {
    
    int result = 0;
    
    try {
      
      connection();
      String sql = "DELETE FROM USER_T WHERE USER_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, user_no);
      result = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return result;
    
  }
}
