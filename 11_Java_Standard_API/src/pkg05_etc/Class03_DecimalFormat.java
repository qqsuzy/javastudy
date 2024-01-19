package pkg05_etc;

import java.text.DecimalFormat;

public class Class03_DecimalFormat {

  public static void main(String[] args) {
    
    // Java 에서 숫자 표기법을 설정하고 싶을 때 사용된다.
    // DB에서는 숫자로만 저장해두고 Java나 .. 에서 보통 가공한다.
    double number = 12345.6789;
    
    DecimalFormat df = new DecimalFormat("#,##0.00"); // 1의 자리는 0으로 사용하는 것이 좋다. 0.5 를 표현할 경우 #,##0.00 은 0.5로 표기되는데 #,###.00은 .5로 표기되기 때문이다.
    System.out.println(df.format(number)); // 따로 올림,내림 설정을 하지 않으면 기본적으로 반올림으로 동작한다.
    
  }

}
