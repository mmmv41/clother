package com.min.clother.post.query.service;

import com.min.clother.post.query.dto.ResponsePostDetailDTO;
import com.min.clother.post.query.dto.ResponsePostFeedDTO;
import com.min.clother.post.query.dto.RequestFeedDTO;
import java.util.List;

public interface QueryPostService {
    List<ResponsePostFeedDTO> getFeed(RequestFeedDTO requestFeedDTO);

    ResponsePostDetailDTO getPostById(int postId, int userId);
}
