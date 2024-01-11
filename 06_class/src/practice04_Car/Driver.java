package practice04_Car;

public class Driver {

  // field
  private String name;
  private int career; // 운전경력
  private boolean bestDriver; // career 가 10 이상이면 true (carrer에 따라 값이 바뀌는 종속 데이터, 의존 데이터)
  
  // constructor
  public Driver() {
    // TODO Auto-generated constructor stub
  }
  
  // constructor
  public Driver(String name, int career) {
    super();
    this.name = name;
    this.career = career;
    this.bestDriver = career >= 10;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCareer() {
    return career;
  }

  public void setCareer(int career) {
    this.career = career;
    this.setBestDriver(career >= 10);
  }

  public boolean isBestDriver() {
    return bestDriver;
  }

  private void setBestDriver(boolean bestDriver) {
    this.bestDriver = bestDriver;
  }
  
  
}
