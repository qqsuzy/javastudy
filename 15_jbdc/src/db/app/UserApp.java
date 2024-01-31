package db.app;

import java.util.List;

import javax.swing.JOptionPane;

import db.ctrl.UserController;
import db.dao.UserDao;
import db.dto.UserDto;
import db.service.UserService;
import db.service.UserServiceImpl;
import db.view.DeleteView;
import db.view.EditView;
import db.view.ListView;
import db.view.RegisterView;
import db.view.View;

// UserApp 동작 흐름
/*
 * UserApp             UserController                                        UserService                                  UserDao
 *  작업 선택       ->
 *  View 실행 결과  ->
 *                     String requestHandle(작업 선택, View 실행 결과) {
 *                       작업에 따른 서비스 호출(View 실행 결과 전달)     ->
 *  작업결과메시지  <-   작업결과 메시지 반환
 *  확인               }
 *                                                                           반환 타입 선택된메소드(View 실행 결과) {
 *                                                                            DAO 메소드 호출(View 실행 결과)         -> 
 *                                                                        <-  반환값 반환           
 *                                                                           }
 *                                                                                                                        반환타입 선택된메소드(View 실행 결과) {
 *                                                                                                                         DB 처리
 *                                                                                                                    <-   반환값 반환
 *                                                                                                                        }
 *                                                                   
 */


public class UserApp {

  public static void main(String[] args) {
    
    UserController userController = new UserController();
    
    while(true) {
      String choice = JOptionPane.showInputDialog("1.전체명단\n2.상세조회\n3.등록\n4.편집\n5.삭제\n0.종료\n원하는 작업 번호를 입력하세요.");
      View view = null;
      switch(choice) {  // switch 문은 view 만 부른다.
      case "1" : view = new ListView(); break;
      case "2" : view = new DeleteView(); break;
      case "3" : view = new RegisterView(); break;
      case "4" : view = new EditView(); break;
      case "5" : view = new DeleteView(); break;
      case "0" : JOptionPane.showMessageDialog(null, "사용자 앱을 종료합니다"); return; // breaK 는 switch 문만 빠
      default : JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 선택하세요.");
      }
      if(view != null) { // null 이 아닌 것 case 1 ~ 5
        String message = userController.requestHandle(choice, view.display()); // 각 choice 에 view display() 메소드를 호출 -> 각 메소드의 메시지 출력
        JOptionPane.showMessageDialog(null, message);
      }
    }
    
    //System.out.println(userController.requestHandle("3", new UserDto(0, "테스트이름", "테스트연락처", null)));
    //System.out.println(userController.requestHandle("1", null));  // 전체 조회할 때는 넘기는 값이 없기 때문에 null 넣기.
   
    // 사용자 등록
    //UserDto userDto = new UserDto(0, "테스트이름", "테스트연락처", null);
    // UserDao userDao = UserDao.getInstance();
    // int result = userDao.saveUser(userDto);
    // System.out.println(result + "행이 삽입되었습니다.");

    // 모든 사용자 조회
    //UserService userService = new UserServiceImpl();
    
    // List<UserDto> users = userService.getUsers();
    // for(UserDto user : users) {
    // System.out.println(user);
    // }
    
    // 특정 사용자 조회
    // UserDto userDto = userDao.getUser(1);
    // System.out.println(userDto);
    
    // 수정
    // UserDto userDto = new UserDto(1, "수정이름", "수정연락처", null);
    // int result = userDao.modifyUser(userDto);
   //  System.out.println(result + "행이 수정되었습니다.");
    
    // 삭제
    //int result = userDao.removeUser(1);
    //System.out.println(result + "행이 삭제되었습니다.");
  }

}
