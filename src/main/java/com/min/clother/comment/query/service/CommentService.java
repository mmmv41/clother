package com.min.clother.comment.query.service;

import com.min.clother.comment.query.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getComments(String type, int id);
}
