package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.bed.Bed;
import com.kaizen.hospitalewertonpt2.domains.bed.StatusBed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed,Long> {

    @Query("SELECT b FROM Bed b " +
            "WHERE b.room.id = :roomId " +
            "AND b.statusBed = :status ")
    List<Bed> findOccupiedBedsByRoom(@Param("roomId") Long roomId, @Param("status")StatusBed status);

    @Query("SELECT b FROM Bed b WHERE b.room.id = :roomId")
    List<Bed> findAllBedsbyRoom(@Param("roomId") Long roomId);

}
