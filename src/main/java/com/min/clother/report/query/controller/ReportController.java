package com.min.clother.report.query.controller;

import com.min.clother.report.query.dto.ReportDTO;
import com.min.clother.report.query.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getReports(
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(required = false, defaultValue = "N") String status
    ) {
        return ResponseEntity.ok(reportService.getReports(sortDirection, status));
    }

    @GetMapping("/overFive")
    public ResponseEntity<List<ReportDTO>> getOverFiveReportedUsers() {
        return ResponseEntity.ok(reportService.getOverFiveReportedUsers());
    }

}
