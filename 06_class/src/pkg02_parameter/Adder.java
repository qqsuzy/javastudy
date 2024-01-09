package pkg02_parameter;

public class Adder {

  // Adder 클래스가 add를 가지고 있음.
  void add(int... params) {
    int total = 0;
    for (int param : params) {
      total += param;
    }
    System.out.println("합 :" + total);
  }
  
}
