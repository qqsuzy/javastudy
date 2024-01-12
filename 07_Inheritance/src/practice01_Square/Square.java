package practice01_Square;

public class Square extends Rectangle {

  public Square(int n) { // n = 너비, 높이
    super(n, n); 
    // super(); 는 parameter가 없는 Public Rectangle(); 생성자를 호출하는 것이기 때문에 width와 height를 가지고 있는 아래의 생성자를 호출해야함! 
  }
  
  
}
