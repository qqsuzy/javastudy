package practice03_Employee;

public class MainClass {

  public static void main(String[] args) {

    Company company = new Company("Samsung");
    
    new CompanyHandler(company).manage(); // CompanyHandler객체.manage()메소드 호출
    
  }

}
