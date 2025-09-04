package com.min.clother.adviceBoard.command.application.controller;

import com.min.clother.adviceBoard.command.application.dto.BoardRequestDTO;
import com.min.clother.adviceBoard.command.application.service.BoardCommandService;
import com.min.clother.common.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@Slf4j
public class BoardCommandController {

    private final BoardCommandService boardCommandService;
    private final JwtUtil jwtUtil;


    public BoardCommandController(BoardCommandService boardCommandService, JwtUtil jwtUtil) {
        this.boardCommandService = boardCommandService;
        this.jwtUtil = jwtUtil;
    }

    // 게시물 등록
    @PostMapping("/board")
    // ResponseEntity -- Spring에서 HTTP 응답을 생성하는 객체
    public ResponseEntity<BoardRequestDTO> createBoard(@RequestBody BoardRequestDTO request,
                                                       @RequestHeader(value = "Authorization") String authorizationHeader) {

        // 토큰 파싱해서 userId 꺼내기
        String token = authorizationHeader.replace("Bearer", "").trim();
        Claims claims = jwtUtil.parseJwt(token);
        int userId = ((Number) claims.get("userId")).intValue();

        // userId를 직접 넣어서 저장
        BoardRequestDTO savedBoard = boardCommandService.createBoard(userId,
                request.getTitle(),
                request.getContent(),
                request.getImages());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
    }


    // 게시물 수정
    @PatchMapping("/{PostId}")
    public ResponseEntity<BoardRequestDTO> updateBoard(@PathVariable int PostId,
                                                       @RequestBody BoardRequestDTO request) {

        BoardRequestDTO updated = boardCommandService.updateBoard(PostId, request);
        return ResponseEntity.ok(updated);
    }


    // 게시물 삭제
    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable int boardId) {

        boardCommandService.deleteBoard(boardId);
//        return ResponseEntity.noContent().build();
        return ResponseEntity.ok("게시물이 삭제되었습니다.");
    }

}


