package practice03_BankAccount;

public class DepositException extends BankException {

  // constructor 
  // 필드가 없을 때 생성자 자동생성을 통해 부모(super)생성자를 만들어준다. 
  // Source 메뉴 > Generate Constructor from Superclass
  
  public DepositException(int errorCode) {
    super(errorCode);
    
  }
  public DepositException(String message, int errorCode) {
    super(message, errorCode);
    
  }

}
