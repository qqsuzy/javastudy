package practice03_Member;

public class MainClass {

  public static void main(String[] args) {

    // 임의의 정보를 가지는 Member 1명을 만들고, 정보 출력하기
    
    // 생성자
    /*
    Address address = new Address();
    Contact contact = new Contact();
    */
    
    /*
    address.setPostCode("123456");
    address.setRoadAddress("서울시 금천구");
    address.setJibunAddress("디지털단지로 63");
    address.setDetailAddress("2층");
    address.setExtraAddress("201호");
    address.isBasicAddress();
    
    contact.setMobile("01012345678");
    */

    // 1) 필드를 이용한 생성자 (생성자의 필드값을 이용)
    Address address = new Address("123456","서울시 금천구", "디지털단지로 63", "2층", "201호", true);
    Contact contact = new Contact("02", "01012345678");
    
    // 2) default 형식의 생성자(필드가 없음) + setter 를 넣어서
    Member member = new Member();
    member.setId("elsa");
    member.setAddress(address);
    member.setContact(contact);
    
    // 3) 정보 출력 : getter 이용 (method 체이닝)
    System.out.println("아이디 :" + member.getId());
    System.out.println("우편번호 :" + member.getAddress().getPostCode());
    System.out.println("도로명 :" + member.getAddress().getRoadAddress());
    System.out.println("지번 :" + member.getAddress().getJibunAddress());
    System.out.println("상세 :" + member.getAddress().getDetailAddress());
    System.out.println("추가 :" + member.getAddress().getExtraAddress());
    System.out.println("기본 주소 여부 :" + member.getAddress().isBasicAddress());
    System.out.println("집전화 :" + member.getContact().getTel());
    System.out.println("휴대전화 :" + member.getContact().getMobile());
    
  }

}
