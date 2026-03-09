package com.kaizen.hospitalewertonpt2.domains.admission;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_admission")
@Data

public class AdmissionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    private LocalDateTime date;

}
