package com.kaizen.hospitalewertonpt2.domains.log;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timeStamp;

    private LogType logType;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;
}
