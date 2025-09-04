package com.min.clother.adviceBoard.query.dao;

import com.min.clother.adviceBoard.query.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 조회
    List<BoardDTO> getBoards(@Param("sortBy") String sortBy);

    // 게시물 조회
    BoardDTO getBoardById(@Param("id") int id);

    // 키워드별 조회
    List<BoardDTO> searchBoards(@Param("sortBy") String sortBy, @Param("keyword") String keyword);

}
