package pkg05_marker_interface;

// 음식 (먹을 수 있는 음식이 아니다.)

public class Durian implements Food {

  @Override
  public void eat() {
    System.out.println("두리안 먹는다.");
    
  }
  
}
