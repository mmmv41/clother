package com.min.clother.adviceBoard.query.service;

import com.min.clother.adviceBoard.query.dto.BoardDTO;

import java.util.List;

public interface BoardQueryService {
    List<BoardDTO> getBoards(String sortBy);

    BoardDTO getBoardById(int postId);

    List<BoardDTO> searchBoards(String sortBy, String keyword);

}
