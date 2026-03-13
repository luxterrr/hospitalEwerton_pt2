package com.kaizen.hospitalewertonpt2.dtos;

import com.kaizen.hospitalewertonpt2.domains.ward.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialityReportDTO {

    private SpecialityEnum speciality;
    private Long bedId;
}
