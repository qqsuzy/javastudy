package practice04_Bus;

// Man 과 Woman 의 부모 클래스
public class Person {

  // field
  private String name;
  
  // constructor
  public Person() {
  
  }
  public Person(String name) {
    super();
    this.name = name;
  }
  
  // method
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
}
