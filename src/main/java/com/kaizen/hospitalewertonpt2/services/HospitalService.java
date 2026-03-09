package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import com.kaizen.hospitalewertonpt2.repositories.HospitalRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public Hospital saveHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = new Hospital();
        hospital.setName(hospitalDTO.getName());
        hospital.setCnpj(hospitalDTO.getCnpj());
        hospital.setHospitalPhone(hospitalDTO.getPhone());

        if (hospital.getWards() != null) {
            for (WardDTO wardDTO : hospitalDTO.getWards()) {
                Ward ward = new Ward();
                ward.setSpeciality(wardDTO.getSpeciality());
                ward.setNumbersRooms(wardDTO.getNumbersRooms());
                ward.setNumbersBeds(wardDTO.getNumbersBeds());

                // 3. Vinculamos ao hospital usando o método utilitário
                hospital.addWard(ward);
            }
        }
        return hospitalRepository.save(hospital);
    }

    public List<Hospital> getAllHospitals() {return hospitalRepository.findAll();}
}
