package pkg05_throw;

public class MainClass {

  public static void main(String[] args) {

    /*
     * throw
     * 1. 개발자가 직접 예외 객체를 만들어서(new) 던질 때 사용한다.
     * 2. 자바가 자동으로 던지지 않는 예외들은 throw 문으로 직접 던져야 한다.
     * 3. 자바가 예외로 인식 못하는 예시
     *  ex) 상황 ▶ 
     * 
     * 예외 상황을 if문으로 작성해서 throw new 객체명 으로 던진다.
     * 형식) throw new 객체명
     * 
     * throw 는 try 블록에서 catch 블록으로 던진다.
     * 
     * 자바에서는 문제가 발생되면 예외처리를 먼저 생각해라!!!
     */
    
    try {
      
      int score = 100; // 0 ~ 100
      char grade;
      
      if(score < 0 || score > 100) {
        throw new RuntimeException(); // RuntimeException(); : 인자값 
                                      // 던지면 catch의 매개변수가 받는다.
      }
      
      if(score >= 90)
        grade = 'A';
      else if(score >= 80)
        grade = 'B';
      else if(score >= 70)
        grade = 'C';
      else if(score >= 60)
        grade = 'D';
      else
        grade = 'F';
      
      System.out.println("점수 : " + score + "점, 학점 : "  + grade + "학점");
      
      
    } catch (Exception e) { // Exception e : 매개변수
      
      System.out.println("잘못된 점수입니다.");
      
    }
    
    
  }

}
