package practice01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

public class MainClass {

  public static void method1() {
    
    // 파일명 만들기
    // 형식 : 하이픈이 제거된 UUID + 밑줄 + 타임스탬프.확장자
    
    String fileName = "apple.jpg";
    String extName = fileName.substring(fileName.lastIndexOf("."));
    StringBuilder builder = new StringBuilder();
    builder.append(UUID.randomUUID().toString().replace("-", ""));
    builder.append("_");
    builder.append(System.currentTimeMillis());
    builder.append(extName);
    
    System.out.println(builder.toString());
    
    
  /*  
   * String fileName = "apple.jpg";
   * String extName = fileName.substring(fileName.lastIndexOf("."));
    
    UUID uuid1 = UUID.nameUUIDFromBytes(fileName.getBytes());
    String result = uuid1.toString();
    
    int spaceIndex = result.lastIndexOf("-");
   // System.out.println(result.substring(spaceIndex + 1));
    String nonuuid = result.substring(spaceIndex + 1);
    
   Date date = new Date();
   SimpleDateFormat sdf = new SimpleDateFormat("h:mm yyyy-MM-dd");
   String timestamp = sdf.format(date);
  // System.out.println(timestamp);
  
   System.out.println(nonuuid + "_" + timestamp + extName);
  */ 
   
  }
  
  public static Map<String, Object> method2(String id) {
    
    // 나이 구하기 + 성별 구하기
    // 나이 : 현재년도 - 태어난년도
    // 성별 : 하이픈 뒤에 숫자가 1,3이면 남자, 2,4이면 여자
    
    // 나이, 성별을 메소드로 만들어서 반환
    
    // 현재 년도
    int nowYear = LocalDate.now().getYear();
    
    // 태어난 년도
    int birthYear = 0;
    
    // 하이픈 뒤의 숫자
    int afterHyphen = Integer.parseInt(id.substring(7, 8)); // id : 주민번호   7 부터 8전까지 가져오기 때문에 7만 가져온다.
    
    switch(afterHyphen) { 
    case 1 :
    case 2 : 
      birthYear = 1900 + Integer.parseInt(id.substring(0, 2)); 
      break;
    case 3 :
    case 4 :
      birthYear = 2000 + Integer.parseInt(id.substring(0, 2)); 
      break;
    }
    
    String[] genders = { "여자", "남자"};
      
    return Map.of("age", nowYear - birthYear
                 , "gender", genders[afterHyphen % 2]); // Immutable 값을 바꾸지 못하는 객체
  }
  
  public static void method3() {
    
    // 각 나라별 수도 맞히기
    
    // 프랑스 수도는? >>> 
    // 파리
    // 스위스 수도는? >>> 
    // 베른
    // 영국 수도는? >>> 
    // 런던
    // 독일 수도는? >>> 
    // 베를린
    // 이탈리아 수도는? >>> 
    // 로마
    // 5개 정답 성공
    
    Map<String, String> map = Map.of("프랑스", "파리"
                                   , "독일", "베를린"
                                   , "이탈리아", "로마"
                                   , "스위스", "베른"
                                   , "영국", "런던");
    
    Scanner sc = new Scanner(System.in); // ctrl + shift + o : import 자동으로 처리해주는 단축키
    
    int count = 0;
    for(Entry<String, String> entry : map.entrySet()) { // Key를 꺼내서 물어본다.
      System.out.println(entry.getKey() + " 수도는? >>>");
      String captital = sc.next();
      if(captital.trim().equals(entry.getValue())){  // String은 동등비교할 때 == 사용하면 안되고 equals() 사용하자, 사용자가 입력한 공백을 제거할 수 있도록 trim() 추가
        count++;
      }
     }
    System.out.println(count + "개 정답 성공");
    sc.close();
  }
 
  public static void method4() {
    
    // 5000원이 있는 통장(balance)에서 랜덤하게 출금하기
    // 실행예시)
    // 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
    // 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
    // 출금 전 122원, 3회 출금액 102원, 출금 후 20원
    // 출금 전 20원, 4회 출금액 2원, 출금 후 18원
    // 출금 전 18원, 5회 출금액 17원, 출금 후 1원
    // 출금 전 1원, 6회 출금액 1원, 출금 후 0원
    
    // 통장 잔액
    int balance = 5000;
    int count = 0;
    
    // 출금액 (money) : 1 <= 난수 <= balance
    
    while(balance > 0) {
      int money = (int)(Math.random() * balance + 1); // 1 ~ balance 까지
      count++;
      System.out.println("출금 전 " + balance + "원," + count + "회 출금액" + money + "원," + "출금 후" + (balance -= money) + "원");
    }
 
// 나의 풀이    
//    
//    for(int i = 1; money >= balance; i++ ) {
//      int money = (int)(Math.random() * balance);
//      System.out.println("출금 전 " + balance + "원," + i + "회" + "출금액" + money + "원," + "출금 후" + "원");
//      balance -= withdrawal;
//    }
   
    
  }
  
  public static void method5() {
    
 // 윷놀이
    // 실행예시1) "도", 1칸 이동한다.
    // 실행예시2) "개", 2칸 이동한다.
    // 실행예시3) "걸", 3칸 이동한다.
    // 실행예시4) "윷", "도", 5칸 이동한다.
    // 실행예시5) "모", "윷", "도", 10칸(move 의 합) 이동한다.
    
    String[] yuts = {"", "도", "개", "걸", "윷", "모"};
    
    StringBuilder builder = new StringBuilder(); 
    int move = 0;
    int totalMove = 0;
    
    do {
      move = (int)(Math.random() * 5 + 1); // 윷 던지는 코드 | 이동 횟수 랜덤하게 나온다. (1 ~ 5칸)
      totalMove += move;
      builder.append(yuts[move]);
      builder.append(",");
    } while (move >= 4);    // 윷, 모 일 때 1번 더 던지는 상황
    builder.append(totalMove).append("칸 이동한다."); // append() 옆에 append() 로 메소드 체이닝이 가능하다.
    
    System.out.println(builder.toString());
    
    // 왜 while 이 아니고 do while 일까?
    // 조건체크는 나중에 하시고 일단 윷을 던져라 (do) 그리고 조건 체크를 해라 (while)
    
  }
  
  public static void method6() {
    
    // SecureRandom을 이용해 "대문자+소문자+숫자"로 구성된 임의의 인증번호 만들기
    // 실행예시1)
    //   몇 자리의 인증번호를 생성할까요? >>> 4
    //   생성된 4자리 인증번호는 7W5e입니다.
    // 실행예시2)
    //   몇 자리의 인증번호를 생성할까요? >>> 6
    //   생성된 6자리 인증번호는 Fa013b입니다.
    
    
  }
  
  public static void method7() {

    // UpDown 게임
    // 컴퓨터가 1 ~ 10000 사이의 난수를 발생시킨다.
    // 사용자는 해당 난수를 맞힌다.
    // 실행예시)
    // 입력 >>> 5000
    // Down!
    // 입력 >>> 2500
    // Up!
    // ...
    // 입력 >>> 4500
    // 정답입니다. 총 5번만에 성공했습니다.
    
    
  }
  
  public static void method8() {

    // 0~9 사이 난수를 100개 발생시키고 발생한 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하시오.
    // 실행예시)
    // 0 : #### 4
    // 1 : ############ 12
    // 2 : ############ 12
    // 3 : ##### 5
    // 4 : ######## 8
    // 5 : ########### 11
    // 6 : ############ 12
    // 7 : ################## 18
    // 8 : ####### 7
    // 9 : ########### 11
    
    
  }
  
  public static void method9() {
    
    // 5 x 5 숫자 빙고판 자동 생성
    //
    // 지시사항)
    //   1. 1 ~ 25 사이 정수를 2차원 배열 bingo 에 순차적으로 넣는다.
    //      1  2  3  4  5
    //      6  7  8  9 10
    //     11 12 13 14 15
    //     16 17 18 19 20
    //     21 22 23 24 25
    //   2. 25번 서로 섞는다.
    //      순차적으로        랜덤하게
    //      모든요소접근      접근
    //      ----------------------------
    //      bingo[0][0]  <->  bingo[1][4]
    //      bingo[0][1]  <->  bingo[0][2]
    //      bingo[0][2]  <->  bingo[2][1]
    //      ...
    //      bingo[4][4]  <->  bingo[3][1]
    //
    // 실행예시)
    //  10  9  4 25  2
    //  15  3 13 21  1
    //  14 20 11 19  6
    //   8 17  5 12  7
    //  16 22 18 24 23
    
  }
  
  
  public static void main(String[] args) {
    
    method5();
    
// map을 for문으로 돌려서 확인하기
//    
//    Map<String, Object> map = method2("130101-4123456");
//    for(Entry<String, Object> entry : map.entrySet()) {
//      System.out.println(entry.getKey() + " :" + entry.getValue());
//    }
//    
    
    
    
  }

}
