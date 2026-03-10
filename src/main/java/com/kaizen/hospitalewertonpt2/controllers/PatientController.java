package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.dtos.PatientDTO;
import com.kaizen.hospitalewertonpt2.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient (@RequestBody PatientDTO teste) {
        patientService.savePatient(teste);
        return ResponseEntity.ok(teste);
    }
}
