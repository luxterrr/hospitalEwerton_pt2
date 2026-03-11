package com.kaizen.hospitalewertonpt2.domains.patient;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private boolean admitted = false;

    @Column(unique = true)
    private String patientPhone;

    @Column(unique = true)
    private String cpf;

    @OneToOne
    private Bed bed;
}
