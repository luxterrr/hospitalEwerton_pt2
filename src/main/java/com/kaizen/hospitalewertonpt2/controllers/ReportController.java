package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.dtos.BedReportDTO;
import com.kaizen.hospitalewertonpt2.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/admittedpatient/{patientId}")
    public ResponseEntity<String> admittedReport (@PathVariable Long patientId) throws Exception {
        return ResponseEntity.ok(reportService.admittedReport(patientId));
    }

    @GetMapping("/reportBed/{bedId}")
    public ResponseEntity<List<BedReportDTO>> bedReport (@PathVariable Long bedId) throws Exception {
        return ResponseEntity.ok(reportService.bedReport(bedId));
    }
}
