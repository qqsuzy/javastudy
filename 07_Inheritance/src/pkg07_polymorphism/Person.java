package pkg07_polymorphism;

public class Person {

  public void powerOn(Elec elec) { // Elec elec = new Tv() 또는 Elec elec = new Radio() 전자제품의 전원을 킬 수 있는 동작
    
    
    /* 1. 다운캐스팅으로 powerOn() 호출하기 -> 전자제품이 추가될 때마다 코드의 추가가 필요하므로 추천하지 않는다.
     * 
     * if(elec instanceof Tv) {
     * ((Tv) elec).powerOn();
     * }
     * else if(elec instanceof Radio) {
     * ((Radio) elec).powerOn();
     * }
     */
    
    /*
     *  2. Elec 에 powerOn() 메소드를 추가하고 Tv 나 Radio 가 오버라이드 하기
     */
    elec.powerOn(); // 다형성 : 하나의 코드로 여러가지를 실행한다.
    
    
    // 1. 클래스에 부모를 세울 것 
    // 2. 
    //
    // 클래스들의 공통 타입을 가진다. (하나의 타입으로 여러개의 객체를 만들 때)
    
    /*
     * MemberService.java - 부모
     * void excute() {}
     * 
     * LoginService.java  - 자식
     * @Override
     * void excute() { 코드 }
     * 
     * LogoutService.java  - 자식
     * @Override
     * void execute() { 코드 }
     * ------------------------------
     * user/login.do 
     * 
     * 
     */
    
    
    
  }
  
  
}
