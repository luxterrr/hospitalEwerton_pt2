package com.kaizen.hospitalewertonpt2.services;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.bed.StatusBed;
import com.kaizen.hospitalewertonpt2.domains.room.Room;
import com.kaizen.hospitalewertonpt2.domains.ward.Ward;
import com.kaizen.hospitalewertonpt2.dtos.RoomDTO;
import com.kaizen.hospitalewertonpt2.repositories.BedRepository;
import com.kaizen.hospitalewertonpt2.repositories.RoomRepository;
import com.kaizen.hospitalewertonpt2.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BedService bedService;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private WardRepository wardRepository;

    public Room generateRoom (Long wardId, RoomDTO room) {

        Ward foundWard = wardRepository.findById(wardId).orElseThrow(() -> new RuntimeException("WARD NOT FOUND"));

        for (int i = 1; i <= room.getNumberRooms(); i++) {

            Room newRoom = new Room();
            newRoom.setRoomCode(this.generateRoomCode(foundWard, foundWard.getRooms()));
            newRoom.setWard(foundWard);

            foundWard.addRoom(newRoom);
            roomRepository.save(newRoom);

            if (room.getNumberBedsPerRoom() > 0) {
                for (int c = 1; c <= room.getNumberBedsPerRoom(); c++) {
                    bedService.generateBed(newRoom, c);
                }
            }

        }

        return null;
    }

    public void checkRoomFilled (Bed bed) {
        if (bedRepository.findAllBedsbyRoom(bed.getRoom().getId()).size() == bedRepository.findBedsByRoomAndStatusBed(bed.getRoom().getId(), StatusBed.OCCUPIED).size()) {
            bed.getRoom().setFilled(true);
        }else bed.getRoom().setFilled(false);
        this.roomRepository.save(bed.getRoom());
    }

    public String generateRoomCode (Ward ward, List<Room> r) {
        String code = "" + (ward.getSpeciality().substring(0, 3).toUpperCase() + "-");
        code += 1 + r.size();
        return code;
    }
}
