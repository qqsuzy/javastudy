package practice03_Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompanyHandler {

  // field
  private Scanner sc;
  private Company company;
  
  // constructor
  public CompanyHandler(Company company) {
    sc = new Scanner(System.in);
    this.company = company;
  }

  
  // 사원 정보 입력
  private Employee getEmployee() throws InputMismatchException, RuntimeException {
    
    System.out.println("사원타입(1.정규 2.파트) 입력 >>>");
    String type = sc.next();  // 1 또는 2를 입력 받는다.
    
    System.out.println("사원번호 입력 >>>");
    int empNo = sc.nextInt();                            // InputMismatchException 발생될 수 있음                          
    System.out.println("사원명 입력 >>>");
    String name = sc.next();
    
    switch(type) {
    case "1" :                                           // 사원타입(type) 이 1일 때
      System.out.println("연봉 입력 >>>");               
      return new Regular (empNo, name, sc.nextInt());    // Regular 클래스로 값을 return 한다. return 으로 끝나니까 break; 가 필요 없다.
    case "2" :                                           // 사원타입(type) 이 2일 때
      System.out.println("시급 입력 >>>");              
      return new PartTime (empNo, name, sc.nextInt());   // PartTime 클래스로 값을 return 한다.
    default:
      throw new RuntimeException("잘못된 사원타입입니다."); // RuntimeException 
     
    }
    
    // return new Employee(empNo, name); // 입력 받아서 Employee로 넘긴다.
    
  }
  
  // 사원 번호 입력 
  private int getEmpNo() throws InputMismatchException {
    
    System.out.println("사원번호 입력 >>>");
    return sc.nextInt();
   
  }
  
  // 회사 관리
  public void manage() {

    System.out.println("===== 사원관리 프로그램 시작 =====");
    
    while(true) {
      
      try {
      
        System.out.println("\n1. 고용 2.해고 3.조회 4.전체조회 0.프로그램종료 >>>");
        String choice = sc.next();
        switch(choice) {  
        case "1" :
          company.hire(getEmployee());
          break;
        case "2" :
          company.fire(getEmpNo());
          break;
        case "3" :
          company.search(getEmpNo());
          break;
        case "4" :
          company.searchAll();
          break;
        case "0" :
          System.out.println("===== 사원관리 프로그램 종료 =====");
          return;  // 반환 타입이 void이면 return으로 종료시킬 수 있다. (break는 while문 종료)
        default :  
          throw new RuntimeException("잘못된 입력입니다.");
        }
      
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    
    }
    
  }

}



