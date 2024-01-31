package db.ctrl;

import db.dto.UserDto;
import db.service.UserService;
import db.service.UserServiceImpl;

/*
 * Controller
 * 1. 사용자의 요청을 받는 영역이다.
 * 2. 사용자에게 응답을 보내는 영역이다. 
 * 3. 요청에 따른 Service 를 실행하고 실행 결과를 응답한다.
 */

 // 사용자(View) <-> Controller <-> Service <-> DAO <-> DB 

public class UserController {

  // field
  private UserService userService;
  
  // constructor
  public UserController() {
    userService = new UserServiceImpl();
  }
  
  // method
  public String requestHandle(String choice, UserDto userDto) { // 응답 결과를 String 으로 받는다. 사용자가 전달해준 정보를 받아오기 위해 파라미터가 필요하다. (번호,이름,연락처 모두 받아올 수 있는 파라미터) , UserDto userDto 에 모든 사용자 정보가 있다.
  
    String message = "";
    
    switch(choice) {
    case "1" : 
      for(UserDto user : userService.getUsers()) {
        message += user.toString() + "\n";
      }
      break;
    case "2" :
      UserDto user = userService.getUser(userDto.getUser_no()); // 정보가 있으면 정보를 읽고, 아니면 null 값 반환
      if(user == null) {
        message = "조회된 사용자 정보가 없습니다.";
      } else {
        message = user.toString();
      }
      break;
    case "3" :
      message = userService.saveUser(userDto) + "명의 정보가 등록되었습니다.";
      break;
    case "4" :
      message = userService.modifyUser(userDto) + "명의 정보가 수정되었습니다.";
      break;
    case "5" :
      message = userService.removeUser(userDto.getUser_no()) + "명의 정보가 삭제되었습니다.";
      break;
    }
    
    return message;
    
  }
}
