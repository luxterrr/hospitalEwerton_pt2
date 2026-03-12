package com.kaizen.hospitalewertonpt2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialityReportDTO {

    private String speciality;
    private Long bedId;
}
