package practice01_Board;

public class BoardVo {

  // field
  private int boardNo;
  private String title;
  private String writer;
  private String createAt; // 실무에서도 날짜,시간은 String 타입으로 많이 사용한다.
  
  // constructor
  public BoardVo() {

  }

  public BoardVo(int boardNo, String title, String writer, String createAt) {
    super();
    this.boardNo = boardNo;
    this.title = title;
    this.writer = writer;
    this.createAt = createAt;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getCreateAt() {
    return createAt;
  }

  public void setCreateAt(String createAt) {
    this.createAt = createAt;
  }

  @Override  // 일반적인 Vo는 모두 toSting 메소드를 가지고 있다.
  public String toString() {
    return "BoardVo [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", createAt=" + createAt + "]";
  }
  
  
  
}
