package com.min.clother.post.command.application.service;

import com.min.clother.post.command.domain.aggregate.HairTagEntity;
import com.min.clother.post.command.domain.aggregate.PostEntity;
import com.min.clother.post.command.domain.aggregate.PostImageEntity;
import com.min.clother.post.command.domain.aggregate.PostLookTagEntity;
import com.min.clother.post.command.domain.aggregate.TagEntity;
import com.min.clother.post.command.domain.repository.HairTagRepository;
import com.min.clother.post.command.domain.repository.PostImageRepository;
import com.min.clother.post.command.domain.repository.PostLookTagRepository;
import com.min.clother.post.command.domain.repository.PostRepository;
import com.min.clother.post.command.domain.repository.TagRepository;
import com.min.clother.post.command.domain.vo.HairTagVO;
import com.min.clother.post.command.domain.vo.RequestRegistPostVO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandPostServiceImpl implements CommandPostService {

    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final TagRepository tagRepository;
    private final HairTagRepository hairTagRepository;
    private final PostLookTagRepository postLookTagRepository;

    @Autowired
    public CommandPostServiceImpl(PostRepository postRepository
            , PostImageRepository postImageRepository
            , TagRepository tagRepository
            , HairTagRepository hairTagRepository, PostLookTagRepository postLookTagRepository) {
        this.postRepository = postRepository;
        this.postImageRepository = postImageRepository;
        this.tagRepository = tagRepository;
        this.hairTagRepository = hairTagRepository;
        this.postLookTagRepository = postLookTagRepository;
    }

    @Transactional
    @Override
    public void registPost(RequestRegistPostVO newPost, int userId) {
        // PostEntity 생성
        PostEntity postEntity = new PostEntity();
        postEntity.setUserId(userId);
        postEntity.setContent(newPost.getContent());

        // Post 저장 (ID 생성됨)
        PostEntity savedPost = postRepository.save(postEntity);

        // PostImageEntity 리스트 생성
        List<PostImageEntity> imageEntities = newPost.getImageVOs().stream()
                .map(imageVO -> new PostImageEntity(0, savedPost, imageVO.getImageUrl().split("\\?")[0],
                        imageVO.getOrder()))
                .collect(Collectors.toList());

        // PostImage 저장
        postImageRepository.saveAll(imageEntities);

        // 3. 룩 태그 저장
        if (newPost.getLookTagIds() != null) {
            for (Integer lookTagId : newPost.getLookTagIds()) {
                PostLookTagEntity lookTag = new PostLookTagEntity();
                lookTag.setPost(savedPost);
                lookTag.setLookTag(lookTagId);
                postLookTagRepository.save(lookTag);
            }
        }

        // HairTagEntity 생성 및 저장
        if (newPost.getHairTagVO() != null) {
            HairTagVO hairTagVO = newPost.getHairTagVO();
            HairTagEntity hairTagEntity = new HairTagEntity();
            hairTagEntity.setLink(hairTagVO.getHairShopLink());
            hairTagEntity.setName(hairTagVO.getHairShopName());

            // HairTag 저장 후 id 가져오기
            HairTagEntity savedHairTag = hairTagRepository.save(hairTagEntity);

            // TagEntity에 hairTagId 넣기
            TagEntity hairTag = new TagEntity();
            hairTag.setPost(savedPost);
            hairTag.setHairTagId(savedHairTag.getId());
            hairTag.setCategoryId(hairTagVO.getCategoryId());
            hairTag.setPositionX(hairTagVO.getHairTagPositionX());
            hairTag.setPositionY(hairTagVO.getHairTagPositionY());
            tagRepository.save(hairTag);
        }

        // ProductEntity 리스트 생성 및 저장
        if (newPost.getProductTagVOs() != null && !newPost.getProductTagVOs().isEmpty()) {
            List<TagEntity> productTagEntities = newPost.getProductTagVOs().stream()
                    .map(productTagVO -> {
                        TagEntity tagEntity = new TagEntity();
                        tagEntity.setPost(savedPost);
                        tagEntity.setProductId(productTagVO.getProductId());
                        tagEntity.setCategoryId(productTagVO.getCategoryId());
                        tagEntity.setPositionX(productTagVO.getProductTagPositionX());
                        tagEntity.setPositionY(productTagVO.getProductTagPositionY());
                        return tagEntity;
                    })
                    .collect(Collectors.toList());
            tagRepository.saveAll(productTagEntities);
        }
    }
}
