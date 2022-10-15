package tennis.practice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tennis.practice.dto.MemberSaveForm;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member implements Serializable {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @NotNull @Column(unique = true, length = 20)
  private String longinId;

  @NotNull @Column(unique = true, length = 30)
  private String password;

  @NotNull @Column(unique = true, length = 10)
  private String nickname;

  @NotNull @Column(unique = true, length = 50)
  private String email;


  public static Member createMember(MemberSaveForm form) {
    Member member = new Member();
    member.setLonginId(form.getLoginId());
    member.setPassword(form.getPassword());
    member.setNickname(form.getNickname());
    member.setEmail(form.getEmail());
    return member;
  }
}
