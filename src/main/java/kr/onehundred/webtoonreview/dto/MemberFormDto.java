package kr.onehundred.webtoonreview.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberFormDto {

    //검증사항에 관한 어노테이션은 충족시키지 못하면 예외를 던짐
    //검증사항 어노테이션, null, "", " " 모두 불허용
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    //검증사항 어노테이션, " "만 허용
    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    //이메일 이외의 형식 불허용
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    //해당하는 길이만 허용
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String password;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;
}