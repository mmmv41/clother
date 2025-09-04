package com.min.clother.post.command.application.service;

import com.min.clother.post.command.domain.vo.RequestRegistPostVO;

public interface CommandPostService {
    void registPost(RequestRegistPostVO newPost, int userId);
}
