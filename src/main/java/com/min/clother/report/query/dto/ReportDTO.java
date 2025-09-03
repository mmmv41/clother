package com.min.clother.report.query.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReportDTO {
    private int id;
    private LocalDateTime createdAt;        // 신고날짜
    private String reason;                  // 신고사유
    private String status;            // 신고 승인 여부
    private int reporterId;                 // 신고한 userID
    private int reportedId;                 // 신고당한 userID
    private Integer postId;
    private Integer boardId;
    private Integer commentId;
}
