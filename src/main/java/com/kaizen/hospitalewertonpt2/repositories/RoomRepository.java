package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
