package practice04_Car;

public class MainClass {

  public static void main(String[] args) {

    // 생성자 관점
    Driver driver1 = new Driver("elsa", 5); // 현재 만든 생성자는 잘못된 데이터가 전달 될 우려가 있다. career 의 종속 데이터인 bestDriver 값을 받지 않고 career 값에 따라 여부가 달라진다.  
    System.out.println(driver1.isBestDriver());
    
    // 디폴트 형식의 driver2를 만들고 setter를 이용해서 값을 받는다.
    Driver driver2 = new Driver(); 
    driver2.setName("elsa");
    driver2.setCareer(20);
    System.out.println(driver2.isBestDriver());
    
    Car car = new Car(driver2, 0, 100);
    car.enginStart();
    car.accelerator(5);
    car.brake(5);
    
  }

}
