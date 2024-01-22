package practice03_Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {

  // filed
  private String name;
  private List<Employee> employees; // Regular 와 partTime 모두 포함하는 부모 클래스인 Employee 클래스
//  private Scanner sc;
  
  // constructor
  public Company(String name) {
    this.name = name;
    employees = new ArrayList<Employee>();
  //  sc = new Scanner(System.in);           // 스캐너 생성
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
//
//  public Scanner getSc() {
//   return sc;
//  }
//
//  public void setSc(Scanner sc) {
//  this.sc = sc;
//  }
 
 // Company에서 발생된 예외는 CompanyHandler 로 던진다. 
 // 고용
  public void hire(Employee employee) throws RuntimeException { // 예외발생 시 null 값이 넘어온다.
    if(employee == null) {              // null 값이 아니면 데이터가 저장된다.
      throw new RuntimeException("고용될 사원 정보가 올바르지 않습니다.");
      
    }
    if(employees.contains(employee)) { 
      throw new RuntimeException("이미 등록된 사원 번호입니다.");   
    }
   employee.add(employee);
  }
  
  // 해고
  public void fire(int empNo) { // 번호를 받아서 해고한다.
    if(employees.isEmpty()) {
      throw new RuntimeException("해고할 사원이 없습니다.");
    }
    
    // 사원 조회 2가지 방법 (해고, 조회)
    // 1. int 대 int 비교 -> employees.get(i).getEmpNo() == empNo
    for(int i = 0, size = employees.size(); i < size; i++) { // 사원이 어디있는지 찾아야하기에 for문 돌리기
      if(employees.get(i).getEmpNo() == empNo) {
        employees.remove(i);                     // 현재는 객체 비교가 불가능하기 때문에 int 비교를 한다.
        break;
      } 
    }

 }
  
  // 조회
  public void search(int empNo) {
    if(employees.isEmpty()) {
      throw new RuntimeException("조회할 사원이 없습니다.");
    }
    
    // 2. empNo가 동일하면 객체 vs 객체를 비교하여 equals override  
    Employee searchEmployee = new Employee(empNo, null); // empNo만 비교하기 때문에 name은 null 값이어도 된다.
    for(Employee employee : employees) {  // 향상 for문 (index 몰라도 되기에 해고에 적용한 1번과 다르게 향상 for문 사용가능)
      if(employee.equals(searchEmployee)) {  // 객체 생성 후 equals override 하여 객체 비교가 가능하다. 
        employee.info();
      }
    }
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
