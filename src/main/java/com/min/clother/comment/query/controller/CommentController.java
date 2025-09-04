package com.min.clother.comment.query.controller;

import com.min.clother.comment.query.dto.CommentDTO;
import com.min.clother.comment.query.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{type}/{id}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable String type, @PathVariable int id) {
        List<CommentDTO> comment = commentService.getComments(type, id);
        return ResponseEntity.ok(comment);
    }
}
