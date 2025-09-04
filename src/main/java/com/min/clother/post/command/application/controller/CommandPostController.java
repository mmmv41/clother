package com.min.clother.post.command.application.controller;

import com.min.clother.common.JwtUtil;
import com.min.clother.post.command.application.service.CommandPostService;
import com.min.clother.post.command.domain.vo.RequestRegistPostVO;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class CommandPostController {

    private final CommandPostService commandPostService;
    private final JwtUtil jwtUtil;

    @Autowired
    public CommandPostController(CommandPostService commandPostService, JwtUtil jwtUtil) {
        this.commandPostService = commandPostService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("")
    public ResponseEntity<Void> registPost(@RequestHeader(value = "Authorization") String authorizationHeader,
                                           @RequestBody RequestRegistPostVO newPost) {
        // "Bearer " 부분 제거
        String token = authorizationHeader.replace("Bearer", "").trim();
        Claims claims = jwtUtil.parseJwt(token);
        int userId = ((Number) claims.get("userId")).intValue();

        commandPostService.registPost(newPost, userId);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
