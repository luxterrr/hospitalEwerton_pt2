package com.kaizen.hospitalewertonpt2.domains.ward;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_ward")
@Data

public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wardId;

    private String speciality;
    private Integer numbersRooms;
    private Integer numbersBeds;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Ward() {}
}
