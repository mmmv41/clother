package com.min.clother.likes.query.controller;

import com.min.clother.likes.query.dto.LikeDTO;
import com.min.clother.likes.query.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                     // 이 클래스가 Srping MVC의 REST 컨트롤러
@RequestMapping("/likes")        // 이 컽트롤러의 기본 URL을 /likes로 설정
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {    //@Autowired를 통해 생성자 주입 방식으로
        this.likeService = likeService;                 // LikeService의 인스턴스를 주입 받는다.
    }

    @GetMapping("/user/{userId}")                     // GET 요청을 받아 특정 사용자의 "좋아요"목록을 조회하는 API
    public ResponseEntity<List<LikeDTO>> getUserLikes(@PathVariable("userId") int userId) {    // URL의 {userId} 값을
        List<LikeDTO> likes = likeService.getUserLikes(userId);                                // userId 변수로 받아 사용
        // LikeService를 호출하여 데이터를 조회.
        return ResponseEntity.ok(likes);        // HTTP 200 응답과 함께 조회된 데이터를 반환.
    }

    @GetMapping("/user/{userId}/liked/{type}/{id}")
    public ResponseEntity<Boolean> hasUserLiked(@PathVariable("userId") int userId,
                                                @PathVariable("type") String type,
                                                @PathVariable("id") int targetId) {

        boolean hasLiked = likeService.hasUserLiked(userId, type, targetId);
        return ResponseEntity.ok(hasLiked);
    }
}
