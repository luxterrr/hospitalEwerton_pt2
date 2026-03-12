package com.kaizen.hospitalewertonpt2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AllAdmittedReportDTO {

    private String patientName;
    private String speciality;
    private LocalDateTime admissionDate;
    private Integer daysAdmitted;

    public AllAdmittedReportDTO(String patientName, String speciality, LocalDateTime admissionDate) {
        this.patientName = patientName;
        this.speciality = speciality;
        this.admissionDate = admissionDate;
    }
}
