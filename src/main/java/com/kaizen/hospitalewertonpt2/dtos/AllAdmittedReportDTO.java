package com.kaizen.hospitalewertonpt2.dtos;

import com.kaizen.hospitalewertonpt2.domains.ward.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AllAdmittedReportDTO {

    private String patientName;
    private SpecialityEnum speciality;
    private LocalDateTime admissionDate;
    private Integer daysAdmitted;

    public AllAdmittedReportDTO(String patientName, SpecialityEnum speciality, LocalDateTime admissionDate) {
        this.patientName = patientName;
        this.speciality = speciality;
        this.admissionDate = admissionDate;
    }
}
