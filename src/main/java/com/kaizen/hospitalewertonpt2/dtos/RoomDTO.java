package com.kaizen.hospitalewertonpt2.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RoomDTO {

    private String roomCode;
    private boolean filled = false;
}
