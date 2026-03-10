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

    public Room generateRoom (Room room, Ward ward) {
        Room newRoom = new Room();
        room.setFull(false);
        //room.setRoomCode(); ver substr
        room.setWard(ward);
        ward.addRoom(newRoom);
        return roomRepository.save(newRoom);
    }
}
