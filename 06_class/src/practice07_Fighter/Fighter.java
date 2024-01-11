package practice07_Fighter;

public class Fighter {

  // field
  private String name;
  private int hp; // 파이터만 다르게 주기

  // constructor
  public Fighter() {
    
  }

  public Fighter(String name, int hp) {
    super();
    this.name = name;
    this.hp = hp;
  }
 
  // method 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
  
  // isAlive()
  public boolean isAlive() {
    return hp > 0; // hp가 남아 있으면 true 반환, hp가 없으면 false 반환이 된다.
  }
  
  // punch() 
  public void punch(Fighter other, int power) {
   System.out.println(name + "의 펀치");
     if(power >= other.getHp()) {
       other.setHp(0);
     } else {
       other.setHp(other.getHp() - power);
     }
     
     System.out.println("<" + name + "의 hp : " + hp + "," + other.getName() + "의 hp :" + other.getHp() + ">");

      
  }
  
}
