package pkg04_HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {

  public static void method1() {
    
    // HashSet 타입 선언
    Set<String> hobbies;
    
    // HashSet 객체 생성
    hobbies = new HashSet<String>();
    
    // 요소 추가하기 (순서 없이 저장되고, 중복 저장이 불가능하다.) -> set에 저장되려면 중복 검사를 한다.
    hobbies.add("수영");
    hobbies.add("수영");
    hobbies.add("수영");
    hobbies.add("여행");
    hobbies.add("게임");
    hobbies.add("영화감상");
    hobbies.add("음악감상");
    
    // advanced for 문
    for(String hobby : hobbies) {
      System.out.println(hobby);
    }
    
  }
  
  public static void method2() {
    
    // 교집합 
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5)); // list를 넘겨주면 내가 set를 만들어 넘겨주겠다. 1,2,3,4,5 가 들어있는 list
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4, 5, 6, 7, 8)); // 4, 5, 6, 7, 8 가 들어있는 list
    
    // set1 이 교집합 결과로 변환된다.
    // set1과 set2와 비교하여 교집합 결과 반환
    set1.retainAll(set2); 
    
    System.out.println(set1);
    
  }
  
  public static void method3() {
    
    // 합집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5)); 
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4, 5, 6, 7, 8)); 
    
    // set1 이 합집합 결과로 변환된다.
    // set1과 set2와 비교하여 합집합 결과 반환
    set1.addAll(set2); 
    
    System.out.println(set1);
 
    
  }
  
  public static void method4() {
    
    // 차집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5)); 
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4, 5, 6, 7, 8)); 
    
    // set1 이 차집합 결과로 변환된다.
    // set1과 set2와 비교하여 차집합 결과 반환
    set1.removeAll(set2); 
    
    System.out.println(set1);

  }
  
  public static void main(String[] args) {

    method3();
    
  }

}
