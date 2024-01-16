package pkg03_unchecked;

public class MainClass {

  public static void main(String[] args) {

    // unchecked exception " try - catch 문이 없어도 동작하는 예외 클래스로 RunTimeException 을 의미한다. (나머지 클래스는 모두 checked exception 이다. 예외가 있는지 체크해서 동작한다.)
    
    int mok = 5 / 0;
    System.out.println(mok);
    
  }

}
