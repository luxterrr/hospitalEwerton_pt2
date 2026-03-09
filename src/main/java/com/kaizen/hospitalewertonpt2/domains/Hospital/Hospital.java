package com.kaizen.hospitalewertonpt2.domains.Hospital;

import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_hospital")
@Data

public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    private String name;

    @Column(unique = true)
    private String hospitalPhone;

    @Column(unique = true)
    private String cnpj;

    @OneToMany
    private List<Ward> wards = new ArrayList<>();

    public void addWard(Ward ward) {
        this.wards.add(ward);
        ward.setHospital(this);
    }

}
