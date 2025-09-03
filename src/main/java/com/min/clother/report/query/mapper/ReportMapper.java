package com.min.clother.report.query.mapper;

import com.min.clother.report.query.dto.ReportDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReportMapper {

    // 신고 조회
    List<ReportDTO> findAllReports(@Param("sortDirection") String sortDirection, @Param("status") String status);

    List<ReportDTO> findOverFiveReportedUsers();
}
