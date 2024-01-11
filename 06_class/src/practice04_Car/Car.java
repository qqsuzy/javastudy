package practice04_Car;

public class Car {

  // field
  private Driver driver;
  private int currSpeed; // 현재 자동차의 속도
  private int fuel; // 연료
  public final static int MAX_SPEED = 100; // final(상수) 와 static 작성 순서는 바뀌어도 된다.
                                           // static 의 호출은 클래스로 호출한다. car.MAX_SPEED
  
  // constructor
  public Car() {
    // TODO Auto-generated constructor stub
  }

  public Car(Driver driver, int currspeed, int fuel) {  // MAX_SPEED는 제외된다.
    super();
    this.driver = driver;
    this.currSpeed = currspeed;
    this.fuel = fuel;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public int getCurrspeed() {
    return currSpeed;
  }

  public void setCurrspeed(int currspeed) {
    this.currSpeed = currspeed;
  }

  public int getFuel() {
    return fuel;
  }

  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
  
  // 운전자, 연료가 없으면 시동 실패 메세지 출력
  public void enginStart() { 
    if(driver == null || fuel == 0) {
      System.out.println("시동 실패");
    } else {
      System.out.println("시동 성공");
    }
  }
  
  // 2. method
  //1) 연료가 없을 때, 2) MAX_SPEED에 도달했을 때, 3) 엑셀을 밟지 않을 때 = 메세지 출력 후 -> 값 return
  public void accelerator(int pushTime) {
    
    if(currSpeed == MAX_SPEED) {
      System.out.println("이미 최고 속도입니다.");
      return;
    }
    
    if(fuel == 0) {
      System.out.println("연료가 없습니다.");
      return;
    }
    
    if(pushTime <= 0) {
      System.out.println("accelerator 를 잘 밟으세요.");
      return;
    }
    
    // 1초당 n씩 속도가 증가하는 accelerator (n : bestDriver는 10씩 늘리고 아니면 5씩 증가)
    int n = driver.isBestDriver() ? 10 : 5; // ? : 조건 연산자 (if else 를 대신하는 간단한 연산자)
    currSpeed += (pushTime * n); // 100km 가 넘으면 속도를 100km 까지만 속도를 고정
    
    // Math(수학)에 들어가 있는 메소드들은 전부 static 처리되어 있다.
    currSpeed = Math.min(currSpeed, MAX_SPEED); // 2개의 값을 비교하여 작은 값을 반환 -> 그 값을 currSpeed 로 사용하겠다~
    
    // 위의 코드와 동일하다. (if문)
    // if(currSpeed > MAX_SPEED) {
    //   currSpeed = MAX_SPEED;
    //}
    
    
    // 1초당 1씩 연료가 줄어드는 accelerator
    fuel -= pushTime;
    fuel = Math.max(fuel, 0);
    
    System.out.println("현재 연료량 :" + fuel + ", 현재 속도 : " + currSpeed);
    
  }
  
  // 2. method 
  // 1초당 10씩 속도가 줄어드는 brake
  public void brake(int pushTime) {
    
    if(currSpeed == 0) {
      System.out.println("이미 멈춰있습니다.");
      
    }
    
    if(pushTime <= 0) {
      System.out.println("break 를 잘 밟으세요.");
      return;
    }
    
    currSpeed -= (pushTime * 10);
    currSpeed = Math.max(currSpeed, 0); // 2개의 값을 비교하여 큰 값을 반환 -> 0보다 작으면(음수) 0을 사용하겠다~ 
    
    System.out.println("현재 연료량 :" + fuel + ", 현재 속도 : " + currSpeed);
    
  }
  
  
}

