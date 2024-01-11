package practice06_Cart;

public class Cart {

  // field
  public final static int CART_SIZE = 10;  // 카트의 담을 수 있는 상품수 = 10개 
  private Product[] products; // 배열 선언 // 카트에 담은 물건들
  private int count;                       // (실제로) 카트에 담은 물건의 개수 (count = 메소드에서 사용될 인덱스) , 인덱스 마다 상품 1개 등록 가능하다.
  
  // constructor
  public Cart(int cartSize) { // 카트의 담을 수 있는 상품수 제한 
   products = new Product[Math.min(cartSize, CART_SIZE)]; // 배열 생성 (배열의 길이는 CART_LENGTH 길이보다 넘지 않도록 min 활용)
  }

  public Cart(Product[] products, int count) {
    super();
    this.products = products;
    this.count = count;
  }

  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
  
  // 물건 담기
  public void addProduct(Product product) { // 받아오는 매개변수 : product
    
    // 카트가 꽉 찬 경우
    if(count == products.length) {
      System.out.println("카트가 가득 찼습니다.");
      return;
    }
    
    if(product == null) {
      System.out.println("카트에 담을 물건이 없습니다.");
      return;
    }
    
    products[count++] = product; // 상품을 count(물건을 담은 개수)에 저장 , 담은 후 후위연산!
    
  }
  
  // 물건 바꾸기
  public void changeProduct(int idx, Product product) { // idx 를 product 로 바꾼다. (새로운 물건으로 덮어쓰기 된다.)
    
    // 카트가 비어 있는 경우
    if(count == 0) {
      System.out.println("카트가 비어 있습니다.");
      return;
    }
    
    // 바꿀 물건이 없는 경우
    if(product == null) {
      System.out.println("바꿀 물건이 없습니다.");
      return;
    }
    
    // 존재하지 않는 물건 번호(인덱스)인 경우
    if(idx < 0 || idx >= products.length ) { // idx 음수 불가능하다.
      System.out.println("물건 번호가 잘못되었습니다.");
      return;
      
    }
    
    products[idx] = product;
    
  }
  
  // 물건 빼기
  public void removeProduct(int idx) {
    
    // 카트가 비어 있는 경우
    if(count == 0) {
      System.out.println("카트가 비어 있습니다.");
      return;
    }
    
 // 존재하지 않는 물건 번호(인덱스)인 경우
    if(idx < 0 || idx >= products.length ) { 
      System.out.println("물건 번호가 잘못되었습니다.");
      return;
    
  }
   
    /*
     * 물건이 5개(count) 인 경우로 가정
     * 
     * 삭제할 idx  | 복사할 요소의 개수 ( count - idx - 1)
     * 0              4
     * 1              3
     * 2              2
     * 3              1
     * 4              0
     */
    
    // 배열 복사
    System.arraycopy(products, idx + 1, products, idx, count - idx - 1);
    count--; // 상품 빼기
  
 }
  
}
