package practice03_Member;

public class Address {

  // field
  private String postCode;
  private String roadAddress;
  private String jibunAddress;
  private String detailAddress;
  private String extraAddress;
  private boolean isBasicAddress;
  
  // constructor 생성자 1 (default)
  public Address() { 
    // TODO Auto-generated constructor stub
  }

  // 생성자 2 - field 추가 시 직접 입력하지 말고 constructor using field 로 다시 뽑기!
    public Address(String postCode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress,
    boolean isBasicAddress) {
    super();
    this.postCode = postCode;
    this.roadAddress = roadAddress;
    this.jibunAddress = jibunAddress;
    this.detailAddress = detailAddress;
    this.extraAddress = extraAddress;
    this.isBasicAddress = isBasicAddress;
  }

  // method
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getRoadAddress() {
    return roadAddress;
  }

  public void setRoadAddress(String roadAddress) {
    this.roadAddress = roadAddress;
  }

  public String getJibunAddress() {
    return jibunAddress;
  }

  public void setJibunAddress(String jibunAddress) {
    this.jibunAddress = jibunAddress;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  public String getExtraAddress() {
    return extraAddress;
  }

  public void setExtraAddress(String extraAddress) {
    this.extraAddress = extraAddress;
  }

  // getter 는 boolean 타입의 경우 'is' 로 시작한다.
  // field 변수명을 isㅇㅇㅇ 으로 설정하면 getter에서 isIsBasicAddress 로 만들어지지 않고 자바가 is를 빼고 isBasicAddress로 만들어준다. (setter도 동일함)
  public boolean isBasicAddress() {
    return isBasicAddress;
  }
  
  // setter는 다른 타입과 동일하게 'set' 으로 시작한다.
  public void setBasicAddress(boolean isBasicAddress) {
    this.isBasicAddress = isBasicAddress;
  }

}
