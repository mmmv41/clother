package com.min.clother.user.query.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO {
    private int id;        // 회원 id
    private String email;
    private String password;
    private String nickname;
    private String gender;
    private int height;
    private int weight;
    private String role;
    private String bio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isSuspended;
    private Boolean isDeleted;
    private String imageUrl;

}
