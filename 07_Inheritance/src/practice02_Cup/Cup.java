package practice02_Cup;

public class Cup {

    // 동적 바인딩  (호출과 실행이 다르다.)
    // 호출 : coffee
    // 실행 : Americano
    
    // Coffee coffee = new Americano();
    // coffee.whoami();
    
    // 바인딩 : 연결
    // 컴파일 할 때는 coffee 를 보지만 run으로 넘어가면 new를 보고 바인딩을 끊고 Americano로 연결 및 실행한다.
    
    //filed
    private Coffee coffee;
 
    public void fill(Coffee coffee) { // setter = fill
      this.coffee = coffee;
    }
    
    public void whoami() {
      coffee.whoami(); 
    }
  }
  

