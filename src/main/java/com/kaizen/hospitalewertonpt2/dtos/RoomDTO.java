package com.kaizen.hospitalewertonpt2.dtos;

import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RoomDTO {

    @Min(0)
    private Integer numberRooms;

    @Min(0)
    private Integer numberBedsPerRoom;
}
