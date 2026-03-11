package com.kaizen.hospitalewertonpt2.dtos;

import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LogDTO {
    Long patientId;
    Long bedId;
    LogType logType;
}
