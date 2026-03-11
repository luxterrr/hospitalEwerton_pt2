package com.kaizen.hospitalewertonpt2.repositories;

import com.kaizen.hospitalewertonpt2.domains.log.Log;
import com.kaizen.hospitalewertonpt2.domains.log.LogType;
import com.kaizen.hospitalewertonpt2.domains.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT l FROM Log l " +
            "WHERE l.patient.id = :patientId " +
            "AND l.logType = :logType " +
            "ORDER BY l.id DESC")
    List<Log> findLogByPatientId(@Param("patientId") Long patientId, @Param("logType")LogType logType);
}
