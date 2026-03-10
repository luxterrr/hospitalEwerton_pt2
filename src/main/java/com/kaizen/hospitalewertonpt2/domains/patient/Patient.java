package com.kaizen.hospitalewertonpt2.domains.patient;

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
    private Long patientId;

    private String name;

    @Column(unique = true)
    private String fone;

    @Column(unique = true)
    private String cpf;
}
