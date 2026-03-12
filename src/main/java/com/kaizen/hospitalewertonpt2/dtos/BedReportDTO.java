package com.kaizen.hospitalewertonpt2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BedReportDTO {

    private Long bedId;
    private String patientName;
    private LocalDateTime admissionTime;
    private LocalDateTime dischargeTime;

    public BedReportDTO(Long bedId, String patientName, LocalDateTime admissionTime) {
        this.bedId = bedId;
        this.patientName = patientName;
        this.admissionTime = admissionTime;
    }
}
