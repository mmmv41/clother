package com.min.clother.likes.query.service;

import com.min.clother.likes.query.dto.LikeDTO;
import com.min.clother.likes.query.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeMapper likeMapper;

    @Autowired
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public List<LikeDTO> getUserLikes(int userId) {
        return likeMapper.findLikedItemsByUserId(userId);
    }

    @Override
    public boolean hasUserLiked(int userId, String type, int targetId) {
        return likeMapper.checkUserLiked(userId, type, targetId) > 0;
    }
}
