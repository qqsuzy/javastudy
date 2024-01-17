package practice02_Cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  // field 
  private List<Product> products;          // 카트에 담은 물건들
  
  // constructor
  public Cart(int cartSize) { // 카트의 담을 수 있는 상품수 제한 
    products = new ArrayList<Product>(cartSize);
  }
  
  // method
  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }


  // 물건 담기
  public void addProduct(Product product) { // 받아오는 매개변수 : product
    
    // 담을 물건이 없는 경우
    if(product == null) {
      System.out.println("카트에 담을 물건이 없습니다.");
      return;
    }
    
    products.add(product);
    
  }
  
  // 물건 바꾸기
  public void changeProduct(int idx, Product product) { // idx 를 product 로 바꾼다. (새로운 물건으로 덮어쓰기 된다.)
    
    // 카트가 비어 있는 경우
    if(products.size() == 0) {
      System.out.println("카트가 비어 있습니다.");
      return;
    }
    
    // 바꿀 물건이 없는 경우
    if(product == null) {
      System.out.println("바꿀 물건이 없습니다.");
      return;
    }
    
    // 존재하지 않는 물건 번호(인덱스)인 경우
    if(idx < 0 || idx >= products.size()) { // idx 음수 불가능하다.
      System.out.println("물건 번호가 잘못되었습니다.");
      return;
      
    }
    
    products.set(idx, product);
    
  }
  
  // 물건 빼기
  public void removeProduct(int idx) {
    
    // 카트에 담긴 물건 개수
    int size = products.size();
    
    // 카트가 비어 있는 경우
    if(size == 0) {
      System.out.println("카트가 비어 있습니다.");
      return;
    }
    
    // 존재하지 않는 물건 번호(인덱스)인 경우
    if(idx < 0 || idx >= size) { 
      System.out.println("물건 번호가 잘못되었습니다.");
      return;
    
  }
    
    products.remove(idx);
  
 }
  
}
