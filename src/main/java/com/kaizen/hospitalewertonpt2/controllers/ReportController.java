package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.dtos.*;
import com.kaizen.hospitalewertonpt2.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<AdmittedReportDTO> admittedReport (@PathVariable Long patientId) throws Exception {
        return ResponseEntity.ok(reportService.admittedReport(patientId));
    }

    @GetMapping("/historicbed/{bedId}")
    public ResponseEntity<List<BedReportDTO>> bedReport (@PathVariable Long bedId) throws Exception {
        return ResponseEntity.ok(reportService.bedReport(bedId));
    }

    @GetMapping("/freerooms")
    public ResponseEntity<List<RoomReportDTO>> freeRoomsReport () throws Exception {
        return ResponseEntity.ok(reportService.freeRoomsReport());
    }

    @GetMapping("/freespecialities")
    public ResponseEntity<List<SpecialityReportDTO>> freeSpecialitiesReport() throws Exception {
        return ResponseEntity.ok(reportService.freeSpecialitiesReport());
    }

    @GetMapping("/alladmittedpacients")
    public ResponseEntity<List<AllAdmittedReportDTO>> allAdmittedReport() throws Exception {
        return ResponseEntity.ok(reportService.allAdmittedReport());
    }

    @GetMapping("/allroomsperspeciality")
    public ResponseEntity<List<AllRoomsPerSpecialityDTO>> allRoomsPerSpeciality() throws Exception {
        return ResponseEntity.ok(reportService.findRoomsPerSpeciality());
    }

    @GetMapping("/patienthistoric/{patientId}")
    public ResponseEntity<Page<PatientReportDTO>> patientHistoric (@PathVariable Long patientId, Pageable pageable) throws Exception {
        return ResponseEntity.ok(reportService.patientHistoric(patientId, pageable));
    }
}
