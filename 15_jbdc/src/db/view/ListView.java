package db.view;

import javax.swing.JOptionPane;

import db.dto.UserDto;

public class ListView implements View {

  @Override
  public UserDto display() {
    JOptionPane.showMessageDialog(null, "전체 명단을 가져옵니다."); // showMessageDialog() 메세지를 보여주는 대화상자
    return null;
  }

}
