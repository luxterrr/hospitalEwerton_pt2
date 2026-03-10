package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import com.kaizen.hospitalewertonpt2.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private RoomService roomService;

    @Transactional
    public Ward generateWard (WardDTO wardDTO, Hospital hospital) {
        Ward newWard = new Ward();
        newWard.setSpeciality(wardDTO.getSpeciality());
        newWard.setNumbersRooms(wardDTO.getNumbersRooms());
        newWard.setNumbersBedsperRoom(wardDTO.getNumbersBedsperRoom());
        newWard.setHospital(hospital);

        if (wardDTO.getNumbersRooms() > 0) {
            for (int i = 1; i <= wardDTO.getNumbersRooms(); i++) {
                roomService.generateRoom(newWard, i); //arrumar essa gambiarra feia
            }
        }
        // 3. Vinculamos ao hospital usando o método utilitário
        hospital.addWard(newWard);
        return wardRepository.save(newWard);
    }


}
