package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.Hospital.Hospital;
import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.bed.StatusBed;
import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.repositories.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    public Bed generateBed(Room room, int c) {
        Bed newBed = new Bed();
        newBed.setBedNumber(c); //arrumar gambiarria
        newBed.setStatusBed(StatusBed.UNOCCUPIED);
        newBed.setRoom(room);

        room.addBed(newBed);
        return bedRepository.save(newBed);
    }

    public List<Bed> getAllBeds() {return bedRepository.findAll();}
}
