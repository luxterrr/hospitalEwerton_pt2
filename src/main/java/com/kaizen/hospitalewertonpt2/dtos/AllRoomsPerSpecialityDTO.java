package com.kaizen.hospitalewertonpt2.dtos;

import com.kaizen.hospitalewertonpt2.domains.ward.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllRoomsPerSpecialityDTO {

    private SpecialityEnum speciality;
    private Integer freeRooms;
    private Integer occupiedRooms;
    private Integer totalRooms;
}
