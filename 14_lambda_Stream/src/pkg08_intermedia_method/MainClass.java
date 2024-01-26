package pkg08_intermedia_method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

  public static void method1() {
    
    // filter() 메소드    -> if와 같은 메소드
    // Stream<T> filter(Predicate<T> predicate) { }  // 조건식(람다로 전달)을 세우는 것이 일반적이다. Predicate 로 람다를 전달하면 true 값만 Stream으로 전달한다. 
    
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    list.stream()                                               // List 를 Stream 으로 변환
      .filter((number) -> number % 2 == 0)                      // 짝수만 전달한다.
      .forEach((number) -> System.out.println(number));   
    
    /* 위와 같은 코드
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    Stream<Integer> numbers = list.stream();                    // List 를 Stream 으로 변환
    numbers
      .filter((number) -> number % 2 == 0)                      // 짝수만 전달한다.
      .forEach((number) -> System.out.println(number));   
    */
  }

  public static void method2() {
    
    List<Book> books = Arrays.asList(
        new Book("a", "aa", 20000),
        new Book("b", "bb", 8000),
        new Book("c", "cc", 5000),
        new Book("d", "dd", 15000),
        new Book("e", "ee", 25000)
      );
    
    
    books.stream()
      .filter((book) -> book.getPrice() >=10000)
      .forEach((book) -> System.out.println(book.getTitle()));
    
    List<Book> over20000 = books.stream()             // 2만원 넘는 book을 리스트로 모아준다.
      .filter((book) -> book.getPrice() >= 20000)
      .collect(Collectors.toList()); 
    System.out.println(over20000);
    
  }

  public static void method3() {
    
    // map() 메소드 : 값을 바꿀 때 사용
    // Stream<T> map(Function <T, R> function) { }
    
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    list.stream()
      .filter((number) -> number % 2 == 0)   // map 을 쓸 때는 filter() 메소드는 map() 메소드 앞에 넣는다!
      .map((number) -> number + 1) // number 을 넘기면 -> number 가 1 증가된다. (number + 1)
      .forEach((number) -> System.out.println(number));
    
    /*
     * 1. filter  : 짝수 만 걸러낸다.
     * 2. map     : 짝수 값을 + 1 한다.
     * 3. forEach : 값을 출력한다.
     */
    
  }

  public static void method4() {
    
    // 20000원 이상은 책 가격을 50% 세일한 리스트 생성하기
    
    List<Book> books = Arrays.asList(
        new Book("a", "aa", 20000),
        new Book("b", "bb", 8000),
        new Book("c", "cc", 5000),
        new Book("d", "dd", 15000),
        new Book("e", "ee", 25000)
      );
    
    List<Book> saleList = books.stream()
         .filter((book) -> book.getPrice() >= 20000)
         .map((book) -> new Book(book.getTitle(), book.getAuthor(), book.getPrice() / 2 ))
         .toList();
    
    saleList.stream()
        .forEach((book) -> System.out.println(book.getTitle() + ":" + book.getPrice()));
         
  }
  
  public static void main(String[] args) {

    method4();
  }

}
