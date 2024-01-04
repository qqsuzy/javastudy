package pkg03_branch_practice;

public class MainClass {
  
public static void method1() {
    
    // 월에 따른 계절 출력하기
    int month = 9;
    
    if (month <= 2) {
      System.out.println("겨울");
    } else if (month <= 5) {
      System.out.println("봄");
    } else if (month <= 8) {
      System.out.println("여름");
    } else if (month <= 11) {
      System.out.println("가을");
    }
    
  }
  
  public static void method2() {
    
    // 점수와 학년에 따른 합격 여부
    // 1~3학년 : 60점 이상이면 합격, 아니면 불합격
    // 4~6학년 : 70점 이상이면 합격, 아니면 불합격
    
    int score = 70;  // 점수
    int grade = 5;   // 학년
    
    if (grade <= 3 && score >= 60 ) {
      System.out.println("합격");
    } else if (grade <= 3 && score <= 59 ) {
      System.out.println("불합격");
    } else if (grade <= 6 && score >= 70) {
      System.out.println("합격");
    } else if (grade <=6 && score <= 59) {
      System.out.println("불합격");
    }
    
  } 
    
    
   /* 
     if (grade <= 3 && score >= 60 ) {
     if (score >= 60){
       System.out.println("합격");
     } if else System.out.println("불합격");
    } if else {
      if (score >= 70) {
        System.out.println("합격");
      } else System.out.println("불합격");
    
  }
    */
  
  public static void method3() {
    
    // 4일은 목요일, n일 후는 무슨 요일?
    
    int day = 4;      // 4일은 목요일
    int nDay = 10;    // nDay일 후
    String weekName;  // 요일 (월~일)
    
    if (day == 4) {
      System.out.println("목요일");
    } else if (day + nDay) {
      
    }
    
  }
  
  

  public static void main(String[] args) {
    
    method2();
    
  }

}
