package practice03_Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {

  // filed
  private String name;
  private List<Employee> employees; // Regular 와 partTime 모두 포함하는 부모 클래스인 Employee 클래스
  private Scanner sc;
  
  // constructor
  public Company(String name) {
    this.name = name;
    employees = new ArrayList<Employee>();
    sc = new Scanner(System.in);           // 스캐너 생성
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public Scanner getSc() {
    return sc;
  }

  public void setSc(Scanner sc) {
    this.sc = sc;
  }
 
 // Company에서 발생된 예외는 CompanyHandler 로 던진다. 
 // 고용
  public void hire(Employee employee) throws RuntimeException { // 예외발생 시 null 값이 넘어온다.
    if(employee == null) {              // null 값이 아니면 데이터가 저장된다.
      throw new RuntimeException("고용될 사원 정보가 올바르지 않습니다.");
      
    }
  }
  
  // 해고
  public void fire(int empNo) {
    
  }
  
  // 조회
  public void search(int empNo) {
    
  }
  
  // 전체 조회
  public void searchAll() throws RuntimeException {               // employees에 있는 ArrayList 꺼내서 조회한다.
    if(employees.isEmpty()) {
      throw new RuntimeException("조회할 사원이 없습니다.");
    }
    System.out.println("전체 사원 명단");
    System.out.println("---------------");
    for(Employee employee : employees) {
      employee.info();
      System.out.println("---------------");
    }
  }
  
}
