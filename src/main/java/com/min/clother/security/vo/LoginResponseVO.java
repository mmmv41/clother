package com.min.clother.security.vo;

import com.min.clother.user.command.aggregate.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginResponseVO {
    private String email;

    public static LoginResponseVO of(UserEntity userEntity) {
        return new LoginResponseVO();
    }
}
