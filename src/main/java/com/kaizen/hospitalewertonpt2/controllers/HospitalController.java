package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.HospitalDTO;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import com.kaizen.hospitalewertonpt2.services.HospitalService;
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

        // Percorrendo a lista de especialidades enviada
      
        hospitalService.saveHospital(base);
        return ResponseEntity.ok(base);
    }

    @GetMapping
    public List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = this.hospitalService.getAllHospitals();
        return hospitals;
    }
}
