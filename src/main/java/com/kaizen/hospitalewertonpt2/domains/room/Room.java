package com.kaizen.hospitalewertonpt2.domains.room;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_room")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomCode;
    private boolean Full;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Bed> beds = new ArrayList<>();

}
