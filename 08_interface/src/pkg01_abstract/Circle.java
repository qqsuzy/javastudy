package pkg01_abstract;

public class Circle extends Shape {

  // field
  private double x;
  private double y;
  private double radius;
  
  // constructor
  public Circle() {
   // super();  : Shape() {} 생성자 호출, 디폴트 생성자는 호출을 생략할 수 있다.
  }

  public Circle(String name, double x, double y, double radius) {
    super(name); // Shape(String name) { } 생성자(부모) 호출 : 이름을 받아와서 super 클래스의 생성자에게 값을 전달
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  // method
  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  /*
   * 추상 메소드는 반드시 오버라이드 해야한다. (강제적)
   */
  
  
  // 넓이
  @Override
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }
  
  // 둘레
  @Override
  public double getCircum() {
    return 2 * Math.PI * radius;
  }

 
}
