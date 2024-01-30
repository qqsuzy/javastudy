package pkg02_dml;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TalkDto {

  //field
  private int talk_no;
  private String talk_content;
  private String talk_user;
  private Timestamp written_at;
  
}
