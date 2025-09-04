package com.min.clother.post.query.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponsePostDetailDTO {
    int id; // post id
    String content; // post 내용
    int likeCount; // 좋아요 개수
    int commentCount; // 댓글 개수
    LocalDateTime createdAt; // 작성 날짜

    List<PostImageDTO> imagesData; // 포스팅 사진들 정보
    List<Integer> lookTagIds; // 룩 태그 id들

    boolean liked; // 사용자의 좋아요 여부

    int userId; // 포스팅한 유저의 id
    String userNickname; // 포스팅한 유저의 닉네임
    String userProfileImageUrl; // 포스팅한 유저의 프로필 이미지 URL
    Integer userHeight; // 포스팅한 유저의 키
    Integer userWeight; // 포스팅한 유저의 몸무게

    List<ProductTagDTO> productTags; // 상품 태그들 정보
    HairTagDTO hairTag; // 헤어 태그 정보
}
