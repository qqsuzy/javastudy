package practice05_Bakery;

public class Bakery {
  
  // field
  public final static int PRICE = 500; // 빵가격
  private int count; // 빵개수 
  private int money; // 돈
  
  // constructor
  public Bakery() {
    
  }
  
  // method
  public Bakery(int count, int money) {
    super();
    this.count = count;
    this.money = money;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }
  
  // 판매
  // 전달 받는 인자 : 돈, 빵개수
  // 되돌려 줄 반환 : 잔돈, 구매한 빵개수 -> BreadChange 객체 (객체화 하여 반환한다.)
  public BreadChange sell(int money, int count) {
    
    // 판매할 빵이 없다.
    if(this.count < count) {
      System.out.println("빵이 부족합니다.");
      return null; // 반환타입이 void가 아니기 때문에 무언가(null)를 반환해주어야 한다.
    }
    
    // 잔돈이 부족하다.
    if(this.money < money - count * PRICE ) { // 내가 가진 돈 : this.money
      System.out.println("잔돈이 부족합니다.");
      return null;
    } 
    
    // 고객이 낸 돈이 부족하다.
    if(money < count * PRICE) {
      System.out.println("돈 더 주세요.");
      return null;
    } 
    
    // 판매 처리하기
    this.money += count * PRICE;
    this.count -= count;
    
    // 반환
    return new BreadChange(count, money - count * PRICE);
    
  }
  
}
