package com.min.clother.user.command.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignupRequestVO {

    @Email
    @NotEmpty(message = "이메일을 입력해 주세요.")
    private String email;

    @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).+$",
            message = "비밀번호는 영문, 숫자, 특수문자를 포함해야 합니다")
    private String password;

    @NotEmpty(message = "닉네임을 입력해 주세요")
    private String nickname;

    @NotEmpty(message = "성별을 선택해 주세요")
    @Pattern(regexp = "M|F", message = "M 또는 F만 입력 가능합니다")
    private String gender;

    private int height;

    private int weight;

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender.toUpperCase();  // 소문자를 대문자로 변환
        }
    }
}
