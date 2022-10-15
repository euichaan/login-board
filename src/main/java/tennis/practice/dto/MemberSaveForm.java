package tennis.practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSaveForm {

  @NotNull
  @Size(min = 8, max = 15, message = "아이디는 8 ~ 20자 이내여야 합니다.")
  private String loginId;

  @NotNull @Size(min = 8, max = 30, message = "비밀번호 8 ~ 30자 이내여야 합니다.")
  private String password;

  @NotNull @Size(min = 2, max = 10, message = "닉네임은 2~10 자 이내여야 합니다.")
  private String nickname;

  @NotNull @Email @Size(max = 50, message = "이메일은 최대 50자 입니다.")
  private String email;

}
