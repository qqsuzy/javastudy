package practice02_Watch;

public class Watch {

  //field
  private int hour;
  private int minute;
  private int second;
  
  //constructor
  public Watch() {
    
  }

  public Watch(int hour, int minute, int secound) {
    super();
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  
  public void addHour(int hour) {
    if(hour <= 0) {
      return;
    }
    this.hour += hour; // hour를 누적시킴
    this.hour %= 24;   // 0 ~ 23 사이 값을 가지게 된다. (순환 됨)
  }
  
  public void addMinute(int minute) {
    if(minute <= 0) {
      return;
    }
    this.minute += minute;
    addHour(this.minute / 60); // addHour를 호출해서 나온 값을 addMinute에서 처리하도록 넘긴다. (60분이 넘은 값)
    this.minute %= 60;
  }
  
  public void addSecond(int second) {
    if(second <= 0) {
      return;
    }
     this.second += second;
     addMinute(this.second / 60);
     this.second %= 60; 
  }

  public void see() {
    System.out.println(String.format("%02d:%02d:%02d", hour, minute, second));
  }
  
}
