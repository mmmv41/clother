package com.min.clother.adviceBoard.query.controller;

import com.min.clother.adviceBoard.query.dto.BoardDTO;
import com.min.clother.adviceBoard.query.service.BoardQueryServiceImpl;
import com.min.clother.common.JwtUtil;
import io.jsonwebtoken.Claims;
import io.micrometer.common.util.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@Slf4j
public class BoardQueryController {

    private final BoardQueryServiceImpl boardQueryService;

    public BoardQueryController(BoardQueryServiceImpl boardQueryService) {
        this.boardQueryService = boardQueryService;
    }

    // 게시판 조회
    @GetMapping
    public List<BoardDTO> getBoards(@RequestParam(required = false) String sortBy) {
        return boardQueryService.getBoards(sortBy);
    }

    // 게시물 조회
    @GetMapping("/{PostId}")
    public BoardDTO getBoardById(@PathVariable int PostId) {

        return boardQueryService.getBoardById(PostId);
    }


    // 키워드별 [ (제목순,내용순, 제목+내용순) + 최신순 ]조회
    @GetMapping("/search")
    public List<BoardDTO> searchBoards(@RequestParam(required = false) String sortBy,
                                       @RequestParam(required = false) String keyword) {

        if (StringUtils.isBlank(keyword)) { // null 또는 빈 문자열 체크
            return boardQueryService.getBoards(sortBy);
        }
        return boardQueryService.searchBoards(sortBy, keyword);
    }
}

