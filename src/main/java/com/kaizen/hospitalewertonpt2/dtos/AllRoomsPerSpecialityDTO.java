package com.kaizen.hospitalewertonpt2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllRoomsPerSpecialityDTO {

    private String speciality;
    private Integer freeRooms;
    private Integer occupiedRooms;
    private Integer totalRooms;
}
