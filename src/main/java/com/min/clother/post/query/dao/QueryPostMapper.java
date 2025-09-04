package com.min.clother.post.query.dao;

import com.min.clother.post.query.dto.HairTagDTO;
import com.min.clother.post.query.dto.PostImageDTO;
import com.min.clother.post.query.dto.ProductTagDTO;
import com.min.clother.post.query.dto.ResponsePostDetailDTO;
import com.min.clother.post.query.dto.ResponsePostFeedDTO;
import com.min.clother.post.query.dto.RequestFeedDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryPostMapper {
    // 포스트 피드 조회
    List<ResponsePostFeedDTO> selectFeed(RequestFeedDTO requestFeedDTO);

    // 특정 포스트 조회 시 필요한 쿼리들
    ResponsePostDetailDTO selectPostDetail(int postId);

    List<PostImageDTO> selectPostImages(int postId);

    Boolean selectIsLiked(int postId, int userId);

    List<Integer> selectLookTagIds(int postId);

    List<ProductTagDTO> selectProductTags(int postId);

    HairTagDTO selectHairTag(int postId);
}
