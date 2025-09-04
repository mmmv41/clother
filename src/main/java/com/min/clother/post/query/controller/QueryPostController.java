package com.min.clother.post.query.controller;

import com.min.clother.common.JwtUtil;
import com.min.clother.post.query.dto.ResponsePostDetailDTO;
import com.min.clother.post.query.dto.ResponsePostFeedDTO;
import com.min.clother.post.query.dto.RequestFeedDTO;
import com.min.clother.post.query.service.QueryPostService;
import io.jsonwebtoken.Claims;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/post")
@Slf4j
public class QueryPostController {

    private final QueryPostService queryPostService;
    private final JwtUtil jwtUtil;

    @Autowired
    public QueryPostController(QueryPostService queryPostService, JwtUtil jwtUtil) {
        this.queryPostService = queryPostService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponsePostDetailDTO> getPostById(
            @RequestHeader(value = "Authorization") String authorizationHeader,
            @PathVariable int postId) {

        // "Bearer " 부분 제거
        String token = authorizationHeader.replace("Bearer", "").trim();
        Claims claims = jwtUtil.parseJwt(token);
        int userId = ((Number) claims.get("userId")).intValue();

        ResponsePostDetailDTO postDetail = queryPostService.getPostById(postId, userId);
        return ResponseEntity.ok(postDetail);
    }

    @GetMapping("/feed")
    public ResponseEntity<List<ResponsePostFeedDTO>> getFeeds(@ModelAttribute RequestFeedDTO requestFeedDTO) {
        List<ResponsePostFeedDTO> posts = queryPostService.getFeed(requestFeedDTO);
        return ResponseEntity.ok(posts);
    }
}
