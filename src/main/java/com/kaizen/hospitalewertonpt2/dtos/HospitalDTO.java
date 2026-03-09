package com.kaizen.hospitalewertonpt2.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO {

    private String name;
    private String cnpj;
    private String phone;
    private List<WardDTO> wards;
}
