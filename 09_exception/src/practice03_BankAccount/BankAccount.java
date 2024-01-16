package practice03_BankAccount;

public class BankAccount {

  // field
  private String accNo;
  private long balance;
  
  
 //constructor (생성자, default 형식)
  public BankAccount() {

 }
  
  public BankAccount(String accNo, long balance) {
    this.accNo = accNo;
    this.balance = balance;  
  }
  
  //method
  public String getAccNo() {
    return accNo;
  }

  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  public void deposit(long money) throws RuntimeException {
    
    try {
      
      if(money <= 0) {
        // catch 블록으로 던진다. 
        throw new DepositException(1001);
        
      }
      
      balance += money;
      
    
    } catch (DepositException e) { // DepositException e :  예외 원인 객체(cause)
      
      // deposit 메소드 호출한 곳으로 던진다. (try에 없는 것을 예외처리 하기 위함)
      throw new RuntimeException(money + "원 입금 불가", e); // RuntimeException(String, 예외원인 객체)
    
    }    
    
  }
  
  public long withdrawal(long money) throws RuntimeException { // 예외를 회피하고 가져가기 때문에 자동으로 return 값을 0을 가지고 간다.

    
    try {
      
      if(money <= 0 ) {
        
        throw new WithdrawalException(2001);
        
      }
      if(money > balance) {
        
        throw new WithdrawalException(2002);

      }
      
      balance -= money;
      
    } catch (WithdrawalException e) { // 예외 원인 객체

      String message = null;
      switch(e.getErrorCode()) {
      case 2001 : 
        message = money + "원 출금 불가";
        break;
      case 2002 :
        message = "잔액 부족";
        break;
        
      }
      
      throw new RuntimeException(message, e);  
   
    }
    
    return money;

  }
  
  public void transfer(BankAccount account, long money) throws RuntimeException {
    
    // 내 통장에서 출금 -> 출금된 금액이 반환 -> 네 통장에 입금
    
    // 내 통장에서 출금
    //long a = withdrawal(a);
    //long b = this.withdrawal(money);
   
    // 네 통장에 입금
    //account.deposit(a);
    
    account.deposit(withdrawal(money)); 
    // 안쪽 withdrawal 에서 받은 money 값을 account로 넘긴다.
    // 입금 출금이 가능한지 여부는 윗부분에 withdrawal과 deposit 메소드에서 if문을 통해서 확인 한다.    
  }
  
  
}
