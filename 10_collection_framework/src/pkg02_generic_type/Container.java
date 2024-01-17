package pkg02_generic_type;

public class Container <T> {

  // 모든 타입을 저장할 수 있는 Object 타입을 쓸 수도 있지만 캐스팅이 필요하므로 편의를 위해서 제네릭 타입을 사용을 권장한다. 
  
  private T item;

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
  
  
  
}
