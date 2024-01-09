package pkg04_overloading;

public class Adder {
  
  int add(int[] arr) {
    int total = 0;
    for(int n : arr) {
      total += n;
    }
    return total;
  }

  double add(double[] arr) {
    double total = 0.0; // 소수점 변수이기 때문에 합계 변수도 소수점으로 받는다.
    for(double n : arr) {
      total += n;
    }
    return total;
  }
  
}
