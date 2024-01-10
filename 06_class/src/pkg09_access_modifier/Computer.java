package pkg09_access_modifier;

/*
 * Getter
 * 1. 클래스의 필드값을 외부로 반환하는 메소드이다.
 * 2. get + 필드명으로 메소드 이름을 결정해야 한다. (boolean 타입은 is + 필드명)
 */

/*
 * Setter
 * 1. 외부로부터 전달된 값을 필드에 저장하는 메소드이다.
 * 2. set + 필드명으로 메소드이름을 결정해야 한다.
 */

public class Computer {

  // field : 접근제어 private 
  private String model;
  private int price;
  private Calculator calculator;
  
  
  // Source 창 -> using filed
  public Computer(String model, int price, Calculator calculator) {
    super();
    this.model = model;
    this.price = price;
    this.calculator = calculator;
    
  }

  // Source 창 -> getter and setter
  
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Calculator getCalculator() {
    return calculator;
  }

  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }
  
 
  
}
