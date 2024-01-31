package db.view;

import javax.swing.JOptionPane;

import db.dto.UserDto;

public class DetailView implements View {

  @Override
  public UserDto display() {
    
    // 상세 조회할 번호 입력 받기
    // 반환이 무조건 String
    String user_no = JOptionPane.showInputDialog("조회할 사용자의 번호를 입력하세요."); // 입력할 수 있는 대화상자
    
    return new UserDto(Integer.parseInt(user_no), null, null, null); // user_no 만 있으면 되기 때문에 나머지는 null 처리한다.   
      
  }

}
