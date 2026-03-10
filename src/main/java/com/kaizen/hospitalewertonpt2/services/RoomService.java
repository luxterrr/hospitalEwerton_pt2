package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.RoomDTO;
import com.kaizen.hospitalewertonpt2.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BedService bedService;

    public Room generateRoom (Ward ward, Integer i) {
        Room newRoom = new Room();
        newRoom.setNumberBed(ward.getNumbersBedsperRoom());
        newRoom.setRoomCode(ward.getSpeciality().substring(0,3).toUpperCase() + "-" + i);
        newRoom.setWard(ward);

        if (ward.getNumbersBedsperRoom() > 0) {
            for (int c = 1; c <= ward.getNumbersBedsperRoom(); c++) {
                bedService.generateBed(newRoom, c);
            }
        }

        ward.addRoom(newRoom);
        return roomRepository.save(newRoom);
    }
}
