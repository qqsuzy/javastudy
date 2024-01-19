package pkg05_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 *   <Map> : Mapping
 *
 *   --------------    
 *   key :  변수이름 
 *   value :  변수값
 *   --------------
 * 
 * 1. map은 만능 저장소이다.
 * 2. Entry는 여러개가 존재할 수 있으며, 하나의 entry 안에 여러 값이 들어갈 수 있다.
 * 3. 프로그램의 구조 변화에도 굉장히 강하다. -> 이에 실무에 매우매우매우 많이 쓰임!
 * 4. 맵을 객체 대신에 사용하면 편하다.
 * 
 *   object vo 와 동일한 구조를 가지고 있음 그러나 vo 보다 Map 사용을 권장한다! (상단 3번의 이유!!)
 * 
 * - key 값은 변수명과 동일하게 중복값을 가질 수 없다.
 *   (hash 코드를 기반으로 중복값 검사를 하기 때문에 hash 기반의 map이다.)
 * - key는 Set 기반으로 되어있어 key값 순서는 없고, 중복 값도 없다.
 * 
 * 
 * List < Map <K, V>>
 * 실무에서 많이 쓰이는 구조이고, List 안에 map이 들어가면 엄청 만능이다.
 * 
 *  ----------------------------------------------------------------------------------------------------
 * 
 * HashMap
 * 
 * 1. 객체(인스턴스)를 대신할 수 있는 자료구조이다. (실무에서는 객체보다 map을 주고 받는 경우가 많다.)
 * 2. 구성
 *    1) key   : 데이터 식별자, Set 으로 구성되어 있다. (순서 없고 중복 없다.)
 *    2) Value : 데이터 자체 
 *    3) Entry : Key 와 Value 를 합쳐서 부르는 말이다. (자바는 Entry가 인터페이스로 만들어져 있다.)
 *    
 */

public class MainClass {
  
  public static void method1() {
    
    // Mutable 객체 (값이 변할 수 있는 객체)
    
    // HashMap 선언
    // 일반적으로 key 는 String , Value는 Object(숫자,문자 저장) 를 많이 사용한다.
    Map<String, Object> book;
    
    // HashMap 생성
    book = new HashMap<String, Object>();
    
    // Key, Value 추가 (Entry 추가)
    book.put("title", "어린왕자");
    book.put("author", "생텍쥐베리");
    book.put("isBestSeller", true);
    book.put("price", 10000);
    
    // key를 이용해서 value 확인하기
    System.out.println(book.get("title")); // ArrayList와 동일하게 get. 으로 값을 가져온다.
    System.out.println(book.get("author")); 
    System.out.println((boolean)book.get("isBestSeller") ? "베스트셀러" : "일반서적"); // Object 는 모든지 저장할 수 있으나 꺼냈을 때 조심해야한다. object를 꺼내쓸 때는 캐스팅해야한다. boolean으로 캐스팅한다. (object에는 boolean 타입으로 저장되어 있는 것이 아닌 true, false로 저장되어 있기 때문)
    System.out.println(book.get("price" + "원" ));   
    
  }
  
  public static void method2() {
    
    // Immutable 객체 (값을 바꾸지 못하는 객체)
    // 반환할 때 사용하는 것이 좋다. (해킹을 대비해서 안전하게 반환)
    
    // 형식
    //  Map.of()  --> 인터페이스 이름으로 호출되는 메소드? (static)
     
    Map<String, Object> map = Map.of("name", "홍길동");
    
    // 값을 바꾸려는 시도
    // map.put("age", 10);
    
    System.out.println(map.get("name"));
    
  }
  
  public static void method3() {
    
    // Key 는 Set 으로 되어 있다.
    Map<String, Object> map = Map.of("name", "홍길동"
                                    , "age", 10
                                    , "isMarried", false);
    
    // key만 빼서 get(key)
    Set<String> keys = map.keySet(); // set는 순서가 없기 떄문에 어드밴스드 for문 사용이 가능하다.
    for(String key : keys) {         // map은 iterable 하지 않기 때문에 set 로 바꾸어서 for문을 돌린다. (map 자체는 반복문을 돌릴 수 없다.)
      System.out.println(key + ":" + map.get(key)); // map의 get 메소드의 key값 전달하기.
    }

  }
  
  public static void method4() {
    
    // Entry 전체를 Set 로 만들 수 있다.
    
    Map<String, Object> map = Map.of("name", "홍길동"
        , "age", 10
        , "isMarried", false);
    
    // 선생님은 method3 보다 추천!!!!
    // Entry로 빼서 Set으로 만들고 (entrySet) getKey, getValue 를 출력한다.
    Set<Entry<String, Object>> entrySet = map.entrySet(); // Entry가 저장된 Set
    for(Entry<String, Object> entry : entrySet) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
      
    }
    
   public static void method5() {
    
     Map<String, Object> map = new HashMap<String, Object>();
     
     // 처음 입력되는 Key 는 추가된다.
     map.put("name", "홍길동");
     map.put("age", 10);
     map.put("isMarried", false);
  
     // 다시 입력되는 Key 는 수정을 의미한다. (수정 메소드가 따로 있는 것은 아니다.)
     map.put("age", 20);
     
     // 삭제 (Key 값을 전달해라)
     map.remove("isMarried"); 
     
     System.out.println(map);
  
  }

  public static void main(String[] args) {
    method4();
   
  }

}
