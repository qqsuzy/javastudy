package pkg03_constructor;

/*
 * 자식 클래스의 생성자
 * 1. 반드시 부모 클래스를 가장 먼저 생성해야 한다.
 *    -> 부모 클래스의 생성자를 호출해야 한다. (생성자를 호출해야 객체 생성 가능) 
 * 2. 부모 클래스의 생성자를 호출하지 않는 경우 JVM이 부모 클래스의 디폴트 생성자를 자동으로 호출한다. (디폴트 생성자(파라미터가 없는)만 자동으로 호출 가능하다.)
 * 3. 부모 클래스에 디폴트 형식의 생성자가 없는 경우에는 개발자가 직접 부모 클래스의 생성자를 호출해야 한다.
 * 4. 부모 클래스의 생성자를 호출하는 방식
 *    super()   -> 엄마,아빠라고 부르는 명칭 (이름을 부르면 안된다.)
 *    
 */

public class Student extends Person {
  
  // field
  private String school;
  
  // constructor
  public Student() {
    super(null); // Person(name)
   
  }
  public Student(String name) {
    super(name); // Person(name) : super는 Person을 의미한다. 
  }
  
  public Student(String name, String school) {
    super(name);         // Person(name) 반드시 super의 호출을 먼저해야 한다.
    this.school = school;  
  }

  // method
  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }
  
  
  
}
