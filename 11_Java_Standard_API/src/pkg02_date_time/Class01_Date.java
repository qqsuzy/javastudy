package pkg02_date_time;

import java.util.Date;

public class Class01_Date {

  public static void main(String[] args) {
    
    // java.util
    Date date1 = new Date();   // 지금 (now)
    System.out.println(date1);
    
    Date date2 = new Date( 1000 * 60 * 60 * 24 * 30L);  // TimeStamp (1970-01-01 기준, 1000분의 1초)
    System.out.println(date2); // 1970-01-31 (30일 후)

    
  }

}
