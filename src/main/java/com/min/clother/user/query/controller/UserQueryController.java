package com.min.clother.user.query.controller;

import com.min.clother.user.query.dto.UserDTO;
import com.min.clother.user.query.service.UserQueryService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserQueryController {
    private UserQueryService userQueryService;

    @Autowired
    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    // 회원 검색 ( 닉네임 )
    @GetMapping
    public List<UserDTO> getUsers(@RequestParam("keyword") String keyword) {
        return userQueryService.getUsers(keyword);
    }

    // 회원 조회 ( userId로 )
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable("userId") int userId) {
        return userQueryService.getUser(userId);
    }

}
