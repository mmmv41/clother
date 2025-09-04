package com.min.clother.likes.command.application.controller;

import com.min.clother.likes.command.application.dto.LikeDTO;
import com.min.clother.likes.command.application.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeRegistController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Void> createLike(@RequestBody LikeDTO likeDTO) {
        likeService.createLike(likeDTO);
        return ResponseEntity.ok().build(); // or 201 Created
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable int id) {
        likeService.deleteLike(id);

        return ResponseEntity.noContent().build(); // 204 No Content 응답 반환
    }

}
