package pkg03_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

  /*
   * ArrayList 클래스
   * 1. 배열 리스트를 구현한 클래스이다.
   * 2. 실무에서는 배열 대신에 사용한다.
   * 3. 배열의 특징을 그대로 가지고 있다.
   *    1) 순서대로 데이터가 저장된다.
   *    2) 인덱스를 가지고 있다.
   * 4. 크기 제한이 없어 크기를 고려할 필요가 없다. (알아서 배열의 크기가 늘어나고 줄어든다.)
   * 5. 삭제기능도 구현할 필요 없이 자동으로 삭제가 가능하다.
   */
  
  public static void method1() {
    
    // ArrayList 선언 (사용 가능 타입 : Collection<E>, List<E> ArrayList<E>) -> 셋 중에 ArrayList의 직속 인터페이스인 List<E> 를 가장 많이 사용한다.  
    List<Integer> numbers;              // int[] numbers; 컬렉션 프레임워크는 전부 다 java.util 소속이다.
    
    // ArrayList 생성
    numbers = new ArrayList<Integer>(); // numbers = new int[10]; 자바가 크기를 자동으로 설정해주기 때문에 배열의 크기 설정이 필요없다.
    
    // 요소 추가하기
    numbers.add(5); // list 의 끝에 저장된다.
    numbers.add(4);
    numbers.add(3);
    numbers.add(2);
    numbers.add(1);
    
    // 요소 가져오기
    System.out.println(numbers.get(0));  // 5
    System.out.println(numbers.get(1));  // 4
    System.out.println(numbers.get(2));  // 3
    System.out.println(numbers.get(3));  // 2
    System.out.println(numbers.get(4));  // 1
 
  }
  
  public static void method2() {
    
    // ArrayList 선언 및 생성
    List<String> hobbies = new ArrayList<String>();
    
    // 요소 추가하기
    hobbies.add("게임");
    hobbies.add("여행");
    hobbies.add("수영");
    hobbies.add("레고");
    hobbies.add("모임");
    
    // 저장된 요소의 개수
    System.out.println(hobbies.size());
    
    // for 문 : 메소드 호출을 여러번하지 않고 한번만 호출될 수 있도록 초기화 값 넣는 부분에 size = hoobies.size()를 넣어준다. (size = 5; 와 같다.)
    for(int i = 0, size = hobbies.size(); i < size; i++) {
      System.out.println(hobbies.get(i));
    }
    
  }
  
  public static void method3() {
    
    // Arrays : 배열의 헬퍼 클래스?
    // 배열을 ArrayList로 바꾸기 
    Integer[] arr = new Integer[] { 10, 20, 30 }; // ArrayList는 int가 불가하기 때문에 Integer 사용
    
    // 배열을 List로 바꿔서 반환하는 java.util.Arrays 클래스의 asList 메소드
    List<Integer> numbers = Arrays.asList(arr);
    
    // 주의!
    // numbers는 길이를 변경할 수 없다. (추가, 삭제 불가)
    System.out.println(numbers.toString()); 
    System.out.println(numbers);            // toString 메소드 생략 
                                            // 단순히 값만 확인하는 거라면 for문을 돌리지 않아도 된다.
  }

  public static void mehtod4() {
    
    List<String> seasons = new ArrayList<String>();
    
    seasons.add("봄");
    seasons.add("여름");
    seasons.add("햄버거");    
    seasons.add("피자");
    seasons.add("겨울");
    
    // 요소 수정
    seasons.set(2, "가을"); // index, 수정하고자 하는 String
    
    // 요소 삭제
    // remove(int index) String 타입 반환  : "피자" 를 지웠다.
    // remove(Object o)  boolean 타입 반환 : true(지웠다) , false(못지웠다)
    String removeItem = seasons.remove(3);
    System.out.println(removeItem);
    
    System.out.println(seasons);
    
  }
  
  public static void main(String[] args) {
    
    mehtod4();
    
  }

}
