package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import com.kaizen.hospitalewertonpt2.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;
    
    @Autowired
    private WardService wardService;

    @Transactional
    public Hospital saveHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = new Hospital();
        hospital.setName(hospitalDTO.getName());
        hospital.setCnpj(hospitalDTO.getCnpj());
        hospital.setHospitalPhone(hospitalDTO.getHospitalPhone());
        hospitalRepository.save(hospital);

        if (hospitalDTO.getWardDTOS() != null) {
            hospitalDTO.getWardDTOS().forEach(wardDTO ->
                    hospital.getWards().add(wardService.generateWard(wardDTO, hospital.getId()))
            );
        }
        return hospital;
    }

    public List<Hospital> getAllHospitals() {return hospitalRepository.findAll();}
}
