package practice01_BankAccount;

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
  
    // < 메소드 내부에서 직접 예외처리하는 방식>
    // 1. 메소드마다 try - catch 넣기
    // 2. 메소드 호출한 곳으로 예외 던지기 
    
  public void deposit(long money) {
  
  try {
    
    if(money <= 0) {
      throw new RuntimeException(money + "원은 입금이 안됩니다.");
  
    }
    
    balance += money;
    
    } catch(RuntimeException e) {
      System.out.println(e.getMessage()); 
    
  }
    
  }
  
  
  public long withdrawal(long money) {
    
    long retValue = 0L;
    
    try {
      
      if(money <= 0 ) {
       throw new RuntimeException(money + "원은 입금이 안됩니다."); // if문 수행 후 예외 발생 시 retrun을 실행하지 않고 바로 catch로 넘어간다.
        
      }
      if(money > balance) {
        throw new RuntimeException("잔액이 부족합니다.");
        
      }
      
      balance -= money;
      retValue = money;
      
    } catch (RuntimeException e) {
      
      System.out.println(e.getMessage());
      
    }
      
    return retValue; // 예외 발생 시 0L 를 반환한다.
    
  }
  
  
  
  public void transfer(BankAccount account, long money) {
    
    // 내 통장에서 출금 -> 출금된 금액이 반환 -> 네 통장에 입금
    
    // 내 통장에서 출금
    //long a = withdrawal(a);
    //long b = this.withdrawal(money);
   
    // 네 통장에 입금
    //account.deposit(a);
    
    account.deposit(withdrawal(money));  // 각각의 메소드에서 예외처리를 하기 때문에 transfer 메소드에서는 직접 예외처리가 필요 없다.
                                         
    // 안쪽 withdrawal 에서 받은 money 값을 account로 넘긴다.
    // 입금 출금이 가능한지 여부는 윗부분에 withdrawal과 deposit 메소드에서 if문을 통해서 확인 한다.    
  }
  
  
}
