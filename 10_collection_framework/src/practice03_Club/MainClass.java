package practice03_Club;

public class MainClass {

  public static void main(String[] args) {

    Club club = new Club();
    
    Person p1 = new Person("1");
    Person p2 = new Person("2");
    Person p3 = new Person("3");
    Person p4 = new Person("4");
    Person p5 = new Person("5");
    
    club.enterClub(p1);
    club.enterClub(p2);
    club.enterClub(p3);
    club.enterClub(p3);
    club.enterClub(p3);
    club.enterClub(p4);
    club.enterClub(p5);
    club.enterClub(new Person("6"));
    club.enterClub(new Person("6"));
    
    // p3는 참조값이 동일하나 new Person을 사용하면 참조값이 다르기 때문에 중복허용
    // Set의 기본 동작 : 참조값을 확인해서 중복 체크를 한다. Set에 저장될 때는 전부 참조값으로 저장되므로 참조값이 동일하면 중복제거, 아니면 저장된다.
    // 참조값으로 비교하지 않고 id를 꺼내서 비교할 것을 직접 코드 추가를 하지 말고 source > generate 메뉴 활용
    // equals 는 참조값을 비교하므로 person에 다시 equals를 만들어서 id를 비교하도록 equals override
    // hashset에는 기본적으로 equals를 가지고 있음
    
    club.leaveClub(p1);
    
    club.poolList();
    
  }

}
