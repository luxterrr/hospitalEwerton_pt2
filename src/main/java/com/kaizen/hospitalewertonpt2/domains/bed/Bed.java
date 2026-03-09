package com.kaizen.hospitalewertonpt2.domains.bed;

import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_bed")
@Data

public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bedId;

    private StatusBed statusBed;
    private Integer bedNumber;
    private Integer bedQuantity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
