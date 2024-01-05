package pkg04_loop_practice;

public class MainClass {

  public static void method1() {
    
    
    // 100 ~ 1 출력하기
    
    int n = 100;
    
    while (n >= 1) {
      System.out.println(n--); // 출력 후 감소하기
    }  
    
  }
  
 public static void method2() {
   
   // 1 ~ 4 사이 모든 정수의 평균 (합계/개수)
   int begin = 1;
   int end = 4;
   
   int n = begin;
   int total = 0;
   while(n <= end) {
     total += n;
     n++;
   }
   
   double average = total / (end - begin + 1.0);
   System.out.println(average);
   
  }
 
 public static void method3() {
   
   // 구구단 3단 출력하기
   int dan = 3;
   
   for(int n = 1; n <= 9; n++ ) {
     
     System.out.println(dan + "x" + n + "=" + dan * n); // 연결연산자로 쓰려면 반드시 String("")이 필요하다.
     
     // 정답 2
     // System.out.print(dan);
     // System.out.print("x");
     // System.out.print(n);
     // System.out.print("=");
     // System.out.print(dan * n);
   
   }
  
 }
 
 public static void method4() {

   
   // 70원씩 모금하기
   // 목표는 100,000원 이상
   
   // 1회 모금액 70원
   // 2회 모금액 140원
   // 3회 모금액 210원
   // ...
   // n회 모금액 100,000원 이상 금액이 모이면 끝내기
   
   int money = 70;           // 1회 모금액
   int total = 0;            // 전체 모금액
   final int GOAL = 100_000; // 목표 (천단위 구분기호 지원하며 언더바(_)로 표기한다.)
   int nth = 0;              // 회차 (회차의 값이 정해져 있지 않기 때문에 while문으로 풀어냈다.)
   
   while(total < GOAL) {
     total += money;
     nth++;
     System.out.println(nth + "회 모금액" + total + "원");
             
   }   
   
 }

 public static void method5() {
   
   // 2 x 1 = 2
   // 2 x 2 = 4
   // ...
   // 5 x 5 = 25
  // fix값은 Outer loop 로 밖에 두고 변하는 값은 Innner loop로 안에 둔다.
   
   outer : // 라벨 -> 특정 위치에 라벨링을 해서 루프를 조작했다. (break를 어디서 걸어야하는지 지정함)
   for (int dan = 2; dan <= 9; dan++) {
     for (int n = 1; n <= 9; n++)  {
      
     System.out.println(dan + "x" + n + "=" + dan * n );
     if(dan == 5 && n == 5) {
       break outer;
       
       }
      
     }
 
   }
   
 }
 
 public static void method6() {
   
   // 2x1=2 3x1=3 ... 9x1=9
   // 2x2=4 3x2=6 ... 9x2=18
   // ...
   // 2x9=18 3x9=27 ... 9x9=81
   
   
   for(int n = 1; n <= 9; n++) {
     for(int dan = 2; dan <= 9; dan++) {
       System.out.print(dan + "x" + n + "=" + dan * n + "\t");
       
     }
    System.out.println(); // 줄바꿈
   } 
   
 }

 public static void method7() {
  
   /*
    * 삼각별 출력하기-1
    *        star=12345 
    * row=1       * 
    * row=2       ** 
    * row=3       *** 
    * row=4       **** 
    * row=5       *****
    * 
    * row=1, star=1~1 
    * row=2, star=1~2 
    * row=3, star=1~3 
    * row=4, star=1~4 
    * row=5, star=1~5
    * fix값    inner
    * 
    * row = 1~5 ,  star = 1 ~ row 
    * 
    * 구체화 된 값을 매기는 연습을 해야한다.
    * 정확히 수치값이 어떻게 변하는지 알아야 코딩할 수 있다. (일정한 규칙을 알아내자~)
    * 
    */
   
   for(int row = 1; row <= 6; row++) {
     for(int star = 1; star <= row; star++) {
       System.out.println("*");
     }
     
   }
   
   
   
 }
 
 public static void method8() {
   
   /*
    * 삼각별 출력하기-2
    *        star=12345
    * row=1       *****
    * row=2       ****
    * row=3       ***
    * row=4       **
    * row=5       *
    * 
    * row=1, star=1~5
    * row=2, star=1~4
    * row=3, star=1~3
    * row=4, star=1~2
    * row=5, star=1~1
    * 
    * row=1~5, star=1~6-row
    * 
    * 
    */
     
 }

 public static void method9() { 
   
   /*
    * 삼각별 출력하기-3
    * space/star=123456789
    * row=1          *
    * row=2         ***
    * row=3        *****
    * row=4       *******
    * row=5      *********
    * 
    * row=1, space=1~4, star=5~5
    * row=2, space=1~3, star=4~6
    * row=3, space=1~2, star=3~7
    * row=4, space=1~1, star=2~8
    * row=5, space=1~0, star=1~9
    * 
    * row=1~5, space=1~5-row, star=6-row~row+4
    * 
    */
   
 }
 
 public static void method10() {
   
   /*
    * 삼각별 출력하기-4
    * space/star=123456789
    * row=1      *********
    * row=2       *******
    * row=3        *****
    * row=4         ***
    * row=5          *
    * 
    * row=1, space=1~0, star=1~9
    * row=2, space=1~1, star=2~8
    * row=3, space=1~2, star=3~7
    * row=4, space=1~3, star=4~6
    * row=5, space=1~4, star=5~5
    * 
    * row=1~5, space=1~row-1, star=row~10-row
    * 
    * 
    */
   
   for(int row = 1; row <= 5; row++) {
     for(int space = 1; space <= row - 1; space++) {
       System.out.print(" ");
     }
       for(int star = 1; star <= 10 - row; star++) {
         System.out.print("*");  
       }
      System.out.println(); 
     }
   }
 
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    method7();
    
  }
 
  
}
