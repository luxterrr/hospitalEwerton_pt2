package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import com.kaizen.hospitalewertonpt2.services.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/hospital")
@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<HospitalDTO> createHospital(@RequestBody HospitalDTO base) {
        System.out.println("Hospital: " + base.getName());

        hospitalService.saveHospital(base);
        return ResponseEntity.ok(base);
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = this.hospitalService.getAllHospitals();
        return ResponseEntity.ok(hospitals);
    }
}
