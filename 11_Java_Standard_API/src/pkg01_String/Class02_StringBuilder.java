package pkg01_String;

public class Class02_StringBuilder {

  /*
   *         |  StringBuffer   |  StringBuilder
   * --------|-----------------|------------------       
   *  since  |   JDK 1.0       |   JDK 1.5
   *  thread |   multi thread  |   single thread
   *  speed  |   slow          |    fast 
   * 
   */
  
  public static void main(String[] args) {

    // StringBuilder 객체 생성
    StringBuilder builder = new StringBuilder();
    
    // 문자열 추가하기
    builder.append("바");   // append가 += 을 대체한다.
    builder.append("나");
    builder.append("나");
    
    // String 객체로 바꾸기
    // 1. new String(builder)
    // 2. builder.toString()
    
    String result = builder.toString();
    System.out.println(result);
    
    // 성능상 이점을 위해서 += 말고 append 를 사용해야 한다.
    
  }

}
