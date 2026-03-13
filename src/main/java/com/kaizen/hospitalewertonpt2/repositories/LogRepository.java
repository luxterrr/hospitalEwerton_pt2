package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.log.Log;
import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import com.kaizen.hospitalewertonpt2.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query ("SELECT NEW com.kaizen.hospitalewertonpt2.dtos.AdmittedReportDTO (" +
            " l.patient.bed.room.ward.hospital.name, l.patient.bed.room.ward.speciality," +
            " l.patient.bed.room.roomCode, l.patient.patientName, l.timeStamp) " +
            "FROM Log l " +
            "WHERE l.patient.id = :patientId " +
            "AND l.logType = :logType " +
            "ORDER BY l.id DESC " )
    List<AdmittedReportDTO> findLogByPatientId(@Param("patientId") Long patientId, @Param("logType")LogType logType);

    @Query("SELECT NEW com.kaizen.hospitalewertonpt2.dtos.BedReportDTO (" +
            " l.bed.id, l.patient.patientName, l.timeStamp," +
            "(SELECT l2.timeStamp FROM Log l2 WHERE l2.patient.id = l.patient.id " +
            "AND l2.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.DISCHARGE " +
            "AND l2.timeStamp > l.timeStamp ORDER BY l2.timeStamp ASC limit 1))" +
            "FROM Log l " +
            "WHERE l.bed.id = :bedId AND l.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.ADMISSION " +
            "ORDER BY l.timeStamp DESC ")
    List<BedReportDTO> findLogByBedId(@Param("bedId") Long bedId);

    @Query("SELECT NEW com.kaizen.hospitalewertonpt2.dtos.RoomReportDTO (" +
            " r.ward.speciality, r.roomCode )" +
            "FROM Room r " +
            "WHERE r.filled = FALSE " +
            "GROUP BY r.ward.speciality " +
            "ORDER BY r.id DESC ")
    List<RoomReportDTO> findFreeRooms();

    @Query(" SELECT NEW com.kaizen.hospitalewertonpt2.dtos.SpecialityReportDTO (" +
            " b.room.ward.speciality, b.id )" +
            "FROM Bed b " +
            "WHERE b.statusBed = com.kaizen.hospitalewertonpt2.domains.bed.StatusBed.UNOCCUPIED " +
            "GROUP BY b.room.ward.speciality  " +
            "ORDER BY b.room.ward.speciality ASC ")
    List<SpecialityReportDTO> findFreeSpecialities();

    @Query( "SELECT NEW com.kaizen.hospitalewertonpt2.dtos.AllAdmittedReportDTO (" +
            "l.patient.patientName, l.bed.room.ward.speciality, l.timeStamp )" +
            "FROM Log l WHERE l.patient.admitted = TRUE " +
            "AND l.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.ADMISSION " +
            "AND l.bed.statusBed = com.kaizen.hospitalewertonpt2.domains.bed.StatusBed.OCCUPIED " +
            "AND NOT EXISTS (SELECT l2.timeStamp FROM Log l2 " +
            "WHERE l2.patient.id = l.patient.id " +
            "AND l2.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.DISCHARGE " +
            "AND l2.timeStamp > l.timeStamp " +
            "ORDER BY l2.timeStamp ASC LIMIT 1) " +
            "ORDER BY l.patient.patientName, l.bed.room.ward.speciality ASC ")
    List<AllAdmittedReportDTO> findAllAdmittedPatients();

    @Query( "SELECT new com.kaizen.hospitalewertonpt2.dtos.AllRoomsPerSpecialityDTO (" +
            " r.ward.speciality," +
            "CAST(SUM (CASE WHEN r.filled = FALSE THEN 1 ELSE 0 END ) AS int), " +
            "CAST(SUM (CASE WHEN r.filled = TRUE THEN 1 ELSE 0 END ) AS int)," +
            "CAST(COUNT (r.id) AS int)) " +
            "FROM Room r " +
            "GROUP BY r.ward " +
            "ORDER BY r.ward.speciality ASC ")
    List<AllRoomsPerSpecialityDTO> findRoomsPerSpeciality();

    @Query("SELECT NEW com.kaizen.hospitalewertonpt2.dtos.PatientReportDTO (" +
            "l.patient.patientName, l.bed.room.ward.speciality, l.timeStamp," +
            "(SELECT l2.timeStamp FROM Log l2 WHERE l.patient.id = l2.patient.id " +
            "AND l2.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.DISCHARGE " +
            "AND l2.timeStamp > l.timeStamp ORDER BY l2.timeStamp ASC limit 1)) " +
            "FROM Log l " +
            "WHERE l.patient.id = :patientId " +
            "AND l.logType = com.kaizen.hospitalewertonpt2.domains.log.LogType.ADMISSION " +
            "ORDER BY l.timeStamp DESC ")
    Page<PatientReportDTO> findHistoricById(@Param("patientId") Long patientId, Pageable pageable);
}
