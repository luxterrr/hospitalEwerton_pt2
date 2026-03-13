package com.kaizen.hospitalewertonpt2.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HospitalDTO {

    @NotNull
    private String name;

    @Min(0)
    private String cnpj;

    @Min(0)
    private String hospitalPhone;

    private List<WardDTO> wardDTOS;
}
