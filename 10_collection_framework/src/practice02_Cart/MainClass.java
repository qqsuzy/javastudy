package practice02_Cart;

public class MainClass {
  
  // Main 에서도 회피(throws) 가 가능하다. (끝까지 회피하는 것)
  // jvm 이 받아서 처리를 직접한다.
  
  public static void main(String[] args) {

    try {
      
      // 10000원 가진 고객
      Customer customer = new Customer(10000);
      
      // 10개 물건 담을 수 있는 카트
      Cart cart = new Cart(10);       
      
      // 고객이 카트 가짐
      customer.setCart(cart);
      
      // 고객 쇼핑
      customer.addToCart(new Product("맛동산", 3000));
      customer.addToCart(new Product("양파링", 2000));
      customer.addToCart(new Product("홈런볼", 5000));
      
      customer.changeCart(1, new Product("오땅", 1000));
      customer.removeCart(10);
      
      // 구매하면 영수증이 반환됨
      String receipt = customer.buy();
      
      // 영수증 확인
      System.out.println(receipt);
      
      // 고객 정보 확인
      System.out.println("고객이 가진 돈 :" + customer.getMoney() + "원");
      
    } catch (Exception e) {
      
      System.out.println(e.getMessage()); // 예외발생 메시지 출력
      e.printStackTrace(); // 예외추적
    
    
    }
    
    
    
    
    
  }

}
