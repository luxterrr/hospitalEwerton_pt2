package com.kaizen.hospitalewertonpt2.domains.ward;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ward")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        this.rooms.add(room);
        room.setWard(this);
    }
}
