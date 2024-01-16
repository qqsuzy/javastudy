package practice02_BankAccount;

public class MainClass {

  public static void main(String[] args) {

    // 생성자 1
    BankAccount account1 = new BankAccount(); 
    
    
    // Setter (값 저장)
    account1.setAccNo("01098765432");
    account1.setBalance(100000);
    
    // 생성자 2
    BankAccount account2 = new BankAccount("01012345678" , 50000);
    
    ////////
    
    try {
      
      long a;
      account1.deposit(100000); // 10만원 입금 (성공)
      account1.deposit(-50000); // -5만원 입금 (실패)
      
      
      long money;
      money = account1.withdrawal(100000); // 10만원 출금 (성공)
      System.out.println(money);           // 100000 출금된 금액 출력 (실제 출금된 금액 반환)
      money = account1.withdrawal(200000); // 20만원 출금 (실패)
      System.out.println(money);           // 0 (출금된 금액 출력)
      
      /////////
      
      // BankAccount 클래스의 transfer 메소드에서 예외처리를 던지면 받는 곳
      account1.transfer(account2, 50000); // account1 계좌에서 -> account2 계좌로 이체, 50000원 (성공)
      account1.transfer(account2, 100000); // account1 계좌에서 -> account2 계좌로 이체, 100000원 (실패)

    } catch (Exception e) {
      
      System.out.println(e.getMessage());
    
    }
    
  
  }

}
