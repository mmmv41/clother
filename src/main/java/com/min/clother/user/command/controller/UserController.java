package com.min.clother.user.command.controller;

import com.min.clother.security.dto.TokenDTO;
import com.min.clother.security.service.AuthService;
import com.min.clother.security.vo.LoginRequestVO;
import com.min.clother.user.command.service.UserService;
import com.min.clother.user.command.vo.SignupRequestVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    // 기능 : 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody @Valid SignupRequestVO signupRequestVO) {
        return ResponseEntity.ok(userService.registerUser(signupRequestVO));
    }

    // 기능 : 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginRequestVO loginRequestVO) {
        return ResponseEntity.ok(authService.login(loginRequestVO));
    }
}
