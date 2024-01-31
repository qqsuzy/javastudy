package practice05_Bakery;

public class Customer {
  
  // field
  private int money;
  private int count; // 구매한 빵을 저장

  public Customer() {

  }
  public Customer(int money, int count) {
    super();
    this.money = money;
    this.count = count;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
  
  // 구매
  // 인자 : 구매할 가게, 구매할 빵 개수, 구매할 때 낼 돈
  // 반환 : 없음 (구매자 입장에서 반환할 값이 없다. 필드값의 조작으로 끝난다.)
  public void buy(Bakery bakery, int count, int money) {
    
    // 빵집의 사정은 구매자는 고려를 하지 않는다. (Bakery 클래스의 sell 메소드 활용!)
    // 가진 돈이 부족하다.
    if(this.money < money) {
      System.out.println("가진 돈이 부족합니다.");
      return;
    }
   
    // 구매 (곧 Bakery의 판매를 의미한다.)
    BreadChange breadChange = null;       // bakery가 null인 경우
    if(bakery != null) {
     breadChange = bakery.sell(money, count); 
    }
    
    // 구매 결과 처리
    if(breadChange != null) {
    this.count += breadChange.getBread();
    this.money += breadChange.getChange();
    this.money -= money;        
   }
  
  }

}