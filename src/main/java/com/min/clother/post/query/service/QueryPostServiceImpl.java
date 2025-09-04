package com.min.clother.post.query.service;

import com.min.clother.post.query.dao.QueryPostMapper;

import com.min.clother.post.query.dto.HairTagDTO;
import com.min.clother.post.query.dto.PostImageDTO;
import com.min.clother.post.query.dto.ProductTagDTO;
import com.min.clother.post.query.dto.ResponsePostDetailDTO;
import com.min.clother.post.query.dto.ResponsePostFeedDTO;
import com.min.clother.post.query.dto.RequestFeedDTO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class QueryPostServiceImpl implements QueryPostService {

    private final QueryPostMapper queryPostMapper;

    @Autowired
    public QueryPostServiceImpl(QueryPostMapper queryPostMapper) {
        this.queryPostMapper = queryPostMapper;
    }

    @Override
    public List<ResponsePostFeedDTO> getFeed(RequestFeedDTO requestFeedDTO) {
        return queryPostMapper.selectFeed(requestFeedDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponsePostDetailDTO getPostById(int postId, int userId) {
        // 포스팅, 유저 정보
        ResponsePostDetailDTO postDetailDTO = queryPostMapper.selectPostDetail(postId);

        // 포스팅 이미지들
        List<PostImageDTO> imagesData = queryPostMapper.selectPostImages(postId);
        postDetailDTO.setImagesData(imagesData);

        // 좋아요 여부
        Boolean isLiked = queryPostMapper.selectIsLiked(postId, userId);
        postDetailDTO.setLiked(Boolean.TRUE.equals(isLiked));

        // 룩 태그 ids
        List<Integer> lookTagIds = queryPostMapper.selectLookTagIds(postId);
        if (lookTagIds != null && !lookTagIds.isEmpty()) {
            postDetailDTO.setLookTagIds(lookTagIds);
        }

        // 상품 태그들
        List<ProductTagDTO> productTags = queryPostMapper.selectProductTags(postId);
        if (productTags != null && !productTags.isEmpty()) {
            postDetailDTO.setProductTags(productTags);
        }

        // 헤어 태그
        HairTagDTO hairTag = queryPostMapper.selectHairTag(postId);
        if (hairTag != null) {
            postDetailDTO.setHairTag(hairTag);
        }

        return postDetailDTO;
    }
}