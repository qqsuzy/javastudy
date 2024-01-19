package pkg05_etc;

import java.util.Optional;

public class Class01_Optional {

  public static void main(String[] args) {

    // Optional<T> : T 타입의 데이터를 감싸는 클래스 (제네릭 타입 변수 사용)
    // ex) 사과가 있다면 사과를 포장하는 포장지 같은 역할
    
    // 1. null 값이 없는 데이터 (null 값이 없는 데이터는 굳이 쌀 필요가 없다.)  .of() , get()
    String str1 = "사과";                       
    Optional<String> opt1 = Optional.of(str1); // str1 전달 : 사과 전달
                                               // opt1 전달 : 포장지 전달 
    System.out.println(opt1.get());            // opt1 : 포장된 사과 -> opt1.get() : 포장된 사과를 꺼내 먹는다.
    
    
    // 2. null 값이 있는 데이터  (배우는 목적)  .ofNullable() , orElse()
    String str2 = null;                                // 아무 것도 없는데(null) 
    Optional<String> opt2 = Optional.ofNullable(str2); // 포장을 한다. null값 일 수도 있는 값을 포장할 때 ofNullable()
    System.out.println(opt2.orElse("바나나"));         // orElse()는 get() 메소드와 같이 동작, 값이 null일 때 "바나나" 를 반환한다. 값이 있으면 입력된 값을 반환한다. 
    
  }

}
