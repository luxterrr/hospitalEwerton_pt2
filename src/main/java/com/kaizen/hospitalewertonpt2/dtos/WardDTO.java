package com.kaizen.hospitalewertonpt2.dtos;

import com.kaizen.hospitalewertonpt2.domains.ward.SpecialityEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class WardDTO {

    @NotNull
    private SpecialityEnum speciality;

    @Min(0)
    private Integer numbersRooms;

    @Min(0)
    private Integer numbersBedsPerRoom;
}
