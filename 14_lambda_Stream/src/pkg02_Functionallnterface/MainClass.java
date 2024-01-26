package pkg02_Functionallnterface;

public class MainClass {

  public static void main(String[] args) {
    // interface MyInterface1 { void method(); }
    MyInterface1 my1 = () -> System.out.println("hello world");
    my1.method();
    
    // interface MyInterface2 { String method(); }
    /*
    MyInterface2 my2 = () -> {
      return "hello world";
    };
    */   
    MyInterface2 my2 = () -> "hello world";        // 본문 내용이 return 만 있는 경우 중괄호 {}와 return 키워드를 생략할 수 있다.
    System.out.println(my2.method());              // 위와 같은 코드
   
    // interface MyInterface3 { void method(String name); }
    MyInterface3 my3 = (name) -> System.out.println(name + "님");
    my3.method("민수지");
    
    // interface MyInterface4 { String method(String name); }
    MyInterface4 my4 = (name) -> name + "님";
    System.out.println(my4.method("민수지"));
    
  }
  
    
}
