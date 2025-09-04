package com.min.clother.likes.query.mapper;

import com.min.clother.likes.query.dto.LikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeMapper {
    List<LikeDTO> findLikedItemsByUserId(@Param("userId") int userId);

    int checkUserLiked(@Param("userId") int userId,
                       @Param("type") String type,
                       @Param("targetId") int targetId);
}