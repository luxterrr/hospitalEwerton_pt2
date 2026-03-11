package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.bed.StatusBed;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.dtos.PatientDTO;
import com.kaizen.hospitalewertonpt2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Patient findPatientById(Long id) throws Exception {
        return this.patientRepository.findById(id).orElseThrow(() -> new RuntimeException("PATIENT NOT FOUND"));
    }

    public boolean validatePatient(Patient sickPatient) {
        if (!sickPatient.isAdmitted()) {
            return true;
        }else return false;
    }

    public List<Patient> getAllPatients() {return patientRepository.findAll();}
}
