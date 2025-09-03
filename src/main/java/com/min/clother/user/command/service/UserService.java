package com.min.clother.user.command.service;

import com.min.clother.email.dto.EmailCheckDTO;
import com.min.clother.security.vo.LoginResponseVO;
import com.min.clother.user.command.vo.SignupRequestVO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    String registerUser(@Valid SignupRequestVO signupRequestVO);

    LoginResponseVO findMemberInfoById(Long userId);

    LoginResponseVO findMemberInfoByEmail(String email);

    boolean isNicknameExists(String nickname);

    boolean isEmailRegistered(String email);

    ResponseEntity<String> verifyEmailAuthentication(@Valid EmailCheckDTO emailCheckDto);
}
