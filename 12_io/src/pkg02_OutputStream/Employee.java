package pkg02_OutputStream;

import java.io.Serializable;

// java.io.ObjectOutputStream 예제용

public class Employee implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8408848800775442149L;
  
  // filed
  private int EmpNo;
  private String name;
  
  // constructor
  public Employee() {

  }

  public Employee(int empNo, String name) {
    super();
    EmpNo = empNo;
    this.name = name;
  }

  public int getEmpNo() {
    return EmpNo;
  }

  public void setEmpNo(int empNo) {
    EmpNo = empNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Employee [EmpNo=" + EmpNo + ", name=" + name + "]";
  }
 
  
}
