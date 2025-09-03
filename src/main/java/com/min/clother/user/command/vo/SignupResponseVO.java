package com.min.clother.user.command.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignupResponseVO {
    private String email;
    private String name;
    private String userId;
}
