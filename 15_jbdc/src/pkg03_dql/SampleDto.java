package pkg03_dql;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * DTO
 * 1. Data Transfer Object
 * 2. 데이터베이스의 데이터를 자바와 주고 받을 때(통신할 때) 사용하는 객체이다.
 * 3. 기본적으로 테이블 하나당 DTO 하나를 만든다.
 * 4. 필드는 칼럼에 매칭하고 생성자와  Getter/Setter 를 만든다. 
 * 5. Lombok 라이브러리 : 생성자, Getter/Setter
 * 
 *    1) Lombok 다운로드 받기
 *    2) 다른 .jar 파일과 다르기 build Path 전에 설치가 필요하다.
 *    3) 일반 설치방법(C 드라이브 설치) 과 다르게 이클립스에 설치 해야한다.
 *    4) jar 폴더 내에서 cmd로 java -jar lombok.jar 입력하여 실행을 진행한다.
 *    5) 설치방법
 *        (1) cmd 열기
 *        (2) cd 경로(C:\GDJ77\jar)     -> cd : 폴더 바꾸기 명령어
 *        (3) java -jar lombok.jar 입력
 *        (4) Installer 화면 뜨면 Specify location 클릭하여 이클립스 경로 설정하기 (eclipse.exe)
 *        (5) 설치 완료 후 이클립스 재실행 필요
 *        
 *        * 오류
 *        - 경로가 한글 또는 공백이 있으면 설치오류가 발생한다.
 *        - 해결 방법
 *           1) eclipse.ini 에서 javaagent 값을 지우고 메모장 저장 
 *           2) 이클립스 파일 내에 lombok.jar 가 있다면 삭제한다.
 *           3) 경로명 재설정 후 재설치를 진행한다.
 */

// lombok 사용하여 생성자, Getter/Setter 생성
// annotation 은 순서는 없다.
@ToString           /* toString() */ 
@NoArgsConstructor  /* default constructor     : 인자가 없는 생성자 */
@AllArgsConstructor /* constructor using field : 모든 인자 값을 받아오는 생성자 */
@Getter
@Setter             // 장점 : 이전 생성법과 다르게 field 가 변경되어도 삭제하고 재생성하지 않아도 된다.

// Low?쿼리? 와 동일하게 field 를 생성
public class SampleDto {
  private int sample_no;        // 변수명이 자바 네이밍에는 어긋나지만 sql 네이밍에 맞게 설정한다.
  private String sample_content;
  private String sample_editor;
  private Date sample_dt;       // 자바의 Date 타입 -> 오라클 타입과 매칭되는 자바의 데이터 타입을 가지고 있다. (java.sql) ex) Date, Timestamp
  
}
