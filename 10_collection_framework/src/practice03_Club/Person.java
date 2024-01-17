package practice03_Club;
/* 
 * 해시 알고리즘 
 * 1. 같은 해시값을 가지고 있는 파트를 찾아서 조회한다. (full scan 방지!)
 * 2. 여러 파트로 나눌 수록 성능이 좋다. 
 * 
 * < search 진행 순서 > 
 * 1. part 
 *    hashcode            해시값 비교 -> equals
 * 2. equals
 * 
 *  동일한 값이 들어왔을 때 사용되며, 빠른 조회를 위해서 해시코드를 이용한다.
 *  
 *  해시코드 (Hash Code) : 각 파트마다 가지고 있는 값
 * 
 */

public class Person {

  private String id;
  
  public Person() {
    
  }

  public Person(String id) {
    super();
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode()); // 해시코드를 만들기 전에는 어떠한 데이터의 참조값을 기반으로 조회를 한다. 이후 해시코드 생성 후 해시코드 기반으로 조회
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id)) // id 비교 후 아니면 false 반환
      return false;
    return true;
  }
  
  
  
}
