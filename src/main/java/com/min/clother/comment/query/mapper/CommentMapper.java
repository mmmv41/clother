package com.min.clother.comment.query.mapper;

import com.min.clother.comment.query.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDTO> findCommentByType(@Param("type") String type,
                                       @Param("id") int id);
}
