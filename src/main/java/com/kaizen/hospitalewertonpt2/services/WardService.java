package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.RoomDTO;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import com.kaizen.hospitalewertonpt2.repositories.HospitalRepository;
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

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public Ward generateWard (WardDTO wardDTO, Long hospitalId) {

        Hospital foundHospital = hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("HOSPITAL NOT FOUND"));

        Ward newWard = new Ward();
        newWard.setSpeciality(wardDTO.getSpeciality());
        newWard.setHospital(foundHospital);

        // 3. Vinculamos ao hospital usando o método utilitário
        foundHospital.getWards().add(newWard);
        wardRepository.save(newWard);

        if (wardDTO.getNumbersRooms() > 0) {

            roomService.generateRoom(newWard.getId(), new RoomDTO(wardDTO.getNumbersRooms(), wardDTO.getNumbersBedsPerRoom()));
        }
        return newWard;
    }


}
