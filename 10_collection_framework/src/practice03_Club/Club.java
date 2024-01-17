package practice03_Club;

import java.util.HashSet;
import java.util.Set;

public class Club {

  // field
  private Set<Person> pool; // 사람들이 여려명 저장되는 Set
  
  public Club() {
    pool = new HashSet<Person>();
  }
  
  // method
  // 입장
  public void enterClub(Person person) {
    pool.add(person);
  }
  
  // 퇴장
  public void leaveClub(Person person) {
    pool.remove(person);
  }
  
  // 명단 확인
  public void poolList() {
    
    for(Person person : pool) {
      System.out.println(person);
    }
    
  }
  
}
