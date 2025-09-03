package com.min.clother.report.query.service;

import com.min.clother.report.query.dto.ReportDTO;
import java.util.List;

public interface ReportService {
    List<ReportDTO> getReports(String sortDirection, String status);

    List<ReportDTO> getOverFiveReportedUsers();
}
