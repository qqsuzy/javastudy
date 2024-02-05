package pkg02_two;

public class MainClass {
  
  public static void method1() {

    /*
     * 2차원 배열
     * 1. 1차원 배열이 여러 개 모인 자료 구조이다.
     * 2. 1차원 배열 여러 개를 같은 이름으로 관리한다.
     * 3. 행과 열의 집합체인 테이블 구조로 이해를 하면 된다.
     * 4. 사용하는 인덱스가 2개(행, 열)이다.
     */
    
    /*
     * 2차원 배열의 선언과 생성
     * 1. 선언
     *    1) int[][] 배열이름 - 브라켓 2개 : 추천!
     *    2) int 배열이름 [][]
     *    
     * 2. 생성
     *    1) new int[m][n] - 길이가 n인 1차원 배열이 m개 있는 배열 (고정형 배열 생성 방법)
     *    2) new int[m][?] - 길이가 ?인 1차원 배열이 m개 있는 배열 (몇개 나올지 모르겠고 여러개 나올 것 같을 때 / ?는 나중에 결정함) 
     */
    
    // 배열 선언
    int[][] arr;
    
    // 배열 생성
    arr = new int[2][3]; // 길이가 3인 1차원 배열이 2개 생기고 arr로 넘겨준다.
    
    // 배열 요소(배열이름 + 대괄호 2개 + 인덱스 2개)
    
    // 1번째 1차원 배열의 요소 3개
    System.out.println(arr[0][0]); // arr[0] : 첫 번째 배열의 이름
    System.out.println(arr[0][1]); 
    System.out.println(arr[0][2]);
    
    // 2번째 2차원 배열의 요소 3개
    System.out.println(arr[1][0]);
    System.out.println(arr[1][1]);
    System.out.println(arr[1][2]);
    
    // 실제 메모리에 생성된 배열의 갯수는 총 9개 이다. 
    /*
     *  arr     0x100
     *  
     *  arr[0]  0x200
     *  arr[1]  0x300
     * --------------------
     *  arr[0][0]
     *  arr[0][1]
     *  arr[0][2]
     *  
     *  arr[1][0]
     *  arr[1][1]
     *  arr[1][2]
     */
    
  }

  public static void method2() {
    
    // 2차원 배열의 선언 및 생성
    int[][] arr = new int[2][3];
    
    // 1번째 1차원 배열
    System.out.println(arr[0]);        // 참조값
    System.out.println(arr[0].length); // 3
    
    // 2번째 1차원 배열
    System.out.println(arr[1]);        // 참조값
    System.out.println(arr[1].length); // 3
        
    
  }

  public static void method3() {
    
    // 선언 및 생성
    int[][] arr = new int[2][3];
    
    // 1번째 1차원 배열 출력
    for(int j = 0; j < arr[0].length; j++) {
      System.out.println(arr[0][j]);
    }
    
    /* 위와 동일한 코드
    int[] a = arr[0];
    for(int j = 0; j < a.length; j++) {
      System.out.println(a[j]);
     } 
    */
    
    // 2번째 1차원 배열 출력
    for(int j = 0; j < arr[1].length; j++) {
      System.out.println(arr[1][j]);
    }
    
    // 위의 for 2개 합치기
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        System.out.println(arr[i][j]);
      }
    }
    
    // 2차원으로 출력 (크게 틀이 바뀌지 않으므로 그냥 외우기..!!)
    // System.out.printf("%d", 3) : 일정 간격으로 출력? 
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        // System.out.printf("%3d", arr[i][j]);
        System.out.print(String.format("%3d", arr[i][j])); // 추천! (위와 같은 출력 방법)
      }
      System.out.println();
    }
     
  }
  
  public static void method4() {
    
    // 2차월 배열 초기화
    int[][] arr = new int[][] {
      {10, 20, 30},
      {40, 50, 60, 70}
    };
    
    // 2차원으로 출력
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        System.out.print(String.format("%3d", arr[i][j]));
      }
      System.out.println();
    }
    
  }
  
  public static void main(String[] args) {

    method4();
    
  }

}
