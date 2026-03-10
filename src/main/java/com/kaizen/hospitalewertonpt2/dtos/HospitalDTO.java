package com.kaizen.hospitalewertonpt2.dtos;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class HospitalDTO {

    private String name;
    private String cnpj;
    private String hospitalPhone;
    private List<WardDTO> wardDTOS;
}
