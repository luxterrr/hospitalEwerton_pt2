package com.kaizen.hospitalewertonpt2.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class WardDTO {
    private String speciality;
    private Integer numbersRooms;
    private Integer numbersBedsperRoom;
}
