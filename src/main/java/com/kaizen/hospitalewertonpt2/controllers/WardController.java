package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
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
    public ResponseEntity<Ward> createWard (@RequestBody WardDTO wardDTO, @PathVariable Long hospitalId) throws Exception{
        return ResponseEntity.ok(wardService.generateWard(wardDTO, hospitalId));
    }
}
