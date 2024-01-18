package practice02_Cart;

public class Customer {

  // field
  private int money; // 고객의 돈
  private Cart cart;  // 고객의 카트(고객 당 카트 1개)
  
  // constructor
  public Customer() { // 돈이 없는 고객
   
  }

  public Customer(int money) { // 고객 당 1개의 카트를 가진다고 가정하고 money만 받는다.
    super();
    this.money = money;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  // method 호출 부분에서 Exception 처리할 수 있는 2가지 방법
  // 1. try - catch
  // 2. throws       ->  다시 회피하기
  
  // 물건 넣기
  public void addToCart(Product product) throws RuntimeException { // 물건(product) 받아온다.
    cart.addProduct(product);
  }
  
  // 물건 바꾸기
  public void changeCart(int idx, Product product) throws RuntimeException {
    cart.changeProduct(idx, product);
  }
  
  // 물건 빼기
  public void removeCart(int idx) throws RuntimeException {
    cart.removeProduct(idx);
  }
  
  // 구매
  // 반환 : 영수증
  public String buy() throws RuntimeException {
    
    String receipt = "영수증\n";
    
    int total = 0;
    
    // 물건을 하나씩 빼서 영수증에 기입
    for(int i = 0, count = cart.getProducts().size(); i < count ; i++) {
     
      // cart 에서 뺀 물건 1개
      Product product = cart.getProducts().get(i);
      
      // 총 구매액 계산
      total += product.getPrice(); // 물건 1개의 가격 누적시킨다.
      
      // 구매 가능 여부 체크
      if(money < total) {
        throw new RuntimeException("구매금액이 부족합니다.");
      }
      
      // 영수증 만들기 (한줄에 하나씩 출력)
      receipt += product.getName();
      receipt += "......";
      receipt += product.getPrice();
      receipt += "\n"; 
      
    }
    
    // 구매
    money -= total;
    
    // 영수증 만들기 추가
    receipt += "총 구매액......" + total + "\n";
    
    return receipt;
    
  }
  
  
  
  
}
