package pkg05_etc;

import java.util.UUID;

public class Class02_UUID {

  /*
   * java.util.UUID
   * 1. Universal Unique IDentifier
   * 2. 전역 고유 식별자
   * 3. 형식  
   *    1) 16진수 32개와 하이픈(-) 4개로 구성
   *    2) 12345678 - 1234 - 1234 - 1234 - 1234567890ab (마지막 값만 추출해서 고유 식별자로 활용하기도 한다.)
   */
  
  public static void main(String[] args) {

    // UUID version 3  -> UUID 값이 고정적
    String name = "민수지";
    UUID uuid1 = UUID.nameUUIDFromBytes(name.getBytes()); // getBytes() : byte[] name , byte 타입을 String 타입으로 변환해준다.
    String result1 = uuid1.toString();
    System.out.println(result1);
    
    // UUID version 4 -> UUID 값이 가변적
    UUID uuid2 = UUID.randomUUID();
    String result2 = uuid2.toString();
    System.out.println(result2);
    
  }

}
