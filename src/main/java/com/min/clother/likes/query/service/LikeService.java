package com.min.clother.likes.query.service;

import com.min.clother.likes.query.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    List<LikeDTO> getUserLikes(int userId);

    boolean hasUserLiked(int userId, String type, int targetId);
}
