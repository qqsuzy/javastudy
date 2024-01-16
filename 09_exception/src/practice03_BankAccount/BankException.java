package practice03_BankAccount;

public class BankException extends Exception {

  // filed
  private int errorCode;
  
  // constructor
  public BankException(int errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
  
  
}
