package com.kaizen.hospitalewertonpt2.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PatientDTO {

    private String patientName;
    private String cpf;
    private String patientPhone;
}
