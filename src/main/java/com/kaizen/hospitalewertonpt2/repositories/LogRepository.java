package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.log.Log;
import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import com.kaizen.hospitalewertonpt2.dtos.BedReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT l FROM Log l " +
            "WHERE l.patient.id = :patientId " +
            "AND l.logType = :logType " +
            "ORDER BY l.id DESC")
    List<Log> findLogByPatientId(@Param("patientId") Long patientId, @Param("logType")LogType logType);

//    @Query("SELECT l FROM Log l " +
//            " WHERE l.bed.id = :bedId " +
//            "ORDER BY l.id ASC ")

    @Query("SELECT new com.kaizen.hospitalewertonpt2.dtos.BedReportDTO (" +
            " l.bed.id, l.patient.patientName, l.timeStamp," +
            "(SELECT l2.timeStamp FROM Log l2 WHERE l2.patient.id = l.patient.id " +
            "AND l2.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.DISCHARGE " +
            "AND l2.timeStamp > l.timeStamp ORDER BY l2.timeStamp ASC limit 1))" +
            "FROM Log l " +
            "WHERE l.bed.id = :bedId AND l.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.ADMISSION " +
            "ORDER BY l.timeStamp DESC ")
    List<BedReportDTO> findLogByBedId(@Param("bedId") Long bedId);
}
