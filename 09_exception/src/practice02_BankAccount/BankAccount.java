package practice02_BankAccount;

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
    
   if(money <= 0) {
    throw new RuntimeException( money + "원은 입금이 안됩니다.");
     
   }
   
   balance += money;
   
  }
  
  public long withdrawal(long money) throws RuntimeException {
    
    if(money <= 0 ) {
      throw new RuntimeException(money + "원은 입금이 안됩니다.");
      
    }
      if(money > balance) {
       throw new RuntimeException("잔액이 부족합니다.");
        
      }
     
      balance -= money;
      return money;
   
  }
  
  public void transfer(BankAccount account, long money) throws RuntimeException { // deposit, withdrawal 메소드에서 예외를 던지면 transfer 역시 '나도 던질거다~' 해서 MainClass 에 호출된 영역으로 다시 던진다!
    
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
