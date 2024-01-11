package practice07_Fighter;

public class MainClass {

  public static void main(String[] args) {
    
    // Fighter1
    Fighter fighter1 = new Fighter("정찬성", 150);
    
    // Fighter2
    Fighter fighter2 = new Fighter("김동현", 100);
    
    // trun (초기값 설정)
    boolean myTurn = true;
    
    // keep fight until KO
    while(fighter1.isAlive() && fighter2.isAlive()) { // fighter1 과 fighter2 둘 다 true 이면 while문이 실행된다.
      
      if(myTurn) {
        fighter1.punch(fighter2, 20 );
      } else {
        fighter2.punch(fighter1, 10 );
      }
      
      myTurn = !myTurn; // 
      
    }
    
   if(fighter1.isAlive() ) {
     System.out.println(fighter1.getName() + "의 승리를 축하합니다.");
   } else {
     System.out.println(fighter2.getName() + "의 승리를 축하합니다.");
   }
       
  }

}
