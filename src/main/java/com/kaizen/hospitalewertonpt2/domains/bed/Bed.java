package com.kaizen.hospitalewertonpt2.domains.bed;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_bed")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusBed statusBed;

    private Integer bedNumber;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnoreProperties("beds")
    private Room room;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
