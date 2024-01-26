package pkg01_lambda_expr;

public class MainClss {

  public static void main(String[] args) {

    GasStation station = new GasStation();
    station.setTotalOil(1000);        // 주유소 보유 기름량
    station.setChargePerLiter(1500);  // 1리터 당 요금
    
    station.sellOil("모닝", 50);    
    station.sellOil("소나타", 100);
    
    System.out.println("totalOil : " + station.getTotalOil());
    System.out.println("earning : " + station.getEarning());
    
  }

}
