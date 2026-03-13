package com.kaizen.hospitalewertonpt2.dtos;

import com.kaizen.hospitalewertonpt2.domains.ward.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdmittedReportDTO {

    private String hospitalName;
    private SpecialityEnum speciality;
    private String roomCode;
    private String patientName;
    private LocalDateTime timeAdmission;
}
