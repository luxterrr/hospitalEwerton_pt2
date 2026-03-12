package com.kaizen.hospitalewertonpt2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientReportDTO {

    private String patientName;
    private String speciality;
    private LocalDateTime admissionTime;
    private LocalDateTime dischargeTime;
}
