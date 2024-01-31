package db.service;

import java.util.List;

import db.dao.UserDao;
import db.dto.UserDto;

public class UserServiceImpl implements UserService {

  /*
   * Business Layer
   * 1. 핵심 로직을 처리하는 부분이다.
   * 2. Persistence Layer (DAO) 와 통신하는 레이어이다.
   * 3. DAO 로 전달할 데이터를 가공하거나, DAO 로부터 전달 받은 데이터를 가공한다.
   */
  
  // 인터페이스 구현 클래스명은 구현하고자하는 인터페이스명 뒤에 Impl을 붙인다.
  // ex) UserServiceImpl
  // 클래스 추가 시 인터페이스 Add 하여야 한다.
  
  // field (필드에 UserDao를 추가하여 모든 메소드가 호출할 수 있도록 한다.)
  private UserDao userDao;
  
  // constructor
  public UserServiceImpl() {
    userDao = UserDao.getInstance();  // static 처리 되어 있기 때문에 클래스명.getInstance() 메소드로 호출한다.
  }
  
  @Override
  public List<UserDto> getUsers() {
    return userDao.getUsers();   // getUsers() 를 호출하면 userDao의 getUsers 호출 결과를 받아와서 반환하겠다.
  }

  @Override
  public UserDto getUser(int user_no) {
    return userDao.getUser(user_no);
  }

  @Override
  public int saveUser(UserDto userDto) {
    return userDao.saveUser(userDto);
  }

  @Override
  public int modifyUser(UserDto userDto) {
    return userDao.modifyUser(userDto);
  }

  @Override
  public int removeUser(int user_no) {
    // TODO Auto-generated method stub
    return userDao.removeUser(user_no);
  }

}
