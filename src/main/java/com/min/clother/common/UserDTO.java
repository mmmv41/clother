package com.min.clother.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int userId;
    private String nickname;
    private String imageUrl;
}
