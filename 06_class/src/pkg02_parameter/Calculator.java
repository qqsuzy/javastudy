package pkg02_parameter;

public class Calculator {
  /*
   * 메소드의 구성
   * 1. 반환타입 : 메소드 실행 결과 값의 타입
   * 2. 메소드명 
   * 3. 매개변수 : parameter라고 함. 메소드로 전달되는 값(인수, 인자, argument)을 저장하는 변수
   * 
   *  annotation : 이렇게 동작하는 것이라고 자바한테 알려주는 것. 
   */
  
  /**
   * @param 파라미터
   * @return 반환값 (설명을 적어주는 부분)
   */
  
  // 매개변수가 없는 메소드 (매개변수, parameter를 받는 곳이다.)
  void method1() {
    System.out.println("method1");  
  }
  
//형변환 규칙을 어기지 않으면 매개변수를 받을 수 있으며, 타입을 동일하게 적용 권장함.
 // 같은 값을 받을 때는 이름을 동일하게 적용하기를 권장함! (int a)
 void method2(int a) {
   System.out.println("method2 :" + a);
 }
  
 void method3(String str) {
   System.out.println("method3 :" + str);
 }
 
 // 인자 값이 2개인 경우 
 void method4(double a, double b) {
   System.out.println("method4 :" + a + "," + b);   
 }
 
 void method5(int a) { // 파라미터
   method5_2(a); // 인자값
 }
 
 void method5_2(int a) { // 파라미터
   System.out.println("method5 :" + a);
 }

 // 가변 매개변수 (몇개를 전달해도 상관 없다.(...))
 void method6(int... params) { // parmas 는 사실 배열이다.
 System.out.println("method6"); 
  for(int i = 0; i <params.length; i++) {
    System.out.println(params[i]);
  }
  /*
  String.format("%4d", 10); // 전달하고자 하는 인자값 갯수 만큼 "%4d" 를 넣어준다.
  String.format("%4d%4d", 10, 20);
  */
}

 void method7(int[] arr) {
   System.out.println("method7");
   for(int a : arr) {
     System.out.println(a);
   }
 }

 // 객체 매개변수 
 void method8(Adder adder) {
   adder.add(1, 2, 3);
 }
 
}
