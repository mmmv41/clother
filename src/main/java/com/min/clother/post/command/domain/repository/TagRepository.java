package com.min.clother.post.command.domain.repository;

import com.min.clother.post.command.domain.aggregate.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
}
