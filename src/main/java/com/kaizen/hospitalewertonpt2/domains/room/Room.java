package com.kaizen.hospitalewertonpt2.domains.room;

import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_room")
@Data

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomCode;
    private Integer roomQuantity;
    private StatusRoom statusRoom;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

}
