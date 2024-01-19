package pkg03_input;

import javax.swing.JOptionPane;

public class Class02_JOptionPane {

  public static void main(String[] args) {

    String name = JOptionPane.showInputDialog("이름을 입력하세요");  // javax.swing 에 저장된 패키지로 실무에서 사용하지 않는다.
    String strAge = JOptionPane.showInputDialog("나이를 입력하세요");
    String strHeight = JOptionPane.showInputDialog("키를 입력하세요");
    String strGender = JOptionPane.showInputDialog("성별을 입력하세요");
    
    int age = Integer.parseInt(strAge);
    double height = Double.parseDouble(strHeight);
    char gender = strGender.charAt(0);
    
    JOptionPane.showInternalMessageDialog(null, name + "," + age + "," + height + "," + gender); 
  }

}
