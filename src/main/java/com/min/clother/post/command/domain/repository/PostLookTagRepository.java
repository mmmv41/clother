package com.min.clother.post.command.domain.repository;

import com.min.clother.post.command.domain.aggregate.PostLookTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLookTagRepository extends JpaRepository<PostLookTagEntity, Integer> {
}
