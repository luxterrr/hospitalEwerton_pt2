package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import com.kaizen.hospitalewertonpt2.dtos.PatientDTO;
import com.kaizen.hospitalewertonpt2.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient (@RequestBody PatientDTO patientDTO) {
        patientService.savePatient(patientDTO);
        return ResponseEntity.ok(patientDTO);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = this.patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }
}