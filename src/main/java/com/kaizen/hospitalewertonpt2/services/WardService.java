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

    public Ward generateWard (WardDTO wardDTO, Hospital hospital) {
        Ward ward = new Ward();
        ward.setSpeciality(wardDTO.getSpeciality());
        ward.setNumbersRooms(wardDTO.getNumbersRooms());
        ward.setNumbersBeds(wardDTO.getNumbersBeds());
        ward.setHospital(hospital);
        if (wardDTO.getNumbersRooms() > 0) {
            ward.getRooms().forEach(room -> ward.getRooms().add(roomService.generateRoom(room, ward)));
        }
        // 3. Vinculamos ao hospital usando o método utilitário
        hospital.addWard(ward);
        return wardRepository.save(ward);
    }


}
