package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.dtos.PatientDTO;
import com.kaizen.hospitalewertonpt2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient (PatientDTO patientDTO) {
        Patient newPatient = new Patient();
        newPatient.setPatientName(patientDTO.getPatientName());
        newPatient.setPatientPhone(patientDTO.getPatientPhone());
        newPatient.setCpf(patientDTO.getCpf());
        return patientRepository.save(newPatient);
    }
}
