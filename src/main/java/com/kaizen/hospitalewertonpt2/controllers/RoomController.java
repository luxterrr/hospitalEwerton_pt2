package com.kaizen.hospitalewertonpt2.controllers;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.RoomDTO;
import com.kaizen.hospitalewertonpt2.repositories.WardRepository;
import com.kaizen.hospitalewertonpt2.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private WardRepository wardRepository;

    @PostMapping("/{wardId}")
    public ResponseEntity<RoomDTO> createRoom (@RequestBody Integer numbersRooms, @PathVariable Long wardId) throws Exception {
        Ward foundWard = wardRepository.findById(wardId).orElseThrow(() -> new RuntimeException("WARD NOT FOUND"));
        for (int i = 1; i <= numbersRooms; i++) {
            roomService.generateRoom(foundWard, i); //arrumar essa gambiarra feia
        }
        return ResponseEntity.ok();
    }
}
