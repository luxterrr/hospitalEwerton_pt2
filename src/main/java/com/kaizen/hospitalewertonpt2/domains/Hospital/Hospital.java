package com.kaizen.hospitalewertonpt2.domains.Hospital;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_hospital")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    private String name;

    @Column(unique = true)
    private String hospitalPhone;

    @Column(unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ward> wards = new ArrayList<>();

    public void addWard(Ward ward) {
        this.wards.add(ward);
        ward.setHospital(this);
    }

}
