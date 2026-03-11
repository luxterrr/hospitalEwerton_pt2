package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.dtos.WardDTO;
import com.kaizen.hospitalewertonpt2.repositories.HospitalRepository;
import com.kaizen.hospitalewertonpt2.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ward")
public class WardController {

    @Autowired
    private WardService wardService;

    @Autowired
    private HospitalRepository hospitalRepository;

    @PostMapping("/{hospitalId}")
    public ResponseEntity<WardDTO> createWard (@RequestBody WardDTO wardDTO, @PathVariable Long hospitalId) throws Exception{
        Hospital foundHospital = hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException("HOSPITAL NOT FOUND"));
        wardService.generateWard(wardDTO, foundHospital);
        return ResponseEntity.ok(wardDTO);
    }
}
