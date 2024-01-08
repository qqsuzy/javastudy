package pkg03_one_practice;

public class MainClass {

  public static void method1() {
    
    // 인덱스를 기반으로 if문 사용하지 않고 출력하기.
    // 월에 따른 계절 출력하기
    int month = 8;
    String[] seasons = new String[] {"겨울", "봄", "여름", "가을"};
    
    // 코드 한 줄만 추가할 것
   System.out.println(seasons[month % 12 / 3]);
    
   /* month     month % 12 (12로 나눈 나머지) month % 12 /3
    * 12 ~ 2    0 ~ 2                         0  
    * 3 ~ 5     3 ~ 5                         1
    * 6 ~ 8     6 ~ 8                         2
    * 9 ~ 11    9 ~ 11                        3
    */
    
  }
  
  public static void method2() {
   
      // 4일은 목요일, n일 후는 무슨 요일?
      
      int day = 4;      // 4일은 목요일
      int nDay = 4;    // nDay일 후
      String[] weekName = new String[] {"일", "월", "화", "수", "목", "금", "토"};  // 요일 (월~일)
      
      // day의 nDay일 후
      day += nDay;
      
      // 코드 한 줄만 추가할 것
      System.out.println(weekName[day % 7]);
      
    }
  
  public static void method3() {
    
    //ASCII 코드
    // int 65 == 'A' 
    // 'A' + 1 = 'B' or 66 둘 다 정답이다.
    char[] letters = new char[26];
    
    char ch = 'A';
    
    for(int i = 0; i < letters.length; i++) {
      letters[i] = ch++;
    }
    
    for(int i = 0; i < letters.length; i++) {
      System.out.println(letters[i]);
    } 
    
  }
  
  public static void method4() {
    
    // 배열 a의 마지막 3개 요소를  배열 b의 값으로 수정하기
    int [] a = new int[] {10, 20, 30, 0, 0, 0};
    int [] b = new int[] {40, 50, 60};
    
    /*
     * 1번)
     * 
     * a[3] = b[0];
     * b[4] = b[1];
     * a[5] = b[2];
    */
    
    // 2번)
    // 위에 1번 코드를 for문으로 작성한 답
    for(int i = 0; i < b.length; i++) {
      a[3 + i] = b[i];
    }
    /*
     * 배열 복사를 위한 자바 표준 API (3번 대신으로 사용 가능하다.)
     * System.arraycopy(b, 0, a, 3, b.length)
     * 1) 복사시작요소    : b[0] 요소를 a[3] 요소로 복사
     * 2) 복사할 요소개수 : b.length개 만큼 복사
     * 
     * 배열의 복사는 연속적이기 때문에 시작지점만 알려준다.
     */
    
    for(int i = 0; i < b.length; i++) {
      System.out.println(a[i]);
    }
    
    
  }
   
  public static void method5() {
    
    // 10진수를 2진수로 변환하기
    int number = 35;
    
    // 2진수                    // ┌
    int[] binary = new int[10]; // |
                                // └
    
    int i = 0;
    while(number > 0) {
      binary[i++] = number % 2;
      number /= 2; // number = number / 2;
    }
    
    for(int j = i - 1; j >= 0; j--) {
      System.out.print(binary[j]);
    }
    
  
  }
    
  public static void main(String[] args) {
    method5();

  }

}
