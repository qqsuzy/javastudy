package practice03_Employee;

public class Employee {
  // 직원 (Employee)  : 모든 직원이 기본으로 empNo, name 가진다.
  // 1. 연봉계약   (Regular)
  // 2. 파트타이머 (
  
  // field
  private int empNo;
  private String name;
  
  // constructor
  public Employee() {

  }

  public Employee(int empNo, String name) {
    super();
    this.empNo = empNo;
    this.name = name;
  }
  
  // method
  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
 
  public void info() {
    System.out.println("사원번호 :" + empNo);
    System.out.println("사원명 :" + name);
  }
  
  
}
