package practice03_BankAccount;

import javax.security.auth.DestroyFailedException;

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
      
      account1.transfer(account2, 50000); // account1 계좌에서 -> account2 계좌로 이체, 50000원 (성공)
      account1.transfer(account2, 100000); // account1 계좌에서 -> account2 계좌로 이체, 100000원 (실패)
      
    } catch (RuntimeException e) {
      
      // catch 블록의 RuntimeException e 로 전달되는 인자들 3가지
      // 1. catch (DepositException e)    { throw new RuntimeException(money + "원 입금 불가", e);
      // 2. catch (WithdrawalException e) { throw new RuntimeException(money + "원 출금 불가", e);
      // 3. catch (WithdrawalException e) { throw new RuntimeException("잔액 부족", e);

      String message = e.getMessage();
      System.out.println(message);                        // 예외 메시지 확인
      
      
      BankException cause = (BankException) e.getCause(); // BankException 타입으로 바꾸는 강제 캐스팅
      System.out.println(cause.getClass().getName());     // 예외클래스 이름 확인하는 코드
      System.out.println(cause.getErrorCode());           // 에러코드 확인
    }

  }

}
